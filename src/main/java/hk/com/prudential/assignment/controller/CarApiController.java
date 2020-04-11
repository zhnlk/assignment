package hk.com.prudential.assignment.controller;

import hk.com.prudential.assignment.base.BaseRestController;
import hk.com.prudential.assignment.entity.Car;
import hk.com.prudential.assignment.model.BasePageRequest;
import hk.com.prudential.assignment.model.RestResponse;
import hk.com.prudential.assignment.service.CarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "save the car object")
    @PostMapping("/save")
    public RestResponse save(@RequestBody Car car){
        Car save = carService.save(car);
        return success(save);
    }

    @ApiOperation(value = "list")
    @GetMapping("/list")
    public RestResponse list(BasePageRequest basePageRequest) {
        Page<Car> cars = carService.listAll(basePageRequest.getPageable());
        return success(cars);
    }
}
