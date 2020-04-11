package hk.com.prudential.assignment.service.impl;

import hk.com.prudential.assignment.entity.Car;
import hk.com.prudential.assignment.repository.CarRepository;
import hk.com.prudential.assignment.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Page<Car> listAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @Override
    public Car get(String carId) {
        return carRepository.getOne(carId);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }
}
