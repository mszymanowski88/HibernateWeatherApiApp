package com.example.hibernateweatherapiapp.service;

import com.example.hibernateweatherapiapp.api.WeatherApi;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {


    private final String apiKey = "b9723ee1e5644cb925dd31f0e4f408cc";

    public WeatherService() {
    }


    public WeatherApi getWeahter(String city) {

        RestTemplate restTemplate = new RestTemplate();
        WeatherApi weather = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey, WeatherApi.class);

        return weather;


    }


    public Double getTemperatureFromApi(String city) {


        return getWeahter(city).getMain().getTemp();

    }


}
