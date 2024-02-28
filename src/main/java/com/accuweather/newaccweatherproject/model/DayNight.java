package com.accuweather.newaccweatherproject.model;

import lombok.Data;

import java.util.List;

@Data
public class DayNight {

    private List<Night> listOfNight;
    private List<Day> listOfDay;
}
