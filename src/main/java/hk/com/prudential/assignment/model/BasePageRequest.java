package hk.com.prudential.assignment.model;

import hk.com.prudential.assignment.abstracts.AbstractObject;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Data
@NoArgsConstructor
public class BasePageRequest extends AbstractObject {

    int page = 0;

    int size = 20;

    public Pageable getPageable() {
        return PageRequest.of(page, size);
    }
}
