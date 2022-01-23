package com.example.hibernateweatherapiapp.service;

import com.example.hibernateweatherapiapp.api.WeatherApi;
import com.example.hibernateweatherapiapp.model.Temperature;

import java.util.List;

public interface WetaherService {

    WeatherApi getWeahter(String city);
    Double getTemperatureFromApi(String city);
    public void saveWeatherResult(Temperature temperature) throws InterruptedException;
    public List<Temperature> finaAllTemperatureRecords();

}
