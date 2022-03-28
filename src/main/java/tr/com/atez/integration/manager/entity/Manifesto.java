package tr.com.atez.integration.manager.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import tr.com.atez.integration.manager.constant.ApplicationConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static tr.com.atez.integration.manager.constant.ApplicationConstants.*;

// @SQLDelete(sql = MANIFESTO_DELETE_SQL)
// @Where(clause = MANIFESTO_WHERE_CLAUSE)
@Entity(name = MANIFESTO_ENTITY)
@Table(name = MANIFESTO)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(doNotUseGetters = true)
public class Manifesto implements Serializable {

    public enum Status{ PROCESSING, SUCCESSFUL, FAILED }

    @Id
    @GeneratedValue(generator = ApplicationConstants.UUID)
    @GenericGenerator(name = ApplicationConstants.UUID, strategy = ApplicationConstants.UUID_STRATEGY)
    @Column(name = "id", insertable = false, updatable = false)
    private String id;

    @CreationTimestamp
    @Column(name = ApplicationConstants.CREATE_DATE)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = ApplicationConstants.UPDATE_DATE)
    private LocalDateTime updatedDate;

    @Column(name = FILE_PATH)
    private String filePath;

    @Column(name = FILE_NAME)
    private String fileName;

    @Column(name = MANIFESTO_STATUS)
    @Enumerated(EnumType.STRING)
    private Status status = Status.PROCESSING;

    @Column(name = MANIFESTO_RETRY)
    private int retry;

    @PrePersist
    public void setCreateDate() {
        this.createDate = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdateDate() {
        this.updatedDate = LocalDateTime.now();
    }
}
