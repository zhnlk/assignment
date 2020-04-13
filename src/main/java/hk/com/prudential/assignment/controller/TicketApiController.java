package hk.com.prudential.assignment.controller;

import com.google.common.base.Ticker;
import hk.com.prudential.assignment.base.BaseRestController;
import hk.com.prudential.assignment.entity.Car;
import hk.com.prudential.assignment.entity.Customer;
import hk.com.prudential.assignment.entity.Ticket;
import hk.com.prudential.assignment.enums.CarStatus;
import hk.com.prudential.assignment.enums.CustomerStatus;
import hk.com.prudential.assignment.enums.RestCode;
import hk.com.prudential.assignment.enums.TicketStatus;
import hk.com.prudential.assignment.model.RestResponse;
import hk.com.prudential.assignment.service.CarService;
import hk.com.prudential.assignment.service.CustomerService;
import hk.com.prudential.assignment.service.TicketService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static hk.com.prudential.assignment.constant.GlobalConstant.TIME_TO_DELIVERY;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketApiController extends BaseRestController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CarService carService;

    @Autowired
    TicketService ticketService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/listByCustomer")
    public RestResponse listByCustomer(@RequestParam("customerId") String customerId) {
        List<Ticket> tickets = ticketService.listByCustomer(customerId);
        return success(tickets);
    }

    /**
     * customer place an order to rent a car
     *
     * @param customerId
     * @param carId
     * @return
     */
    @ApiOperation(value = "step1: customer place an order")
    @PostMapping("/order")
    public RestResponse order(@RequestParam("customerId") @NotNull String customerId,
                              @RequestParam("carId") @NotNull String carId) {
        Optional<Customer> customer = customerService.getById(customerId);

        if (!customer.isPresent()) {
            return error(RestCode.ERROR);
        }
        Optional<Car> car = carService.getById(carId);
        if (!car.isPresent()) {
            return error(RestCode.ERROR);
        }
//        customer is not available
        if (customer.get().getStatus() != CustomerStatus.NORMAL) {
            return error(RestCode.ERROR);
        }
//        the car is not available
        if (car.get().getStatus() != CarStatus.SHELVES) {
            return error(RestCode.ERROR);
        }

//        ticket init
        Ticket build = Ticket.builder().customer(customer.get())
                .car(car.get())
                .orderTime(LocalDateTime.now())
                .status(TicketStatus.INITIAL)
                .build();

        Ticket save = ticketService.save(build);

        return success(save);
    }

    @GetMapping("/callback")
    @Deprecated
    @ApiOperation(value = "third part payment, via frontend call, receive the return ticketId")
    public RestResponse thirdPaymentCallback(@RequestParam("ticketId") @NotNull String ticketId) {
        //TODO: complete the third payment implements
        return success();
    }

    /**
     * @param customerId
     * @param carId
     * @param ticketId
     * @return
     */
    @ApiOperation(value = "customer pay to the cost of rental car")
    @PostMapping("/payment")
    public RestResponse payment(@RequestParam("customerId") @NotNull String customerId,
                                @RequestParam("carId") @NotNull String carId,
                                @RequestParam("ticketId") @NotNull String ticketId) {
        Optional<Ticket> ticket = ticketService.getById(ticketId);
        if (!ticket.isPresent()) {
            return error(RestCode.ERROR);
        }

        Customer customer = ticket.get().getCustomer();
        Car car = ticket.get().getCar();

        if (!customer.getId().equals(customerId) || car.getId().equals(carId)) {
            return error(RestCode.ERROR);
        }
        ticket.get().setStatus(TicketStatus.PAYED);
        Ticket save = ticketService.save(ticket.get());

//        frozen the car after payment
        car.setStatus(CarStatus.FROZEN);
        carService.save(car);

        return success(save);
    }

    @ApiOperation(value = "customer cancel the ticket")
    @PostMapping("/cancel")
    public RestResponse cancel(@RequestParam("ticketId") @NotNull String ticketId) {
        Optional<Ticket> ticket = ticketService.getById(ticketId);
        if (!ticket.isPresent()) {
            return error(RestCode.ERROR);
        }
        Ticket tt = ticket.get();
        tt.setStatus(TicketStatus.CANCELED);

        Ticket save = ticketService.save(tt);

//        set car shelves after ticket cancel
        Car car = tt.getCar();
        car.setStatus(CarStatus.SHELVES);
        carService.save(car);

        return success();
    }

    @ApiOperation(value = "the car start to delivery to customer")
    @PostMapping("/delivery")
    public RestResponse delivery(@RequestParam("ticketId") @NotNull String ticketId) {
        Optional<Ticket> ticket = ticketService.getById(ticketId);
        if (!ticket.isPresent()) {
            return error(RestCode.ERROR);
        }
        Ticket tt = ticket.get();
        tt.setStatus(TicketStatus.DELIVERY);
        tt.setStartDeliveryTime(LocalDateTime.now());
        tt.setExpectReceiveTime(LocalDateTime.now().plusDays(TIME_TO_DELIVERY));

        Ticket save = ticketService.save(tt);
        return success(save);
    }

    @ApiOperation(value = "customer confirm receive the car")
    @PostMapping("/confirmReceived")
    public RestResponse confirmReceived(@RequestParam("ticketId") @NotNull String ticketId) {
        Optional<Ticket> ticket = ticketService.getById(ticketId);
        if (!ticket.isPresent()) {
            return error(RestCode.ERROR);
        }
        Ticket tt = ticket.get();
        tt.setActualReceiveTime(LocalDateTime.now());
        tt.setStatus(TicketStatus.RECEIVED);
        ticketService.save(tt);

        Car car = tt.getCar();
        car.setStatus(CarStatus.OCCUPY);
        carService.save(car);

        return success();
    }

    @ApiOperation(value = "customer return the rental car back")
    @PostMapping("/returned")
    public RestResponse returned(@RequestParam("ticketId") @NotNull String ticketId) {
        Optional<Ticket> ticket = ticketService.getById(ticketId);
        if (!ticket.isPresent()) {
            return error(RestCode.ERROR);
        }
        Ticket tt = ticket.get();
        tt.setStatus(TicketStatus.RETURN);
        tt.setActualReturnTime(LocalDateTime.now());
        ticketService.save(tt);

        return success();
    }

}
