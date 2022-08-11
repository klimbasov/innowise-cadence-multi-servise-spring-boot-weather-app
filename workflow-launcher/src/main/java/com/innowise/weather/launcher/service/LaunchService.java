package com.innowise.weather.launcher.service;

import com.innowise.weather.domain.dto.WeatherRecordDto;

public interface LaunchService {
    WeatherRecordDto launch(String name);
}
