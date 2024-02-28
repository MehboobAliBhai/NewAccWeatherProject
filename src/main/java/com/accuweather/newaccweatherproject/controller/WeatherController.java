package com.accuweather.newaccweatherproject.controller;

import com.accuweather.newaccweatherproject.exception.NewAccuWeatherException;
import com.accuweather.newaccweatherproject.model.*;
import com.accuweather.newaccweatherproject.model.request.SearchDayRequest;
import com.accuweather.newaccweatherproject.Service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO :: Write comments : logs is used to track the activity of application.
@Slf4j
@RestController
@RequestMapping("/forecast")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // TODO :: Write Comments
    // use constant instead of string literals
    @GetMapping("/")
    public Forecast getWeather() {
        // TODO :: Use loggers here
        return weatherService.getWeather();
    }

    @GetMapping("/day")
    public List<Day> getDays() {
        return weatherService.getDays();
    }

    @GetMapping("/day/icon")
    public List<Day> getFilterIcon() {

        return weatherService.filterIcon(getDays());
    }

    @GetMapping("/day/phrase")
    public List<Day> getFilterPhrase() {

        return weatherService.filterIconPhrase(getDays());
    }

    @PostMapping("/search/day")
    public List<Day> searchDay(@RequestBody SearchDayRequest searchDayRequest) throws NewAccuWeatherException {
        log.info("Started Search Day Method with Request " + searchDayRequest.toString());

        return weatherService.filter(searchDayRequest);
    }

    @GetMapping("/night")
    public List<Night> getNight() {

        return weatherService.getNight();
    }

    @GetMapping("/night/icon")
    public List<Night> getNightIcon() {

        return weatherService.nightIcon(getNight());
    }

    @GetMapping("/night/iconPhrase")
    public List<Night> getIconPhrase() {
        return weatherService.nightIconPhrase(getNight());
    }

    @GetMapping("/day-and-night")
    public DayNight getDayAndNight(@RequestBody DayNight dayNight) {
        log.info("Started getDayAndNight method with parameter {} ", dayNight.toString());
        DayNight dayNight1 = weatherService.getDayNightData();
        log.info("Ending getDayAndNight Method");
        return dayNight1;
    }

}



