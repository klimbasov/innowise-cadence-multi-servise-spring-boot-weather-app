package com.innowise.weather.activityworker.service;

import com.innowise.weather.domain.dto.WeatherRecordDto;

import java.util.Optional;

public interface RequestingService {

    Optional<WeatherRecordDto> get(String city);
}
