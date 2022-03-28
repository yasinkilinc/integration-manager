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
@Entity(name = ULKE_ENTITY)
@Table(name = ULKE)
public class Ulke implements Serializable {

    @Id
    @Column(name = ULKE_ID)
    private String ulkeId;

    @Column(name = ULKE_AD, columnDefinition = "nvarchar", length = 50)
    private String ad;

    @Column(name = EDI_KOD)
    private String ediKod;

    @Column(name = KODU)
    private String kodu;

    @Column(name = KISA_AD)
    private String kisaAd;

    @Column(name = ORIJINAL_AD)
    private String orijinalAd;

    @Override
    public String toString() {
        return "Ulke{" +
                "ulkeId='" + ulkeId + '\'' +
                ", ad='" + ad + '\'' +
                ", ediKod='" + ediKod + '\'' +
                ", kodu='" + kodu + '\'' +
                ", kisaAd='" + kisaAd + '\'' +
                ", orijinalAd='" + orijinalAd + '\'' +
                '}';
    }
}
