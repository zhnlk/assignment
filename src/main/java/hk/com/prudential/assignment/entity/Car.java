package hk.com.prudential.assignment.entity;


import hk.com.prudential.assignment.abstracts.AbstractTimeScopeEntity;
import hk.com.prudential.assignment.enums.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Data
@Entity
@Table(name = "t_car")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car extends AbstractTimeScopeEntity {

    private String model;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    private int timeToDelivery = 4;

    private int remainDaysToDelivery;

    private LocalDateTime lastRented;

}
