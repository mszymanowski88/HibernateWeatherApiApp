package com.example.hibernateweatherapiapp.dao;

import com.example.hibernateweatherapiapp.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepo extends JpaRepository<Temperature, Long> {


}
