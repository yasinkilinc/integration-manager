package tr.com.atez.integration.manager.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

import static tr.com.atez.integration.manager.constant.ApplicationConstants.*;

@Getter
@Setter
@Entity(name = BEYANNAME_ENTITY)
@Table(name = BEYANNAME)
@ToString(doNotUseGetters = true)
public class Beyanname implements Serializable{

    @Id
    @GeneratedValue(generator = BEYANNAME_GEN_VAL_GEN)
    @GenericGenerator(name = BEYANNAME_GEN_NAME, strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = BEYANNAME_ID)
    private String beyannameId;

    @Column(name = DEPARTMAN_ID)
    private String departmanId;

    @Column(name = BEYANNAME_REFERANS_NO)
    private int referansNo;

    @Column(name = MUSTERI_ID)
    private String musteriId;

/*
    @Column(name = MUSTERI_REFERANS_NO)
    private String musteriReferansNo;

    @Column(name = GONDERILEN_GUMRUK)
    private String gonderilengumruk;

    @Column(name = VARIS_GUMRUK)
    private String varisGumruk;
*/
    @Column(name = ALICI_ID)
    private String aliciid;

    @Column(name = FATURA_FIRMA_ID)
    private String faturaFirmaId;
/*
    @Column(name = REJIM)
    private String rejim;
*/
    @Column(name = BEYANNAME_TESLIM_SEKLI)
    private String teslimSekli;

    @Column(name = BEYANNAME_TASIMA_SEKLI)
    private String tasimaSekli;

    @Column(name = BEYANNAME_CIKIS_ARAC_TIPI, length = 1)
    private String cikisAracTipi;

    @Column(name = BEYANNAME_CIKIS_ARAC_NO, length = 35)
    private String cikisAracNo;

    @Column(name = BEYANNAME_SINIR_ARAC_TIPI, length = 1)
    private String sinirAracTipi;

    @Column(name = BEYANNAME_SINIR_ARAC_NO, length = 35)
    private String sinirAracNo;

    @Column(name = BEYANNAME_FATURA_DOVIZ_TURU)
    private String faturaDovizTuru;

    @Column(name = BEYANNAME_FATURA_CIKIS_ULKE)
    private String cikisUlke;

    @Column(name = BEYANNAME_FATURA_TIC_YAPILAN_ULKE)
    private String ticYapilanUlke;

    @Column(name = BEYANNAME_KULLCANICI_KOD)
    private String kullaniciKod;

}
