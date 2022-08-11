package com.innowise.weather.workflow.api;

import com.innowise.weather.domain.dto.WeatherRecordDto;
import com.uber.cadence.workflow.WorkflowMethod;

import java.util.Optional;

public interface WeatherWorkflow {
    @WorkflowMethod(executionStartToCloseTimeoutSeconds = 20, taskList = "testList")
    Optional<WeatherRecordDto> work(String city);
}
