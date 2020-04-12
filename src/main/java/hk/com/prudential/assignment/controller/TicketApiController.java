package hk.com.prudential.assignment.controller;

import hk.com.prudential.assignment.base.BaseRestController;
import hk.com.prudential.assignment.model.RestResponse;
import hk.com.prudential.assignment.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketApiController extends BaseRestController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("/listByCustomer")
    public RestResponse listByCustomer(@RequestParam("customerId") String customerId){
        ticketService.listByCustomer(customerId);
    }
}
