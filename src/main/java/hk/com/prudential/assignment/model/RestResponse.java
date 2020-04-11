package hk.com.prudential.assignment.model;

import hk.com.prudential.assignment.constant.GlobalConstant;
import hk.com.prudential.assignment.abstracts.AbstractObject;
import hk.com.prudential.assignment.enums.RestCode;
import lombok.Data;
import org.slf4j.MDC;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Data
public class RestResponse<T> extends AbstractObject {

    private int code;

    private String msg;

    private T data;

    private String logId;

    public RestResponse() {
        this.code = RestCode.SUCCESS.getCode();
        this.msg = RestCode.SUCCESS.getMsg();
        this.data = null;
    }

    public RestResponse(T content) {
        this.data = content;
        this.code = RestCode.SUCCESS.getCode();
        this.msg = RestCode.SUCCESS.getMsg();
    }

    public RestResponse(RestCode restCode) {
        this.code = restCode.getCode();
        this.msg = restCode.getMsg();
        this.data = null;
    }

    public RestResponse(RestCode restCode, T data) {
        this.data = data;
        this.code = restCode.getCode();
        this.msg = restCode.getMsg();
    }

    public RestResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResponse<T> success() {
        setCode(RestCode.SUCCESS.getCode());
        setMsg(RestCode.SUCCESS.getMsg());
        return this;
    }

    public RestResponse<T> success(T data) {
        setData(data);
        setCode(RestCode.SUCCESS.getCode());
        setMsg(RestCode.SUCCESS.getMsg());
        return this;
    }

    public RestResponse<T> success(T data, String msg) {
        setData(data);
        setCode(RestCode.SUCCESS.getCode());
        setMsg(msg);
        return this;
    }

    public RestResponse<T> error(RestCode restCode) {
        setCode(restCode.getCode());
        setMsg(restCode.getMsg());
        setLogId(getLogId());
        return this;
    }

    public RestResponse<T> error(RestCode restCode, String msg) {
        setCode(restCode.getCode());
        setMsg(msg);
        setLogId(getLogId());
        return this;
    }

    public String getLogId() {
        return MDC.get(GlobalConstant.LOG_ID);
    }


}
