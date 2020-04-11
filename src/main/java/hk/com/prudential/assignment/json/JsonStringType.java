package hk.com.prudential.assignment.json;

import hk.com.prudential.assignment.json.description.JsonStringSqlTypeDescriptor;
import lombok.Getter;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
public class JsonStringType extends AbstractSingleColumnStandardBasicType<Object> implements DynamicParameterizedType {

    @Getter
    String name = "jsonb";

    public JsonStringType() {
        super(JsonStringSqlTypeDescriptor.INSTANCE,new jsontypedes);
    }

    @Override
    public void setParameterValues(Properties properties) {
        (jsontypede)getJavaTypeDescriptor()
    }
}
