package tr.com.atez.integration.manager.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import static tr.com.atez.integration.manager.constant.ApplicationConstants.*;

@Getter
@Setter
@Entity(name = OLCU_BIRIM_ENTITY)
@Table(name = OLCU_BIRIM)
@ToString(doNotUseGetters = true)
public class OlcuBirim implements Serializable {

    @Id
    @Column(name = OLCU_BIRIM_ID)
    private String olcuBirimId;

    @Column(name = OLCU_BIRIMI_EDI_KOD)
    private String ediKod;

    @Column(name = CMS, columnDefinition = "nvarchar", length = 5)
    private String cms;

}
