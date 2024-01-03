package com.accuweather.newaccweatherproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties
@Data
public class Headline {

    @JsonProperty("EffectiveDate")
    private String effectiveDate;

    @JsonProperty("EffectiveEpochDate")
    private long effectiveEpochDate;

    @JsonProperty("Severity")
    private int severity;

    @JsonProperty("Text")
    private String text;

    @JsonProperty("Category")
    private String category;

    @JsonProperty("EndDate")
    private String endDate;

    @JsonProperty("EndEpochDate")
    private long endEpochDate;

    @JsonProperty("MobileLink")
    private String mobileLink;

    @JsonProperty("Link")
    private String link;
}
