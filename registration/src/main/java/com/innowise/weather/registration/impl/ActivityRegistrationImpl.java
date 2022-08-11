package com.innowise.weather.registration.impl;

import com.innowise.weather.registration.ActivityRegistration;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;

public class ActivityRegistrationImpl implements ActivityRegistration {
    @Override
    public void register(String domain, String taskList, Object... activityInstances) {
        WorkflowClient workflowClient =
                WorkflowClient.newInstance(
                        new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
                        WorkflowClientOptions.newBuilder().setDomain(domain).build());
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker(taskList);
        worker.registerActivitiesImplementations(activityInstances);
        factory.start();
    }
}
