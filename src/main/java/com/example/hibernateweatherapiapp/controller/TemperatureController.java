package com.example.hibernateweatherapiapp.controller;

import com.example.hibernateweatherapiapp.model.Temperature;
import com.example.hibernateweatherapiapp.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class TemperatureController implements WebMvcConfigurer {


    private final WeatherServiceImpl weatherServiceImpl;


    @Autowired
    public TemperatureController(WeatherServiceImpl weatherServiceImpl) {

        this.weatherServiceImpl = weatherServiceImpl;

    }


    @GetMapping("/start")
    public String saveTemperatureInDatabase(Model model) {

        model.addAttribute("result", weatherServiceImpl.finaAllTemperatureRecords());
        model.addAttribute("temperature", new Temperature());


        return "start";
    }


    @PostMapping("/add")
    public String addInput(@ModelAttribute Temperature temperature) throws InterruptedException {


        weatherServiceImpl.saveWeatherResult(temperature);


        return "redirect:/start";

    }


}




