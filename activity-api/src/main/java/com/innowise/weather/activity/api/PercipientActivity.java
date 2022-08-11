package com.innowise.weather.activity.api;

import com.innowise.weather.domain.dto.WeatherRecordDto;
import com.uber.cadence.activity.ActivityMethod;

public interface PercipientActivity {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 20, taskList = "testList")
    WeatherRecordDto store(WeatherRecordDto dto);
}
