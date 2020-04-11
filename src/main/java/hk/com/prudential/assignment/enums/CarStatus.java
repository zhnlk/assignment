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
public enum CarStatus implements BaseEnum {

    SHELVES("CAR_IS_ON_SHELVES"),
    OCCUPY("CAR_IS_OCCUPY"),
    FROZEN("CAR_IS_FROZEN"),
    UNSHELVES("CAR_IS_OFF_SHELVES"),
    DELETED("CAR_IS_DELETED"),
    ;

    @Getter
    private String msg;

    @Override
    public String getMsg() {
        return msg;
    }
}
