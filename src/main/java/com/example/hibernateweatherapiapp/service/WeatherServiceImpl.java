package com.example.hibernateweatherapiapp.service;

import com.example.hibernateweatherapiapp.api.WeatherApi;
import com.example.hibernateweatherapiapp.dao.WeatherRepo;
import com.example.hibernateweatherapiapp.model.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherServiceImpl implements WetaherService {


    private final String apiKey = "b9723ee1e5644cb925dd31f0e4f408cc";
    private final WeatherRepo weatherRepo;


    @Autowired
    public WeatherServiceImpl(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
    }

    @Override
    public WeatherApi getWeahter(String city) {

        RestTemplate restTemplate = new RestTemplate();
        WeatherApi weather = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey, WeatherApi.class);

        return weather;


    }

    @Override
    public Double getTemperatureFromApi(String city) {


        return getWeahter(city).getMain().getTemp();

    }

    @Override
    public void saveWeatherResult(Temperature temperature) {


        Runnable helloRunnable = new Runnable() {

            public void run() {
                weatherRepo.save(new Temperature(temperature.getCity(), getTemperatureFromApi(temperature.getCity())));
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 3, TimeUnit.SECONDS);

    }

    @Override
    public List<Temperature> finaAllTemperatureRecords() {

        return weatherRepo.findAll();
    }


}
