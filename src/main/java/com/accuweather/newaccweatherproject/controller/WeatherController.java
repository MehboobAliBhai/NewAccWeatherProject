package com.accuweather.newaccweatherproject.controller;

import com.accuweather.newaccweatherproject.service.WeatherService;
import com.accuweather.newaccweatherproject.model.Forecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public Forecast getWeather() {
        return weatherService.getWeather();
    }

   }


