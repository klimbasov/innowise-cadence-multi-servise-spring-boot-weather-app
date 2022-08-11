package com.innowise.weather.launcher.config;

import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({"com.innowise.weather.launcher"})
public class LaunchConfiguration implements WebMvcConfigurer {

    @Value("${cadence.domain:default}")
    private String DOMAIN;

    @Bean
    public WorkflowClient workflowClient(){
        return WorkflowClient.newInstance(
                new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
                WorkflowClientOptions.newBuilder().setDomain(DOMAIN).build());
    }
}
