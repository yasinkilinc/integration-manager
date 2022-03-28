package tr.com.atez.integration.manager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.atez.integration.manager.config.BusinessConfig;
import tr.com.atez.integration.manager.dto.BeyannameStatus;
import tr.com.atez.integration.manager.entity.*;
import tr.com.atez.integration.manager.repository.ManifestoJPARepository;
import tr.com.atez.integration.manager.service.base.BaseSecServiceImpl;
import tr.com.atez.integration.manager.util.ConversionUtils;
import tr.com.atez.integration.manager.util.DateUtils;
import tr.com.atez.integration.manager.util.DbUtils;
import tr.com.atez.integration.manager.util.ExcelUtils;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class ManifestoServiceImpl extends BaseSecServiceImpl<Manifesto> implements ManifestoService{

    private final ManifestoJPARepository manifestoJPARepository;
    private final BeyannameService beyannameService;
    private final MalzemeExcelService malzemeExcelService;
    private final BeyannameVeriAktarmaService beyannameVeriAktarmaService;
    private final UlkeService ulkeService;
    private final MalzemeTanimService malzemeTanimService;
    private final BeyannameSurecService beyannameSurecService;
    private final OlcuBirimService olcuBirimService;
    private final ConversionService conversionService = DefaultConversionService.getSharedInstance();

    private final BusinessConfig businessConfig;

    public ManifestoServiceImpl(ManifestoJPARepository manifestoJPARepository,
                                BeyannameService beyannameService, MalzemeExcelService malzemeExcelService,
                                BeyannameVeriAktarmaService beyannameVeriAktarmaService, UlkeService ulkeService,
                                MalzemeTanimService malzemeTanimService, BeyannameSurecService beyannameSurecService,
                                OlcuBirimService olcuBirimService, BusinessConfig businessConfig) {
        super(manifestoJPARepository);
        this.manifestoJPARepository = manifestoJPARepository;
        this.beyannameService = beyannameService;
        this.malzemeExcelService = malzemeExcelService;
        this.beyannameVeriAktarmaService = beyannameVeriAktarmaService;
        this.ulkeService = ulkeService;
        this.malzemeTanimService = malzemeTanimService;
        this.beyannameSurecService = beyannameSurecService;
        this.olcuBirimService = olcuBirimService;
        this.businessConfig = businessConfig;
    }


    public void save(Manifesto manifesto, Manifesto.Status successful) {
        manifesto.setStatus(successful);
        manifesto.setRetry(manifesto.getRetry() + 1);
        manifestoJPARepository.save(manifesto);
        log.info("{}", manifesto);
    }

    // @Transactional(propagation = Propagation.REQUIRES_NEW)

    // @Transactional(propagation = Propagation.MANDATORY)
    @Transactional
    public void processFile(InputStream file, HashMap<String, BeyannameStatus> isPoNumberExistsInDb, HashMap<String, List<String>> malzemeKodMap) throws IOException {
        MalzemeExcel malzemeExcel = malzemeExcelService.findMalzemeExcel(businessConfig.getFirmaKod(), businessConfig.getKullaniciKod());
        ArrayList<Map<Integer, Object>> excelArrayList = ExcelUtils.convert(file, malzemeExcel.getMusRefNo2());
        Map<String, Ulke> ulkeMapByKisaAd = ulkeService.findAllByKisaAd();
        Map<String, OlcuBirim> olcuBirimByCms = olcuBirimService.findAllByCms();
        Map<String, MalzemeTanim> malzemeTanimMapByKod = malzemeTanimService.findAllByFirmaId(businessConfig.getFirmaKod());

        List<Map<Integer, Object>> filteredExcelRows  = excelArrayList.stream().filter(row -> {
            String musteriRefNo2 = conversionService.convert(row.get(malzemeExcel.getMusRefNo2()), String.class);
            if (isPoNumberExistsInDb.containsKey(musteriRefNo2)) {
                return false;
            }
            List<BeyannameVeriAktarma> veriAktarma = beyannameVeriAktarmaService.findByMusRefNo2(musteriRefNo2);
            if (!veriAktarma.isEmpty()) {

                BeyannameVeriAktarma beyannameVeriAktarma = veriAktarma.get(0);
                log.info("Searched bva: {}", beyannameVeriAktarma);
                Beyanname beyanname = beyannameService.findByBeyannameId(beyannameVeriAktarma.getBeyannameId());
                log.info("Founded beyanname: {}", beyanname);
                if (beyanname == null) {
                    return true;
                }
                BeyannameStatus beyannameStatus = new BeyannameStatus();
                beyannameStatus.setBeyanname(beyanname);
                beyannameStatus.setStatus(true);
                isPoNumberExistsInDb.put(musteriRefNo2, beyannameStatus);
                return false;
            }
            return true;
        }).collect(Collectors.toList());

        filteredExcelRows.forEach( row -> {

            BeyannameVeriAktarma bva = new BeyannameVeriAktarma();
            Beyanname beyanname = getBeyanname(row, malzemeExcel, isPoNumberExistsInDb, ulkeMapByKisaAd);

            String musteriRefNo2 = conversionService.convert(row.get(malzemeExcel.getMusRefNo2()), String.class);

            LocalDateTime tahminiHareketTarihi = DateUtils.convertZeroTime(row.get(malzemeExcel.getTahminiHareketTarihi()));
            LocalDateTime tahminiVarisTarihi = DateUtils.convertZeroTime(row.get(malzemeExcel.getTahminiVarisTarihi()));

            // createBeyannameSurecETDTarihi( beyanname.getBeyannameId(), musteriRefNo2, tahminiHareketTarihi, isPoNumberExistsInDbEtd);
            // createBeyannameSurecTahminiVarisTarihi(beyanname.getBeyannameId(), musteriRefNo2, tahminiVarisTarihi, isPoNumberExistsInDbVarisTarihi);

            bva.setMusRefNo2(musteriRefNo2);
            bva.setBeyannameId(beyanname.getBeyannameId());

            bva.setAntrepoKalemSiraNo(conversionService.convert( row.get(malzemeExcel.getAntrepoKalemSiraNo()), Integer.class));
            bva.setAtrBelgeNo(conversionService.convert( row.get(malzemeExcel.getAtrBelgeNo()), String.class));
            bva.setAtrBelgeTarihi(DateUtils.convertZeroTime(row.get(malzemeExcel.getAtrBelgeTarihi())));

            bva.setBirimTutar(ConversionUtils.convert(row.get(malzemeExcel.getBirimTutar()), 2));
            bva.setBolum(conversionService.convert( row.get(malzemeExcel.getBolum()), String.class));
            bva.setBosaltmaLimani(conversionService.convert( row.get(malzemeExcel.getBosaltmaLimani()), String.class));
            bva.setBurutAgirlik(ConversionUtils.convert(row.get(malzemeExcel.getBurutAgirlik()), 2));
            bva.setCikisUlkeLimani(conversionService.convert( row.get(malzemeExcel.getCikisUlkeLiman()), String.class));
            bva.setDiibBelgeNo(conversionService.convert( row.get(malzemeExcel.getDiibBelgeNo()), String.class));
            bva.setDiibSatirNo(conversionService.convert( row.get(malzemeExcel.getDiibSatirNo()), String.class));
            bva.setFaturaNo(conversionService.convert( row.get(malzemeExcel.getFaturaNo()), String.class));

            // bva.setFaturaTarih(DateUtils.convertZeroTime( row.get(malzemeExcel.getFaturaTarihi())));
            bva.setFaturaTarih(LocalDateTime.now().with(LocalTime.of(0, 0, 0)));

            bva.setFaturaTutari( ConversionUtils.convert(row.get(malzemeExcel.getFaturaTutari()), 2));
            bva.setFobTutar(ConversionUtils.convert(row.get(malzemeExcel.getFobTutar()), 2));
            bva.setGondericiReferans(conversionService.convert( row.get(malzemeExcel.getGondericiReferans()), String.class));

            bva.setAciklama(conversionService.convert( row.get(malzemeExcel.getAciklama()), String.class));
            String malzemeKodu = conversionService.convert(row.get(malzemeExcel.getMalzemeKodu()), String.class);
            bva.setMalzemeKodu(malzemeKodu);
            bva.setTicariTanim(conversionService.convert( row.get(malzemeExcel.getTicariTanim()), String.class));

            bva.setKapAdet(conversionService.convert(row.get(malzemeExcel.getKapAdet()), Integer.class));
            bva.setKasaNo(conversionService.convert( row.get(malzemeExcel.getKasaNo()), String.class));
            bva.setKonteynerNumara(conversionService.convert( row.get(malzemeExcel.getKonteynerNumara()), String.class));
            bva.setKonsimentoNo(conversionService.convert( row.get(malzemeExcel.getKonsimantoNo()), String.class));

            bva.setMenseiSahBelgeNo(conversionService.convert( row.get(malzemeExcel.getMenseiSahBelgeNo()), String.class));
            bva.setMenseiSahTarihi(DateUtils.convertZeroTime( row.get(malzemeExcel.getMenseiSahTarihi())));

            bva.setMiktar(ConversionUtils.convert(row.get(malzemeExcel.getMiktar()),2));
            bva.setMuafiyet(conversionService.convert( row.get(malzemeExcel.getMuafiyet()), String.class));
            bva.setMusRefNo1(conversionService.convert( row.get(malzemeExcel.getMusRefNo1()), String.class));

            bva.setNetAgirlik(ConversionUtils.convert(row.get(malzemeExcel.getNetAgirlik()), 2));
            bva.setOnStatuBelgeNo(conversionService.convert( row.get(malzemeExcel.getOnStatuBelgeNo()), String.class));
            bva.setOnStatuBelgeTarihi(DateUtils.convertZeroTime( row.get(malzemeExcel.getOnStatuBelgeTarihi())));

            bva.setReferansNo(conversionService.convert( row.get(malzemeExcel.getReferansNo()), String.class));
            bva.setSevkiyatHatti(conversionService.convert( row.get(malzemeExcel.getSevkiyatHatti()), String.class));
            bva.setSevkiyatNo(conversionService.convert( row.get(malzemeExcel.getSevkiyatNo()), String.class));
            bva.setTasiyiciKodu(conversionService.convert( row.get(malzemeExcel.getTasiyiciKodu()), String.class));
            bva.setTedarikciAdi(conversionService.convert( row.get(malzemeExcel.getTedarikciAdi()), String.class));
            bva.setTedarikciKodu(conversionService.convert( row.get(malzemeExcel.getTedarikciKodu()), String.class));

            bva.setTpsBelgeNo(conversionService.convert( row.get(malzemeExcel.getTpsBelgeNo()), String.class));
            bva.setTutar2(ConversionUtils.convert(row.get(malzemeExcel.getTutar2()), 2));
            bva.setUluslarArasiAnlasma(conversionService.convert( row.get(malzemeExcel.getUluslarArasiAnlasma()), String.class));
            bva.setYatirimTesvikBelgeNo(conversionService.convert( row.get(malzemeExcel.getYatirimTesvikBelgeNo()), String.class));
            bva.setYatirimTesvikTarihi(DateUtils.convertZeroTime( row.get(malzemeExcel.getYatirimTesvikTarihi())));
            // bva.setYurtdisiTutar(ConversionUtils.convert(row.get(malzemeExcel.getYurtdisiTutar()), 2));
            // bva.setYurtdisiDiger(ConversionUtils.convert(row.get(malzemeExcel.getYurtdisiDeger()), 2));
            // bva.setYurtdisiDigerDovizi(conversionService.convert( row.get(malzemeExcel.getYurtdisiDegerDovizi())));

            bva.setDovizCinsi( conversionService.convert( row.get(malzemeExcel.getDovizCinsi()), String.class) );
            bva.setTeslimSekli( conversionService.convert( row.get(malzemeExcel.getTeslimsekli()), String.class) );

            String tasimaSekli = conversionService.convert(row.get(malzemeExcel.getTasimasekli()), String.class);
            bva.setTasimasekli( tasimaSekli );

            if( "O".equals( tasimaSekli ) ){
                bva.setGemiAdi(conversionService.convert( row.get(malzemeExcel.getGemiAdi()), String.class));
            }

            bva.setOlcuMiktari(ConversionUtils.convert(row.get(malzemeExcel.getOlcuMiktari()),2));
            bva.setTahminiHareketTarihi( tahminiHareketTarihi);
            bva.setTahminiVarisTarihi( tahminiVarisTarihi);

            MalzemeTanim malzemeTanim = DbUtils.getMalzemeTanim(row.get(malzemeExcel.getMalzemeKodu()), malzemeTanimMapByKod);

            if(null != malzemeTanim){
                bva.setGtip(malzemeTanim.getGtip());
                bva.setAciklama( malzemeTanim.getOrijinalAd() );
                bva.setTicariTanim( malzemeTanim.getTurkceAd() );
            }else {
                List<String> malzemeKodList = null;
                if(malzemeKodMap.containsKey(bva.getMusRefNo2())){
                   malzemeKodList = malzemeKodMap.get(bva.getMusRefNo2());
                }
                if(null == malzemeKodList){
                    malzemeKodList = new ArrayList<>();
                }
                malzemeKodList.add(malzemeKodu);
                malzemeKodMap.put(bva.getMusRefNo2(), malzemeKodList);
            }

            OlcuBirim olcuBirim = DbUtils.getOlcuBirimi(row.get(malzemeExcel.getOlcuBirimi()), olcuBirimByCms);
            if(olcuBirim != null){
                bva.setOlcuBirimi(olcuBirim.getEdiKod());
            }

            OlcuBirim birim = DbUtils.getOlcuBirimi(row.get(malzemeExcel.getBirimi()), olcuBirimByCms);
            if(birim != null){
                bva.setBirimi(birim.getEdiKod());
            }

            Ulke ulke = DbUtils.getUlke(row.get(malzemeExcel.getMenseUlke()), ulkeMapByKisaAd);
            if(ulke != null){
                bva.setMenseUlke(ulke.getEdiKod());
            }

            Ulke ulkeTic = DbUtils.getUlke(row.get(malzemeExcel.getTicYapilanUlke()), ulkeMapByKisaAd);
            if(ulkeTic != null){
                bva.setTicYapilanUlke(ulkeTic.getEdiKod());
            }

            beyannameVeriAktarmaService.save(bva);
            log.info("{}",bva);
        });
    }

    @Override
    public List<Manifesto> findByStatusOrderByCreateDate(Manifesto.Status status) {
        return manifestoJPARepository.findByStatusOrderByCreateDate(status);
    }

    // @Transactional(propagation = Propagation.MANDATORY)
    public Beyanname getBeyanname(Map<Integer, Object> row, MalzemeExcel malzemeExcel, HashMap<String, BeyannameStatus> isPoNumberExistsInDb, Map<String, Ulke> ulkeMapByKisaAd) {
        String musteriRefNo2 = conversionService.convert(row.get(malzemeExcel.getMusRefNo2()), String.class);
        String tasimaSekli = conversionService.convert(row.get(malzemeExcel.getTasimasekli()), String.class);

        if(isPoNumberExistsInDb.containsKey(musteriRefNo2)){
            log.info("musteriRefNo2: {}",musteriRefNo2);
            return isPoNumberExistsInDb.get(musteriRefNo2).getBeyanname();
        }
        Beyanname beyanname = beyannameService.findFirstByDepartmanIdOrderByReferansNoDesc(businessConfig.getDepartmanId());
        beyannameService.detachBeyanname(beyanname);
        beyanname.setBeyannameId(null);
        beyanname.setReferansNo( beyanname.getReferansNo() + 1);
        beyanname.setTeslimSekli( conversionService.convert(row.get(malzemeExcel.getTeslimsekli()), String.class) );
        beyanname.setFaturaDovizTuru(conversionService.convert(row.get(malzemeExcel.getDovizCinsi()), String.class));
        beyanname.setTicYapilanUlke(conversionService.convert(row.get(malzemeExcel.getTicYapilanUlke()), String.class));

        // TODO: simdilik sabit girildi, degistirilecek.
        beyanname.setKullaniciKod(businessConfig.getBeyannameKullaniciKod());

        String cikisUlkesi = conversionService.convert(row.get(malzemeExcel.getCikisUlkeLiman()), String.class);

        if(null != cikisUlkesi){
            String firstTwoChar = cikisUlkesi.substring(0, 2);
            Ulke ulke = ulkeMapByKisaAd.get(firstTwoChar);
            beyanname.setCikisUlke(ulke.getEdiKod());
        }

        String ticYapilanUlke = conversionService.convert(row.get(malzemeExcel.getTicYapilanUlke()), String.class);

        if(null != ticYapilanUlke){
            String firstTwoChar = ticYapilanUlke.substring(0, 2);
            Ulke ulke = ulkeMapByKisaAd.get(firstTwoChar);
            beyanname.setTicYapilanUlke(ulke.getEdiKod());
        }

        if( "G".equals( tasimaSekli ) ){
            beyanname.setCikisAracTipi("4");
            beyanname.setSinirAracTipi("4");
            beyanname.setTasimaSekli("30");
        } else if( "A".equals( tasimaSekli ) ){
            beyanname.setCikisAracTipi("5");
            beyanname.setSinirAracTipi("5");
            beyanname.setTasimaSekli("40");

            String konsimantoNo = conversionService.convert(row.get(malzemeExcel.getKonsimantoNo()), String.class);
            String kontainerNo = conversionService.convert(row.get(malzemeExcel.getKonteynerNumara()), String.class);

            beyanname.setCikisAracNo(konsimantoNo);
            beyanname.setSinirAracNo(kontainerNo);

        } else if( "O".equals( tasimaSekli ) ){
            beyanname.setCikisAracTipi("3");
            beyanname.setSinirAracTipi("3");
            beyanname.setTasimaSekli("10");
        }

        beyanname = beyannameService.save(beyanname);
        log.info(" {} ", beyanname);

        BeyannameStatus beyannameStatus = new BeyannameStatus();
        beyannameStatus.setBeyanname(beyanname);
        beyannameStatus.setStatus(false);

        isPoNumberExistsInDb.put(musteriRefNo2, beyannameStatus);
        return beyanname;
    }

    // @Transactional(propagation = Propagation.MANDATORY)
    public void createBeyannameSurecETDTarihi(String beyannameId,String musteriRefNo2, LocalDateTime tarih, HashSet<String> isPoNumberExistsInDbEtd) {
        if(!isPoNumberExistsInDbEtd.contains(musteriRefNo2)){
            BeyannameSurec beyannameSurec = beyannameSurecService.findByBeyannameIdAndSurecTanimId(UUID.fromString(beyannameId), UUID.fromString(businessConfig.getEtdTarihi()) );
            beyannameSurec.setTarih(tarih);
            beyannameSurecService.save(beyannameSurec);
            isPoNumberExistsInDbEtd.add(musteriRefNo2);
        }
    }

    // @Transactional(propagation = Propagation.MANDATORY)
    public void createBeyannameSurecTahminiVarisTarihi(String beyannameId,String musteriRefNo2, LocalDateTime tarih, HashSet<String> isPoNumberExistsInDbVarisTarihi) {
        if(!isPoNumberExistsInDbVarisTarihi.contains(musteriRefNo2)){
            BeyannameSurec tahminiVarisTarih = beyannameSurecService.findByBeyannameIdAndSurecTanimId(UUID.fromString(beyannameId),  UUID.fromString(businessConfig.getTahminiVarisTarihi()) );
            tahminiVarisTarih.setTarih(tarih);
            beyannameSurecService.save(tahminiVarisTarih);
            isPoNumberExistsInDbVarisTarihi.add(musteriRefNo2);
        }
    }
}
