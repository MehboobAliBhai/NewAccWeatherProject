package com.accuweather.newaccweatherproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties
@Data
public class Maximum {

    @JsonProperty("Value")
    private Double Value;
    @JsonProperty("Unit")
    private String Unit;
    @JsonProperty("UnitType")
    private Integer UnitType;
}
