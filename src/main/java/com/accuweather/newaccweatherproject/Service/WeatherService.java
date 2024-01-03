package com.accuweather.newaccweatherproject.service;

import lombok.RequiredArgsConstructor;
import com.accuweather.newaccweatherproject.model.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherService {

    @Value("${external.api.url}")
    private String apiUrl;

    @Autowired
    private final RestTemplate restTemplate;

    public Forecast getWeather() {
        System.out.println("API URL: " + apiUrl);
        try {
            return restTemplate.getForObject(apiUrl, Forecast.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}












//    @Value("${external.api.url}")
//    private String apiKey;
//
//    private RestTemplate;
//
//    public void ServiceLayer(RestTemplate restTemplate) {
//
//        this.restTemplate = restTemplate;
//    }
//    public ServiceLayer(String apiKey) {
//        this.apiKey = apiKey;
//    }
//
//    public String getWeatherData(String city) {
//        String apiUrl = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/340969";
//        String apiKeyParam = "?apikey=" + apiKey;
//        String cityParam = "&q=" + city;
//
//        String url = apiUrl + apiKeyParam + cityParam;
//
//        return restTemplate.getForObject(url, String.class);
//    }

