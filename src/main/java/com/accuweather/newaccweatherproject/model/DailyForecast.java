package com.accuweather.newaccweatherproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties
@Data
public class DailyForecast {

    @JsonProperty("Date")
    private String date;

    @JsonProperty("EpochDate")
    private Long epochDate;

    @JsonProperty("Temperature")
    private Temperature temperature;

    @JsonProperty("Day")
    private Day day;

    @JsonProperty("Night")
    private Night night;

    @JsonProperty("Sources")
    private List<String> sources;

    @JsonProperty("MobileLink")
    private String mobileLink;

    @JsonProperty("Link")
    private String link;

}
