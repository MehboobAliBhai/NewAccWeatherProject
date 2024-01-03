package com.accuweather.newaccweatherproject.model;

import com.accuweather.newaccweatherproject.model.Maximum;
import com.accuweather.newaccweatherproject.model.Minimum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class Temperature {



    @JsonProperty("Minimum")
    private Minimum Minimum;
    @JsonProperty("Maximum")
    private Maximum Maximum;
}
