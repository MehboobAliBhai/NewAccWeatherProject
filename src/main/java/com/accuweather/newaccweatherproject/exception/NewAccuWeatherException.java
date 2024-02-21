package com.accuweather.newaccweatherproject.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class NewAccuWeatherException extends RuntimeException {
    private final String message;
    private final String uri;
    private final HttpStatus httpStatus;
    private final String description;
//    private final int timestamp;



}

