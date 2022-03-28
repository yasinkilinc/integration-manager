package tr.com.atez.integration.manager.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static tr.com.atez.integration.manager.constant.ApplicationConstants.*;

@Getter
@Setter
@Entity(name = BEYANNAME_VERI_AKTARMA_ENTITY)
@Table(name = BEYANNAME_VERI_AKTARMA)
@ToString(doNotUseGetters = true)
public class BeyannameVeriAktarma implements Serializable {

    @Id
    @GeneratedValue(generator = BEYANNAME_VERI_AKTARMA_GEN_VAL_GEN)
    @GenericGenerator(name = BEYANNAME_VERI_AKTARMA_GEN_NAME, strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = BEYANNAME_VERI_AKTARMA_ID)
    private String beyannameVeriAktarmaId;

    @Column(name = BEYANNAME_VERI_AKTARMA_BEYANNAME_ID)
    private String beyannameId;

    @Column(name = BEYANNAME_VERI_AKTARMA_GTIP)
    private String gtip;

    @Column(name = BEYANNAME_VERI_AKTARMA_FATURA_TUTARI, columnDefinition="decimal", precision=18, scale=2)
    private BigDecimal faturaTutari;

    @Column(name = BEYANNAME_VERI_AKTARMA_NET_AGIRLIK, columnDefinition="decimal", precision=18, scale=2)
    private BigDecimal netAgirlik;

    @Column(name = BEYANNAME_VERI_AKTARMA_BURUT_AGIRLIK, columnDefinition="decimal", precision=18, scale=2)
    private BigDecimal burutAgirlik;

    @Column(name = BEYANNAME_VERI_AKTARMA_MIKTAR, columnDefinition="decimal", precision=18, scale=2)
    private BigDecimal miktar;

    @Column(name = BEYANNAME_VERI_AKTARMA_MENSE_ULKE, columnDefinition = "nvarchar", length = 50)
    private String menseUlke;

    @Column(name = BEYANNAME_VERI_AKTARMA_ULUSLAR_ARASI_ANLASMA)
    private String uluslarArasiAnlasma;

    @Column(name = BEYANNAME_VERI_AKTARMA_OZELLIK)
    private String ozellik;

    @Column(name = BEYANNAME_VERI_AKTARMA_BIRIMI)
    private String birimi;

    @Column(name = BEYANNAME_VERI_AKTARMA_OLCU_BIRIMI)
    private String olcuBirimi;

    @Column(name = BEYANNAME_VERI_AKTARMA_MALZEME_KODU)
    private String malzemeKodu;

    @Column(name = BEYANNAME_VERI_AKTARMA_ACIKLAMA)
    private String aciklama;

    @Column(name = BEYANNAME_VERI_AKTARMA_TICARI_TANIM)
    private String ticariTanim;

    @Column(name = BEYANNAME_VERI_AKTARMA_DIIB_SATIR_NO)
    private String diibSatirNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_FATURA_NO)
    private String faturaNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_FATURA_TARIH)
    private LocalDateTime faturaTarih;

    @Column(name = BEYANNAME_VERI_AKTARMA_MUS_REF_NO1)
    private String musRefNo1;

    @Column(name = BEYANNAME_VERI_AKTARMA_MUS_REF_NO2)
    private String musRefNo2;

    @Column(name = BEYANNAME_VERI_AKTARMA_BOLUM)
    private String bolum;

    @Column(name = BEYANNAME_VERI_AKTARMA_YURTDISI_TUTAR, columnDefinition="decimal", precision=18, scale=2)
    private BigDecimal yurtdisiTutar;

    @Column(name = BEYANNAME_VERI_AKTARMA_KAP_ADET)
    private Integer kapAdet;

    @Column(name = BEYANNAME_VERI_AKTARMA_TUTAR2, columnDefinition="decimal", precision=18, scale=2)
    private BigDecimal tutar2;

    @Column(name = BEYANNAME_VERI_AKTARMA_ANTREPO_BEYANNAME_NO)
    private String antrepoBeyannameNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_ANTREPO_KALEM_SIRA_NO)
    private Integer antrepoKalemSiraNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_FOB_TUTAR, columnDefinition="decimal", precision=18, scale=2)
    private BigDecimal fobTutar;

    @Column(name = BEYANNAME_VERI_AKTARMA_KASA_NO)
    private String kasaNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_BIRIM_TUTAR, columnDefinition="decimal", precision=18, scale=2)
    private BigDecimal birimTutar;

    @Column(name = BEYANNAME_VERI_AKTARMA_TEDARIKCI_KODU)
    private String tedarikciKodu;

    @Column(name = BEYANNAME_VERI_AKTARMA_TEDARIKCI_ADI)
    private String tedarikciAdi;

    @Column(name = BEYANNAME_VERI_AKTARMA_REFERANS_NO)
    private String referansNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_SEVKIYAT_NO)
    private String sevkiyatNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_SEVKIYAT_HATTI)
    private String sevkiyatHatti;

    @Column(name = BEYANNAME_VERI_AKTARMA_ATR_BELGE_NO)
    private String atrBelgeNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_ATR_BELGE_TARIHI)
    private LocalDateTime atrBelgeTarihi;

    @Column(name = BEYANNAME_VERI_AKTARMA_ONSTATU_BELGE_NO)
    private String onStatuBelgeNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_ONSTATU_BELGE_TARIHI)
    private LocalDateTime onStatuBelgeTarihi;

    @Column(name = BEYANNAME_VERI_AKTARMA_YATIRIM_TESVIK_BELGE_NO)
    private String yatirimTesvikBelgeNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_YATIRIM_TESVIK_TARIHI)
    private LocalDateTime yatirimTesvikTarihi;

    @Column(name = BEYANNAME_VERI_AKTARMA_YURTDISI_DIGER, columnDefinition="decimal", precision=18, scale=2)
    private BigDecimal yurtdisiDiger;
/*
    @Column(name = BEYNNAME_VERI_AKTARMA_YURTDISI_DIGER_DOVIZI)
    private String yurtdisiDigerDovizi;
*/
    @Column(name = BEYANNAME_VERI_AKTARMA_MENSEI_SAH_BELGE_NO)
    private String menseiSahBelgeNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_MENSEI_SAH_TARIHI)
    private LocalDateTime menseiSahTarihi;

    @Column(name = BEYANNAME_VERI_AKTARMA_TPS_BELGE_NO)
    private String tpsBelgeNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_TPS_TARIHI)
    private String tpsBelgeTarihi;

    @Column(name = BEYANNAME_VERI_AKTARMA_CIKIS_ULKE_LIMAN)
    private String cikisUlkeLimani;

    @Column(name = BEYANNAME_VERI_AKTARMA_GONDERICI_REFERANS)
    private String gondericiReferans;

    @Column(name = BEYANNAME_VERI_AKTARMA_KONSIMANTO_NO)
    private String konsimentoNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_KONTEYNER_NUMARA)
    private String konteynerNumara;

    @Column(name = BEYANNAME_VERI_AKTARMA_GEMI_ADI)
    private String gemiAdi;

    @Column(name = BEYANNAME_VERI_AKTARMA_TASIYICI_KODU)
    private String tasiyiciKodu;

    @Column(name = BEYANNAME_VERI_AKTARMA_BOSALTMA_LIMANI)
    private String bosaltmaLimani;

    @Column(name = BEYANNAME_VERI_AKTARMA_DIIB_BELGE_NO)
    private String diibBelgeNo;

    @Column(name = BEYANNAME_VERI_AKTARMA_MUAFIYET)
    private String muafiyet;

    @Column(name = BEYANNAME_VERI_AKTARMA_TESLIM_SEKLI)
    private String teslimSekli;

    @Column(name = BEYANNAME_VERI_AKTARMA_TASIMA_SEKLI)
    private String tasimasekli;

    @Column(name = BEYANNAME_VERI_AKTARMA_TAHMINI_HAREKET_TARIHI)
    private LocalDateTime tahminiHareketTarihi;

    @Column(name = BEYANNAME_VERI_AKTARMA_TAHMINI_VARIS_TARIHI)
    private LocalDateTime tahminiVarisTarihi;

    @Column(name = BEYANNAME_VERI_AKTARMA_DOVIZ_CINSI)
    private String dovizCinsi;

    @Column(name = BEYANNAME_VERI_AKTARMA_OLCU_MIKTARI, columnDefinition="decimal", precision=18, scale=2)
    private BigDecimal olcuMiktari;

    @Column(name = BEYANNAME_VERI_AKTARMA_TIC_YAPILAN_ULKE)
    private String ticYapilanUlke;

}
