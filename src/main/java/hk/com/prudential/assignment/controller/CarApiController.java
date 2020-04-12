package hk.com.prudential.assignment.controller;

import hk.com.prudential.assignment.base.BaseRestController;
import hk.com.prudential.assignment.entity.Car;
import hk.com.prudential.assignment.enums.CarStatus;
import hk.com.prudential.assignment.enums.RestCode;
import hk.com.prudential.assignment.model.BasePageRequest;
import hk.com.prudential.assignment.model.RestResponse;
import hk.com.prudential.assignment.model.vo.CarInStock;
import hk.com.prudential.assignment.service.CarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public RestResponse save(@RequestParam(name = "model") String model) {

        Car build = Car.builder().model(model)
                .status(CarStatus.UNSHELVES)
                .build();

        Car save = carService.save(build);
        return success(save);
    }

    @ApiOperation(value = "list")
    @GetMapping("/list")
    public RestResponse list() {
        List<Car> cars = carService.listAll();
        return success(cars);
    }

    @GetMapping("/listByModel")
    public RestResponse listByModel(@RequestParam("model") @NotNull String model) {
        List<Car> listByModel = carService.listByModel(model);
        return success(listByModel);
    }

    @GetMapping("/listCarInStock")
    public RestResponse listCarsInStock() {
        List<Car> cars = carService.listCarsInStock();
        Map<String, Long> collect = cars.stream().collect(Collectors.groupingBy(Car::getModel, Collectors.counting()));
        List<CarInStock> carInStocks = CarInStock.fromMap(collect);
        return success(carInStocks);
    }

    @GetMapping("/listPage")
    public RestResponse listPage(@RequestParam("page") int page,
                                 @RequestParam("size") int size) {
        Page<Car> cars = carService.listPage(PageRequest.of(page, size));
        return success(cars);
    }

    @PostMapping("/shelves")
    public RestResponse shelves(@RequestParam("id") @NotNull String id) {
        Car byId = carService.getById(id);
        if (null == byId) {
            return error(RestCode.ERROR);
        } else {
            carService.shelvesCar(id);
        }
        return success();
    }
}
