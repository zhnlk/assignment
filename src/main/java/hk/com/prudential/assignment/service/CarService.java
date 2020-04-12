package hk.com.prudential.assignment.service;

import hk.com.prudential.assignment.base.BaseService;
import hk.com.prudential.assignment.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
public interface CarService extends BaseService<Car> {

    Car save(Car car);

    List<Car> listAll();

    Page<Car> listPage(Pageable pageable);

    Car getById(String carId);

    Car update(Car car);

    List<Car> listCarsInStock();

    List<Car> listByModel(String model);

    void shelvesCar(String id);
}
