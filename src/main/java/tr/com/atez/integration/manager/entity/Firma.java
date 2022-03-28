package tr.com.atez.integration.manager.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import static tr.com.atez.integration.manager.constant.ApplicationConstants.*;

@Getter
@Setter
@Entity(name = FIRMA_ENTITY)
@Table(name = FIRMA)
public class Firma implements Serializable {

    @Id
    @Column(name = FIRMA_ID)
    private String firmaId;

    @Column(name = SIRKET_ID)
    private String sirketId;

    @Column(name = SEHIR_ID)
    private String sehirId;

    @Column(name = AKTIF)
    private int aktif;

    @Column(name = AVANS_HESAP_ID)
    private String ad;

    @Column(name = FIRMA_TIP_ID)
    private String firmaTipId;

    @Column(name = GRUP_ID1)
    private String grupId1;

    @Column(name = GRUP_ID2)
    private String grupId2;

    @Column(name = GRUP_ID3)
    private String grupId3;

    @Column(name = FIRMA_INT_ID)
    private int firmaIntId;

    @Column(name = SEVKIYAT_NOKTA_ID)
    private String sevkiyatNoktaId;

    @Column(name = KARSI_FIRMA_ID)
    private String karsiFirmaId;

    @Column(name = FIRMA_KAZANDIRAN_PERSONEL_ID)
    private String firmaKazandiranPersonelId;

    @Column(name = FIYAT_BOLGE_ID)
    private String fiyatBolgeId;

    @Column(name = FIRMA_DURUM_ID)
    private String firmaDurumId;

    @Override
    public String toString() {
        return "Firma{" +
                "firmaId='" + firmaId + '\'' +
                ", sirketId='" + sirketId + '\'' +
                ", sehirId='" + sehirId + '\'' +
                ", aktif=" + aktif +
                ", ad='" + ad + '\'' +
                ", firmaTipId='" + firmaTipId + '\'' +
                ", grupId1='" + grupId1 + '\'' +
                ", grupId2='" + grupId2 + '\'' +
                ", grupId3='" + grupId3 + '\'' +
                ", firmaIntId=" + firmaIntId +
                ", sevkiyatNoktaId='" + sevkiyatNoktaId + '\'' +
                ", karsiFirmaId='" + karsiFirmaId + '\'' +
                ", firmaKazandiranPersonelId='" + firmaKazandiranPersonelId + '\'' +
                ", fiyatBolgeId='" + fiyatBolgeId + '\'' +
                ", firmaDurumId='" + firmaDurumId + '\'' +
                '}';
    }
}
