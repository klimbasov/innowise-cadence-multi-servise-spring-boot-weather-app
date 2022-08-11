package com.innowise.weather.activityworker.activity.impl;

import com.innowise.weather.activity.api.RequestingActivity;
import com.innowise.weather.activityworker.service.RequestingService;
import com.innowise.weather.domain.dto.WeatherRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RequestingActivityImpl implements RequestingActivity {
    private final RequestingService service;
    @Override
    public Optional<WeatherRecordDto> get(String s) {
        return service.get(s);
    }
}
