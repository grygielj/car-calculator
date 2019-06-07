package com.spring.carculator.serivice;

import com.spring.carculator.model.Consumption;

import java.util.List;


public interface ConsumptionService {
    public List<Consumption> getAllConsumptions();

    public Consumption getConsumptionById(long id);

    public void saveOrUpdate(Consumption consumption,long id);

    public void deleteConsumption(long id);

}
