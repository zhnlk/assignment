package hk.com.prudential.assignment.test;

import hk.com.prudential.assignment.AssignmentApplication;
import hk.com.prudential.assignment.entity.Car;
import hk.com.prudential.assignment.enums.CarStatus;
import hk.com.prudential.assignment.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    public void testListAll() {
        List<Car> cars = carService.listAll();
        Assert.assertEquals("total car num is wrong", 2, cars.size());
    }

    @Test
    public void testListPage() {
        Page<Car> cars = carService.listPage(PageRequest.of(0, 5));
        long totalElements = cars.getTotalElements();
        Assert.assertEquals("total car number is wrong", 2, totalElements);
    }

    @Test
    public void testGetById() {
        String carId = "ff808081716d245201716d250b1e0000";
        Car byId = carService.getById(carId).orElse(null);
        Assert.assertNotNull("car is wrong", byId);
    }

    @Test
    public void testCarSave() {
        Car car = Car.builder().model("test car").build();
        Car save = carService.save(car);

        Assert.assertEquals(car, save);
    }

    @Test
    public void testCarUpdate() {
        String model = "new_model";
        String carId = "ff808081716d245201716d250b1e0000";
        Car car = carService.getById(carId).orElse(null);

        assert car != null;

        car.setModel(model);
        Car save = carService.save(car);

        Assert.assertEquals(save.getModel(), model);

    }

    @Test
    public void testShelvesCar() {
        String carId = "ff808081716d245201716d250b1e0000";
        carService.shelvesCar(carId);

        Car car = carService.getById(carId).orElse(null);
        assert car != null;

        Assert.assertEquals(car.getStatus(), CarStatus.SHELVES);

    }

}
