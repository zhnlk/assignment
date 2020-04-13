package hk.com.prudential.assignment.test;

import hk.com.prudential.assignment.AssignmentApplication;
import hk.com.prudential.assignment.entity.Car;
import hk.com.prudential.assignment.entity.Customer;
import hk.com.prudential.assignment.entity.Ticket;
import hk.com.prudential.assignment.enums.CarStatus;
import hk.com.prudential.assignment.enums.CustomerStatus;
import hk.com.prudential.assignment.enums.TicketStatus;
import hk.com.prudential.assignment.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author zhnlk
 * @date 2020/4/12
 * @mail tomleader0828@gmail.com
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssignmentApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Test
    public void testTicketList() {
        List<Ticket> list = ticketService.list();

        Assert.assertNotEquals(0, list.size());

    }

    @Test
    public void testListByCustomer() {
        String customerId = "111111";
        List<Ticket> tickets = ticketService.listByCustomer(customerId);

        Assert.assertNotEquals(0, tickets.size());
    }

    @Test
    public void testGetById() {
        String ticketId = "111111";

        Ticket ticket = ticketService.getById(ticketId).orElse(null);

        assert ticket != null;

        Assert.assertEquals(ticketId, ticket.getId());
    }

    @Test
    public void testTicketSave() {
        Car car = Car.builder().model("model").status(CarStatus.SHELVES).build();
        Customer customer = Customer.builder().status(CustomerStatus.NORMAL).name("tom").build();

        Ticket ticket = Ticket.builder().status(TicketStatus.INITIAL)
                .car(car)
                .customer(customer)
                .orderTime(LocalDateTime.now())
                .build();
        Ticket save = ticketService.save(ticket);

        Assert.assertEquals(ticket, save);
    }
}
