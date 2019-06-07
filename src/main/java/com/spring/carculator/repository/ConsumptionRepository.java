package com.spring.carculator.repository;

import com.spring.carculator.model.Consumption;
import org.springframework.data.repository.CrudRepository;

public interface ConsumptionRepository extends CrudRepository<Consumption,Long> {
}
