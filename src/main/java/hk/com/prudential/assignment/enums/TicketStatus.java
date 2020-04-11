package hk.com.prudential.assignment.enums;

import hk.com.prudential.assignment.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@AllArgsConstructor
public enum TicketStatus implements BaseEnum {

    INITIAL("TICKET_INITIAL"),
    PENDING("TICKET_IS_PENDING"),
    PAYED("ORDER_HAS_BE_PAYED"),
    DELIVERY("TICKET_IS_DELIVERY"),
    RECEIVED("CAR_HAS_RECEIVED"),
    RETURN("CAR_HAS_BEEN_RETURN"),
    CANCELED("TICKET_HAS_BEEN_CANCELED"),
    ;

    @Getter
    private String msg;

    @Override
    public String getMsg() {
        return msg;
    }
}
