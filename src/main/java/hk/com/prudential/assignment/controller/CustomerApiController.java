package hk.com.prudential.assignment.controller;

import hk.com.prudential.assignment.base.BaseRestController;
import hk.com.prudential.assignment.entity.Customer;
import hk.com.prudential.assignment.model.RestResponse;
import hk.com.prudential.assignment.service.CustomerService;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/list")
    public RestResponse add(){
        List<Customer> list = customerService.list();
        return success(list);
    }
}
