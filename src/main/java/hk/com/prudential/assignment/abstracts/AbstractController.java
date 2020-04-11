package hk.com.prudential.assignment.abstracts;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Slf4j
@Controller
public abstract class AbstractController {

    private static final Sort PAGE_SORT = Sort.by(Sort.Direction.DESC, "timeLastUpdated");

    protected Pageable page(int start, int length) {
        return PageRequest.of(start / length, length, PAGE_SORT);
    }

    protected Pageable pageOf(int page, int size) {
        return PageRequest.of(page, size);
    }

    protected Pageable pageOf(int page, int size, Sort sort) {
        return PageRequest.of(page, size, sort);
    }

}
