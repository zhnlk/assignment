package hk.com.prudential.assignment.enums;

import hk.com.prudential.assignment.base.BaseEnum;
import lombok.Getter;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
public enum RestCode implements BaseEnum {

    SUCCESS("success", 100000),
    ERROR("fail", 111111),
    ;

    final private String msg;

    @Getter
    final private int code;

    RestCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
