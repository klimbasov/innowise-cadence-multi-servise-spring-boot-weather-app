package com.innowise.weather.activityworker.service;

import com.innowise.weather.domain.dto.WeatherRecordDto;

public interface PersistentService {

    WeatherRecordDto save(WeatherRecordDto dto);
}
