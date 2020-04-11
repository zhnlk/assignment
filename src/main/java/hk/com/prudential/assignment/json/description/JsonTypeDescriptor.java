package hk.com.prudential.assignment.json.description;

import org.apache.logging.log4j.core.util.JsonUtils;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.MutableMutabilityPlan;
import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
public class JsonTypeDescriptor extends AbstractTypeDescriptor<Object> implements DynamicParameterizedType {

    private Class<?> jsonObjectClass;

    public JsonTypeDescriptor(){
        super(Object.class, new MutableMutabilityPlan<Object>() {
            @Override
            protected Object deepCopyNotNull(Object o) {
                return JsonUtils;
            }
        });
    }

    @Override
    public void setParameterValues(Properties parameters) {
        jsonObjectClass = ((ParameterType) parameters.get(PARAMETER_TYPE)).getReturnedClass();
    }
}
