package com.innowice.weather.workfloworker;

import com.innowise.weather.registration.impl.WorkflowRegistrationImpl;

public class Main {

    public static void main(String[] args) {
        if(args.length < 2){
            throw new IllegalArgumentException("Invalid application parameters. Parameter signature is: domain name, task-list name.");
        }
        registerWorkflow(args[0], args[1]);
    }

    public static void registerWorkflow(String domain, String taskList){
        new WorkflowRegistrationImpl().register(domain, taskList, CustomWorkFlowImpl.class);
    }

}
