package com.innowise.weather.activityworker.activity.impl;

import com.innowise.weather.activity.api.PercipientActivity;
import com.innowise.weather.activityworker.service.PersistentService;
import com.innowise.weather.domain.dto.WeatherRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PercipientActivityImpl implements PercipientActivity {
    private final PersistentService service;

    @Override
    public WeatherRecordDto store(WeatherRecordDto weatherRecordDto) {
        return service.save(weatherRecordDto);

    }
}
