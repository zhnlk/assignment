package hk.com.prudential.assignment.entity;

import hk.com.prudential.assignment.abstracts.AbstractTimeScopeEntity;
import hk.com.prudential.assignment.enums.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends AbstractTimeScopeEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    private String ticket;


}
