package hk.com.prudential.assignment.test;

import hk.com.prudential.assignment.AssignmentApplicationTests;
import hk.com.prudential.assignment.entity.Car;
import hk.com.prudential.assignment.service.CarService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author zhnlk
 * @date 2020/4/12
 * @mail tomleader0828@gmail.com
 */
public class CarServiceTest extends AssignmentApplicationTests {

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
        Assert.assertEquals("total car number is wrong", 4, totalElements);
    }

    @Test
    public void testGetById() {

    }

    @Test
    public void testUpdate() {

    }

}
