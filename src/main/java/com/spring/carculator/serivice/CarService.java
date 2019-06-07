package com.spring.carculator.serivice;

import com.spring.carculator.model.Car;

import java.util.List;

public interface CarService {

    public List<Car> getAllCars();

    public Car getCarById(long id);

    public void saveOrUpdate(Car car);

    public void deleteCar(long id);

    public void updateConsumption(Car car,float consumption);

    public void updateCost(Car car, float cost);
}
