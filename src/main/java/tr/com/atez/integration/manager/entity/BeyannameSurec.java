package tr.com.atez.integration.manager.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static tr.com.atez.integration.manager.constant.ApplicationConstants.*;

@Getter
@Setter
@Entity(name = BEYANNAME_SUREC_ENTITY)
@Table(name = BEYANNAME_SUREC)
public class BeyannameSurec implements Serializable {

    @Id
    @GeneratedValue(generator = BEYANNAME_SUREC_GEN_VAL_GEN)
    @GenericGenerator(name = BEYANNAME_SUREC_GEN_NAME, strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = BEYANNAME_SUREC_ID)
    private String beyannameSurecId;

    @Type(type = "uuid-char")
    @Column( name = BEYANNAME_SUREC_BEYANNAME_ID, columnDefinition = "uniqueidentifier" )
    private UUID beyannameId;

    @Type(type = "uuid-char")
    @Column(name = BEYANNAME_SUREC_SUREC_TANIM_ID, columnDefinition = "uniqueidentifier")
    private UUID surecTanimId;

    @Column(name = BEYANNAME_SUREC_TARIH)
    private LocalDateTime tarih;


    @Override
    public String toString() {
        return "BeyannameSurec{" +
                "beyannameSurecId='" + beyannameSurecId + '\'' +
                ", beyannameId=" + beyannameId +
                ", surecTanimId=" + surecTanimId +
                ", tarih=" + tarih +
                '}';
    }
}
