package com.spring.carculator.controller;

import com.spring.carculator.model.Car;
import com.spring.carculator.model.Consumption;
import com.spring.carculator.serivice.CarService;
import com.spring.carculator.serivice.ConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class ConsumptionController {
    @Autowired
    ConsumptionService consumptionService;

    @Autowired
    CarService carService;

    @RequestMapping(value = "/consumption_list/{id}", method = RequestMethod.GET)
    public ModelAndView list(@PathVariable long id) {
        ModelAndView model = new ModelAndView("consumption_list");
        Car car = carService.getCarById(id);
        List<Consumption> consumptionList = car.getConsumptions();
        model.addObject("consumptionList",consumptionList);
        model.addObject("id",car.getId());

        return model;
    }

    @RequestMapping(value = "/addConsumption/{id}", method = RequestMethod.GET)
    public ModelAndView addConsumption(@PathVariable long id) {
        ModelAndView model = new ModelAndView();
        Car car = carService.getCarById(id);
        model.addObject("carForm", car);
        model.setViewName("consumption_form");

        return model;
    }

    @RequestMapping(value = "/saveConsumption", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("carForm") Car car,@RequestParam String range, @RequestParam String liters,@RequestParam String bill) {
        long id = car.getId();

        float fbill = Float.parseFloat(bill);
        float fliters = Float.parseFloat(liters);
        float frange = Float.parseFloat(range);
        float price = fbill/fliters;
        float consum = fliters/frange * 100;
        float costs = price*consum;

        car.setConsumption(consum);
        car.setCost(costs);

        float oldConsumption = car.getConsumption();
        float oldCost = car.getCost();
        float meanConsumption;
        float meanCosts;

        if(oldConsumption == 0){
            meanConsumption=consum;
        }else
            meanConsumption = (oldConsumption+consum)/2;

        if(oldCost == 0){
            meanCosts = costs;
        }else
            meanCosts = (oldCost+costs)/2;

        car.setConsumption(meanConsumption);
        car.setCost(meanCosts);

        Consumption lastConsumption = new Consumption(frange,fliters,costs,fbill,price,consum);

        carService.saveOrUpdate(car);
        consumptionService.saveOrUpdate(lastConsumption,id);

        return new ModelAndView("redirect:/consumption_list/"+id);
    }

    @RequestMapping(value = "/deleteConsumption/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id) {

        Consumption consumption = consumptionService.getConsumptionById(id);
        long idcar = consumption.getCar().getId();
        consumptionService.deleteConsumption(id);

        return new ModelAndView("redirect:/consumption_list/"+idcar);
    }
}
