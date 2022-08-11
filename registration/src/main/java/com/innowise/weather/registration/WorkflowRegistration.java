package com.innowise.weather.registration;

public interface WorkflowRegistration {
    void register(String domain, String taskList, Class<?> workflowClass);
}
