package tr.com.atez.integration.manager.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tr.com.atez.integration.manager.constant.ApplicationConstants;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public class AbstractBaseIdEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = ApplicationConstants.UUID)
    @GenericGenerator(name = ApplicationConstants.UUID, strategy = ApplicationConstants.UUID_STRATEGY)
    @Column(name = "id", insertable = false, updatable = false)
    private String id;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = ApplicationConstants.ACTIVE)
    private boolean active = true;

}
