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
@Entity(name = MALZEME_TANIM_ENTITY)
@Table(name = MALZEME_TANIM)
public class MalzemeTanim implements Serializable {

    @Id
    @Column(name = MALZEME_TANIM_ID)
    private String id;

    @Column(name = MALZEME_TANIM_FIRMA_ID)
    private String firmaId;

    @Column(name = MALZEME_TANIM_KOD)
    private String kod;

    @Column(name = MALZEME_TANIM_GTIP)
    private String gtip;

    @Column(name = TURKCE_AD)
    private String turkceAd;

    @Column(name = ORJINAL_ADI)
    private String orijinalAd;

    @Override
    public String toString() {
        return "MalzemeTanim{" +
                "id='" + id + '\'' +
                ", firmaId='" + firmaId + '\'' +
                ", kod='" + kod + '\'' +
                ", gtip='" + gtip + '\'' +
                ", turkceAd='" + turkceAd + '\'' +
                ", orijinalAd='" + orijinalAd + '\'' +
                '}';
    }
}
