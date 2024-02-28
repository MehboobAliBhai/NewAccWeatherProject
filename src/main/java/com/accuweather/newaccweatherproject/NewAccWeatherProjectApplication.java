package com.accuweather.newaccweatherproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@Configuration
public class NewAccWeatherProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewAccWeatherProjectApplication.class, args);
    }

    //TODO :: Create the config package and move this there
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
