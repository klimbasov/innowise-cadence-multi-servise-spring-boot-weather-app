package com.innowise.weather.registration.impl;

import com.innowise.weather.registration.DomainRegistration;
import com.innowise.weather.registration.exception.RegistrationException;
import com.uber.cadence.DomainAlreadyExistsError;
import com.uber.cadence.RegisterDomainRequest;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.IWorkflowService;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import org.apache.thrift.TException;

public class DomainRegistrationImpl implements DomainRegistration {
    private static final int DEFAULT_EXECUTION_RETENTION_PERIOD_IN_DAYS = 3;
    @Override
    public void register(String domain) {
        IWorkflowService service = new WorkflowServiceTChannel(ClientOptions.defaultInstance());
        RegisterDomainRequest request = new RegisterDomainRequest();
        request.setName(domain).setWorkflowExecutionRetentionPeriodInDays(DEFAULT_EXECUTION_RETENTION_PERIOD_IN_DAYS);
        try {
            service.RegisterDomain(request);
        }
        catch (DomainAlreadyExistsError ignored){}
        catch (TException e) {
            throw new RegistrationException(e);
        }

    }

}
