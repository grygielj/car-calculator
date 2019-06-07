package com.spring.carculator.serivice;

import com.spring.carculator.model.Car;
import com.spring.carculator.model.Consumption;
import com.spring.carculator.repository.CarRepository;
import com.spring.carculator.repository.ConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ConsumptionServiceImpl implements ConsumptionService{

    @Autowired
    ConsumptionRepository consumptionRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Consumption> getAllConsumptions() {
        return (List<Consumption>) consumptionRepository.findAll();
    }

    @Override
    public Consumption getConsumptionById(long id) {
        return consumptionRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Consumption consumption, long id) {
        Car car = carRepository.findById(id).get();
        consumption.setCar(car);
        consumptionRepository.save(consumption);
    }

    @Override
    public void deleteConsumption(long id) {
        consumptionRepository.deleteById(id);
    }
}
