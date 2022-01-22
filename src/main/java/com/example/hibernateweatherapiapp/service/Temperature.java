package com.example.hibernateweatherapiapp.service;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "temperature")
public class Temperature {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CityName")
    private String city;
    @Column(name = "TemperatureInCity")
    private Double temperature;
    @Column(name = "Date")
    private LocalDate localDate = LocalDate.now();
    @Column(name = "Time")
    private LocalTime localTime = LocalTime.now();


    public Temperature() {
    }

    public Temperature(String city, Double temperature) {

        this.city = city;
        this.temperature = temperature;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }


    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
