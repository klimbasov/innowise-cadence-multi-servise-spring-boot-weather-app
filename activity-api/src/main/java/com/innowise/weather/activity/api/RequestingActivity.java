package com.innowise.weather.activity.api;

import com.innowise.weather.domain.dto.WeatherRecordDto;
import com.uber.cadence.activity.ActivityMethod;

import java.util.Optional;

public interface RequestingActivity {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 20, taskList = "testList")
    Optional<WeatherRecordDto> get(String city);
}
