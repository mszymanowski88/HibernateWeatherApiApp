package com.example.hibernateweatherapiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HibernateWeatherApiAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateWeatherApiAppApplication.class, args);

    }

}
