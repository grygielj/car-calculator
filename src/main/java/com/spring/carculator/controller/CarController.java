package com.spring.carculator.controller;

import com.spring.carculator.model.Car;
import com.spring.carculator.serivice.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/")
    public ModelAndView homePage(){
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("car_list");
        List<Car> carList = carService.getAllCars();
        model.addObject("carList", carList);

        return model;
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.GET)
    public ModelAndView addCar() {
        ModelAndView model = new ModelAndView();
        Map< String, String > petrols = new HashMap<String, String>();
        petrols.put("gasoline", "gasoline");
        petrols.put("LPG", "LPG");
        petrols.put("diesel", "diesel");

        model.addObject("petrols", petrols);
        Car car = new Car();
        model.addObject("carForm", car);
        model.setViewName("car_form");

        return model;
    }


    @RequestMapping(value = "/saveCar", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("carForm") Car car) {
        carService.saveOrUpdate(car);

        return new ModelAndView("redirect:/list");
    }

    @RequestMapping(value = "/deleteCar/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id) {

        carService.deleteCar(id);

        return new ModelAndView("redirect:/list");
    }





}