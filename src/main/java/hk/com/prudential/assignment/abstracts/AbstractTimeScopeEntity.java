package hk.com.prudential.assignment.abstracts;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@MappedSuperclass
public abstract class AbstractTimeScopeEntity extends AbstractUUIDEntity {

    @Column(nullable = false, updatable = false)
    protected LocalDateTime timeCreated;

    @Column(nullable = false)
    protected LocalDateTime timeLastUpdated;

    @PrePersist
    private void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.timeCreated = now;
        this.timeLastUpdated = now;
    }

    @PreUpdate
    private void preUpdate() {
        this.timeLastUpdated = LocalDateTime.now();
    }

}
