package hk.com.prudential.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerApiController {

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
}
