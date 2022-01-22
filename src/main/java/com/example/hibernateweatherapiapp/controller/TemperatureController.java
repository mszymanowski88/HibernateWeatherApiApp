package com.example.hibernateweatherapiapp.controller;

import com.example.hibernateweatherapiapp.dao.WeatherRepo;
import com.example.hibernateweatherapiapp.service.Temperature;
import com.example.hibernateweatherapiapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Controller
public class TemperatureController implements WebMvcConfigurer {

    WeatherRepo weatherRepo;

    WeatherService weatherService;


    @Autowired
    public TemperatureController(WeatherRepo weatherRepo, WeatherService weatherService) {
        this.weatherRepo = weatherRepo;
        this.weatherService = weatherService;

    }


    @GetMapping("/start")
    public String saveTemperatureInDatabase(Model model) {

        model.addAttribute("result", weatherRepo.findAll());


        return "start";
    }


    @PostMapping("/add")
    public String addCar(@RequestParam(value = "input", required = false) String input) throws InterruptedException {


        Runnable helloRunnable = new Runnable() {
            public void run() {
                weatherRepo.save(new Temperature(input, weatherService.getTemperatureFromApi(input)));
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 3, TimeUnit.SECONDS);


        return "redirect:/start";

    }


}




