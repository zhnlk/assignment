package hk.com.prudential.assignment.repository;

import hk.com.prudential.assignment.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, String> {

    @Query("select t from Ticket t where t.customer.id = :customerId")
    List<Ticket> listByCustomerId(@Param("customerId") String customerId);
}
