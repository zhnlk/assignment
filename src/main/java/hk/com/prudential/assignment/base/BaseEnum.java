package hk.com.prudential.assignment.base;

import java.io.Serializable;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
public interface BaseEnum extends Serializable {

    /**
     * key along with enums
     *
     * @return
     */
    String getMsg();
}
