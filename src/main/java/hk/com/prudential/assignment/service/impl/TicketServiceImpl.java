package hk.com.prudential.assignment.service.impl;

import hk.com.prudential.assignment.entity.Ticket;
import hk.com.prudential.assignment.repository.TicketRepository;
import hk.com.prudential.assignment.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> list() {
        return ticketRepository.findAll();
    }
}
