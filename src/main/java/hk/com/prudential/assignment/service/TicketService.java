package hk.com.prudential.assignment.service;

import hk.com.prudential.assignment.base.BaseService;
import hk.com.prudential.assignment.entity.Ticket;

import java.util.List;
import java.util.Optional;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
public interface TicketService extends BaseService<Ticket> {

    List<Ticket> list();

    List<Ticket> listByCustomer(String customerId);

    Optional<Ticket> getById(String ticketId);

    Ticket save(Ticket ticket);
}
