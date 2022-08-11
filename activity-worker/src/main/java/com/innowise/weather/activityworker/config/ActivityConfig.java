package com.innowise.weather.activityworker.config;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ComponentScan("com.innowise.weather")
@EntityScan("com.innowise.weather")
public class ActivityConfig {

    @Bean
    public WebClient webClient(){
        return WebClient.create("https://openweathermap.org/data/2.5/find");
    }

    @Bean
    public JsonMapper jsonMapper(){
        return new JsonMapper();
    }
}
