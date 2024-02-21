package com.accuweather.newaccweatherproject.controller;

import com.accuweather.newaccweatherproject.exception.NewAccuWeatherException;
import com.accuweather.newaccweatherproject.model.DailyForecast;
import com.accuweather.newaccweatherproject.model.Day;
import com.accuweather.newaccweatherproject.model.Night;
import com.accuweather.newaccweatherproject.model.request.SearchDayRequest;
import com.accuweather.newaccweatherproject.service.WeatherService;
import com.accuweather.newaccweatherproject.model.Forecast;
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

    @GetMapping ("/night")
    public List<Night> getNight(){

        return weatherService.getNight();
        }

    @GetMapping("/night/icon")
    public List<Night> getNightIcon() {

        return weatherService.nightIcon(getNight());
    }
    @GetMapping("/night/iconPhrase")
    public List<Night> getIconPhrase(){
        return weatherService.nightIconPhrase(getNight());
    }
}



