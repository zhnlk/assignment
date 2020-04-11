package hk.com.prudential.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private Customer customer;

}
