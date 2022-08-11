package com.innowise.weather.registration.impl;

import com.innowise.weather.registration.WorkflowRegistration;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;

public class WorkflowRegistrationImpl implements WorkflowRegistration {
    @Override
    public void register(String domain, String taskList, Class<?> workflowClass) {
        WorkflowClient workflowClient =
                WorkflowClient.newInstance(
                        new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
                        WorkflowClientOptions.newBuilder().setDomain(domain).build());
        // Get worker to poll the task list.
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker(taskList);
        worker.registerWorkflowImplementationTypes(workflowClass);
        factory.start();

    }
}
