package hk.com.prudential.assignment.abstracts;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
public abstract class AbstractObject implements Serializable {

    static final long serialVersionUID = 20200411L;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, false);
    }
}
