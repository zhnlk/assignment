package hk.com.prudential.assignment.base;

import hk.com.prudential.assignment.model.RestResponse;
import hk.com.prudential.assignment.abstracts.AbstractController;
import hk.com.prudential.assignment.enums.RestCode;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@RestController
public class BaseRestController extends AbstractController {

    protected RestResponse error(RestCode responseCode) {
        return new RestResponse().error(responseCode);
    }

    protected RestResponse error(String msg) {
        return new RestResponse().error(RestCode.ERROR, msg);
    }

    protected RestResponse error(RestCode responseCode, String... msg) {
        return new RestResponse().error(responseCode, String.format(responseCode.getMsg(), msg));
    }

    protected RestResponse success() {
        return new RestResponse().success();
    }

    protected RestResponse success(Object data) {
        return new RestResponse().success(data);
    }

}
