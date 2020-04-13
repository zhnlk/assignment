package hk.com.prudential.assignment.service.impl;

import hk.com.prudential.assignment.entity.Car;
import hk.com.prudential.assignment.enums.CarStatus;
import hk.com.prudential.assignment.repository.CarRepository;
import hk.com.prudential.assignment.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Car> listAll() {
        return carRepository.findAll();
    }

    @Override
    public Page<Car> listPage(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @Override
    public Optional<Car> getById(String carId) {
        return carRepository.findById(carId);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> listCarsInStock() {
        List<Car> cars = carRepository.listByCarStatus(CarStatus.SHELVES);
        return cars;
    }

    @Override
    public List<Car> listByModel(String model) {
        return carRepository.listByModel(model);
    }

    @Override
    public void shelvesCar(String id) {
        carRepository.switchCarStatus(id, CarStatus.SHELVES);
    }
}
