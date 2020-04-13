package hk.com.prudential.assignment.controller;

import hk.com.prudential.assignment.base.BaseRestController;
import hk.com.prudential.assignment.entity.Customer;
import hk.com.prudential.assignment.model.RestResponse;
import hk.com.prudential.assignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerApiController extends BaseRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @PostMapping("/save")
    public RestResponse save(@RequestParam("name") @NotNull String name){
        Customer build = Customer.builder().name(name).build();
        Customer save = customerService.save(build);
        return  success(save);
    }

    @PostMapping("/list")
    public RestResponse list(){
        List<Customer> list = customerService.list();
        return success(list);
    }
}
