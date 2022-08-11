package com.innowise.weather.launcher.service.impl;

import com.innowise.weather.domain.dto.WeatherRecordDto;
import com.innowise.weather.launcher.service.LaunchService;
import com.innowise.weather.launcher.service.exception.ServiceException;
import com.innowise.weather.workflow.api.WeatherWorkflow;
import com.uber.cadence.client.WorkflowClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LaunchServiceImpl implements LaunchService {
    private final WorkflowClient client;
    @Override
    public WeatherRecordDto launch(String name) {
        WeatherWorkflow workflow = client.newWorkflowStub(WeatherWorkflow.class);

        return workflow.work(name).orElseThrow(() -> new ServiceException("not found", HttpStatus.NOT_FOUND));
    }
}
