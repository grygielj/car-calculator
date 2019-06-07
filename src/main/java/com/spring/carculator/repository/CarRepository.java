package com.spring.carculator.repository;

import com.spring.carculator.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
