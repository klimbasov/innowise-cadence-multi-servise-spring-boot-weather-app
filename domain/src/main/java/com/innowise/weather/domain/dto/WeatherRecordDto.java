package com.innowise.weather.domain.dto;

import lombok.Value;

@Value
public class WeatherRecordDto {
    String city;
    Float temperature;
    String creationDate;
}
