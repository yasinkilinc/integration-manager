package tr.com.atez.integration.manager.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tr.com.atez.integration.manager.constant.ApplicationConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public abstract class AbstractBaseEntity extends AbstractBaseIdEntity implements Serializable {

    @CreationTimestamp
    @Column(name = ApplicationConstants.CREATE_DATE)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = ApplicationConstants.UPDATE_DATE)
    private LocalDateTime updatedDate;

    @CreatedBy
    @Column(name = ApplicationConstants.CREATED_BY)
    private String createUserId;

    @LastModifiedBy
    @Column(name = ApplicationConstants.UPDATED_BY)
    private String modifyUserId;
/*
    @NotNull
    @Version
    @Column(name = ApplicationConstants.VERSION)
    private Long version = ApplicationConstants.DEFAULT_VALUE;
*/
    @Column(name = ApplicationConstants.DELETE_DATE)
    private LocalDateTime deletedDate;

    @PrePersist
    public void setCreateDate() {
        this.createDate = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdateDate() {
        this.updatedDate = LocalDateTime.now();
    }

}
