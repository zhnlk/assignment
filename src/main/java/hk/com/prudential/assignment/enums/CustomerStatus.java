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
public enum CustomerStatus implements BaseEnum {

    INITIAL("CUST_IS_INIT"),
    NORMAL("CUST_IS_NORMAL"),
    FROZEN("CUST_IS_FROZEN"),
    DELETED("CUST_IS_DELETED"),
    ;

    @Getter
    private String msg;

    @Override
    public String getMsg() {
        return msg;
    }
}
