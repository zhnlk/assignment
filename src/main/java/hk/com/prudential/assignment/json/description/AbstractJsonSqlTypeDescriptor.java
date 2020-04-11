package hk.com.prudential.assignment.json.description;

import org.hibernate.type.descriptor.ValueExtractor;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicExtractor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * json sql type descriptor
 *
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
public abstract class AbstractJsonSqlTypeDescriptor implements SqlTypeDescriptor {

    @Override
    public int getSqlType() {
        return Types.OTHER;
    }

    @Override
    public boolean canBeRemapped() {
        return true;
    }

    @Override
    public <X> ValueExtractor<X> getExtractor(JavaTypeDescriptor<X> javaTypeDescriptor) {
        return new BasicExtractor<X>(javaTypeDescriptor, this) {
            @Override
            protected X doExtract(ResultSet resultSet, String name, WrapperOptions wrapperOptions) throws SQLException {
                return getJavaDescriptor().wrap(resultSet.getObject(name), wrapperOptions);
            }

            @Override
            protected X doExtract(CallableStatement callableStatement, int index, WrapperOptions wrapperOptions) throws SQLException {
                return getJavaDescriptor().wrap(callableStatement.getObject(index), wrapperOptions);
            }

            @Override
            protected X doExtract(CallableStatement callableStatement, String name, WrapperOptions wrapperOptions) throws SQLException {
                return getJavaDescriptor().wrap(callableStatement.getObject(name), wrapperOptions);
            }
        };
    }
}
