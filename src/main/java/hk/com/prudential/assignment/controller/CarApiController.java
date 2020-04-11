package hk.com.prudential.assignment.controller;

import hk.com.prudential.assignment.base.BaseRestController;
import hk.com.prudential.assignment.model.RestResponse;
import hk.com.prudential.assignment.service.CarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@RestController
@RequestMapping("/api/v1/car")
public class CarApiController extends BaseRestController {

    @Autowired
    CarService carService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @ApiOperation(value = "list")
    @GetMapping("/list")
    public RestResponse list() {
        return success();
    }
}
