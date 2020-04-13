package hk.com.prudential.assignment.entity;

import hk.com.prudential.assignment.abstracts.AbstractTimeScopeEntity;
import hk.com.prudential.assignment.enums.TicketStatus;
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
@Table(name = "t_ticket")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends AbstractTimeScopeEntity {

    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_customer"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "fk_car"))
    private Car car;

    private LocalDateTime orderTime;

    private LocalDateTime startDeliveryTime;

    private LocalDateTime expectReceiveTime;

    private LocalDateTime actualReturnTime;

    private LocalDateTime actualReceiveTime;

}
