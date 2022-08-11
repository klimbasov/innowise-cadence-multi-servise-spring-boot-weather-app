package com.innowice.weather.workfloworker;

import com.innowise.weather.activity.api.PercipientActivity;
import com.innowise.weather.activity.api.RequestingActivity;
import com.innowise.weather.domain.dto.WeatherRecordDto;
import com.innowise.weather.workflow.api.WeatherWorkflow;
import com.uber.cadence.workflow.Workflow;

import java.util.Optional;

public class CustomWorkFlowImpl implements WeatherWorkflow {
    private final RequestingActivity requestingActivity;
    private final PercipientActivity percipientActivity;

    public CustomWorkFlowImpl(){
        this.requestingActivity = Workflow.newActivityStub(RequestingActivity.class);
        this.percipientActivity = Workflow.newActivityStub(PercipientActivity.class);
    }
    @Override
    public Optional<WeatherRecordDto> work(String str) {
        Optional<WeatherRecordDto> dto = requestingActivity.get(str);

        dto.ifPresent(percipientActivity::store);

        return dto;

    }
}
