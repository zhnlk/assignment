package hk.com.prudential.assignment.abstracts;

import hk.com.prudential.assignment.json.JsonBinaryType;
import hk.com.prudential.assignment.json.JsonStringType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb",typeClass = JsonBinaryType.class)
})
public abstract class AbstractEntity extends AbstractObject {
}
