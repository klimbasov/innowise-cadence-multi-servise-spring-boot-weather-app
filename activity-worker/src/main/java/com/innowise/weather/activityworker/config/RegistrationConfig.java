package com.innowise.weather.activityworker.config;

import com.innowise.weather.activity.api.PercipientActivity;
import com.innowise.weather.activity.api.RequestingActivity;
import com.innowise.weather.registration.ActivityRegistration;
import com.innowise.weather.registration.DomainRegistration;
import com.innowise.weather.registration.impl.ActivityRegistrationImpl;
import com.innowise.weather.registration.impl.DomainRegistrationImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistrationConfig {

    @Value("${cadence.domain: default}")
    private String DOMAIN;

    @Value("${cadence.task-list: default}")
    private String TASK_LIST;

    @Bean
    public DomainRegistration domainRegistration(){
        return new DomainRegistrationImpl();
    }

    @Bean
    public ActivityRegistration activityRegistration(){
        return new ActivityRegistrationImpl();
    }


    @Bean
    public CommandLineRunner commandLineRunner(RequestingActivity requestingActivity,
                                               PercipientActivity percipientActivity,
                                               DomainRegistration domainRegistration,
                                               ActivityRegistration activityRegistration){
        return args -> {
            domainRegistration.register(DOMAIN);
            activityRegistration.register(DOMAIN, TASK_LIST, requestingActivity, percipientActivity);
        };
    }
}
