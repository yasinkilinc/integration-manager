package tr.com.atez.integration.manager.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

import static tr.com.atez.integration.manager.constant.ApplicationConstants.*;

@Getter
@Setter
@Entity(name = MALZEME_ENTITY)
@Table(name = MALZEME_EXCEL)
@IdClass(MalzemeExcelPK.class)
@ToString(doNotUseGetters = true)
public class MalzemeExcel implements Serializable {

    @Column(name = MALZEMEEXCEL_ID)
    private String malzemeExcelId;

    @Id
    @Column(name = FIRMA_KODU)
    private String firmaKodu;

    @Id
    @Column(name = KULLANICI_KOD)
    private String kullaniciKod;

    @Column(name = GTIP)
    private Integer gtip;

    @Column(name = FATURA_TUTARI)
    private Integer faturaTutari;

    @Column(name = NET_AGIRLIK)
    private Integer netAgirlik;

    @Column(name = BURUT_AGIRLIK)
    private Integer burutAgirlik;

    @Column(name = MIKTAR)
    private Integer miktar;

    @Column(name = BIRIMI)
    private Integer birimi;

    @Column(name = MENSE_ULKE)
    private Integer menseUlke;

    @Column(name = ULUSLARARASI_ANLASMA)
    private Integer uluslarArasiAnlasma;

    @Column(name = OZELLIK)
    private Integer ozellik;

    @Column(name = OLCU_BIRIMI)
    private Integer olcuBirimi;

    @Column(name = MALZEME_KODU)
    private Integer malzemeKodu;

    @Column(name = ACIKLAMA)
    private Integer aciklama;

    @Column(name = TICARI_TANIM)
    private Integer ticariTanim;

    @Column(name = DIIB_SATIR_NO)
    private Integer diibSatirNo;

    @Column(name = FATURA_NO)
    private Integer faturaNo;

    @Column(name = FATURA_TARIH)
    private Integer faturaTarihi;

    @Column(name = MUS_REF_NO1)
    private Integer musRefNo1;

    @Column(name = MUS_REF_NO2)
    private Integer musRefNo2;

    @Column(name = BOLUM)
    private Integer bolum;

    @Column(name = OLCU_MIKTARI)
    private Integer olcuMiktari;

    @Column(name = YURTDISI_TUTAR)
    private Integer yurtdisiTutar;

    @Column(name = KAP_ADET)
    private Integer kapAdet;

    @Column(name = TUTAR2)
    private Integer tutar2;

    @Column(name = ANTREPO_BEYANNAME_NO)
    private Integer antrepoBeyannameId;

    @Column(name = ANTREPO_KALEM_SIRA_NO)
    private Integer antrepoKalemSiraNo;

    @Column(name = FOB_TUTAR)
    private Integer fobTutar;

    @Column(name = KASA_NO)
    private Integer kasaNo;

    @Column(name = BIRIM_TUTAR)
    private Integer birimTutar;

    @Column(name = TEDARIKCI_KODU)
    private Integer tedarikciKodu;

    @Column(name = TEDARIKCI_ADI)
    private Integer tedarikciAdi;

    @Column(name = REFERANS_NO)
    private Integer referansNo;

    @Column(name = SEVKIYAT_NO)
    private Integer sevkiyatNo;

    @Column(name = SEVKIYAT_HATTI)
    private Integer sevkiyatHatti;

    @Column(name = ATR_BELGE_NO)
    private Integer atrBelgeNo;

    @Column(name = ATR_BELGE_TARIHI)
    private Integer atrBelgeTarihi;

    @Column(name = ON_STATU_BELGE_NO)
    private Integer onStatuBelgeNo;

    @Column(name = ON_STATU_BELGE_TARIHI)
    private Integer onStatuBelgeTarihi;

    @Column(name = YATIRIM_TESVIK_BELGE_NO)
    private Integer yatirimTesvikBelgeNo;

    @Column(name = YATIRIM_TESVIK_TARIHI)
    private Integer yatirimTesvikTarihi;

    @Column(name = YURTDISI_DIGER)
    private Integer yurtdisiDeger;

    @Column(name = YURTDISI_DIGER_DOVIZI)
    private Integer yurtdisiDegerDovizi;

    @Column(name = MENSEI_SAH_BELGE_NO)
    private Integer menseiSahBelgeNo;

    @Column(name = MENSEI_SAH_TARIHI)
    private Integer menseiSahTarihi;

    @Column(name = TPS_BELGE_NO)
    private Integer tpsBelgeNo;

    @Column(name = TPS_TARIHI)
    private Integer tpsTarihi;

    @Column(name = CIKIS_ULKE_LIMAN)
    private Integer cikisUlkeLiman;

    @Column(name = GONDERICI_REFERANS)
    private Integer gondericiReferans;

    @Column(name = KONSIMANTO_NO)
    private Integer konsimantoNo;

    @Column(name = KONTEYNER_NUMARA)
    private Integer konteynerNumara;

    @Column(name = GEMI_ADI)
    private Integer gemiAdi;

    @Column(name = TASIYICI_KODU)
    private Integer tasiyiciKodu;

    @Column(name = BOSALTMA_LIMANI)
    private Integer bosaltmaLimani;

    @Column(name = DIIB_BELGE_NO)
    private Integer diibBelgeNo;

    @Column(name = MUAFIYET)
    private Integer muafiyet;

    @Column(name = DOVIZ_CINSI)
    private Integer dovizCinsi;

    @Column(name = TESLIM_SEKLI)
    private Integer teslimsekli;

    @Column(name = TASIMA_SEKLI)
    private Integer tasimasekli;

    @Column(name = TAHMINI_HAREKET_TARIHI)
    private Integer tahminiHareketTarihi;

    @Column(name = TAHMINI_VARIS_TARIHI)
    private Integer tahminiVarisTarihi;

    @Column(name = TIC_YAPILAN_ULKE)
    private Integer ticYapilanUlke;

}
