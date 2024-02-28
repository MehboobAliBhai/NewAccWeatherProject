package com.accuweather.newaccweatherproject.controller;

import com.accuweather.newaccweatherproject.exception.NewAccuWeatherException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(NewAccuWeatherException ex, WebRequest request) {

        String bodyResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
