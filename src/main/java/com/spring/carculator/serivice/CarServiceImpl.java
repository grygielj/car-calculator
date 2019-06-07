package com.spring.carculator.serivice;

import com.spring.carculator.model.Car;
import com.spring.carculator.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return (List<Car>)carRepository.findAll();
    }

    @Override
    public Car getCarById(long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }
    @Override
    public void updateConsumption(Car car,float consumption){
        car.setConsumption(consumption);
        carRepository.save(car);
    }
    @Override
    public void updateCost(Car car, float cost) {
        car.setCost(cost);
        carRepository.save(car);
    }
}
