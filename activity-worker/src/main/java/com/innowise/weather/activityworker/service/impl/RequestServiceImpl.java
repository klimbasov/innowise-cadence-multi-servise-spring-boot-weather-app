package com.innowise.weather.activityworker.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.innowise.weather.activityworker.exeption.ServiceException;
import com.innowise.weather.activityworker.service.RequestingService;
import com.innowise.weather.domain.dto.WeatherRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestingService {

    private final WebClient client;
    private final JsonMapper mapper;

    @Value("${openweathermap.appid}")
    private String appid;
    @Override
    public Optional<WeatherRecordDto> get(String city) {
        String response = getResponse(city);
        try {
            return parseResponse(city, response);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage(), e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Optional<WeatherRecordDto> parseResponse(String city, String response) throws JsonProcessingException {
        Optional<WeatherRecordDto> optionalWeatherRecordDto = Optional.empty();
        String caseInsensitiveCityName = city.toLowerCase();
        JsonNode root = mapper.readTree(response).path("list");
        Iterator<JsonNode> iter = root.elements();
        while (iter.hasNext()){
            JsonNode node = iter.next();
            String name = node.path("name").asText();
            if(name.toLowerCase().equals(caseInsensitiveCityName)){
                Float temperature = ((float) node.at("/main/temp").asDouble());
                optionalWeatherRecordDto = Optional.of(
                        new WeatherRecordDto(name, temperature, LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).toString())
                );
            }
        }
        return optionalWeatherRecordDto;
    }

    private String getResponse(String city) {
        return client.get()
                .uri(getURL(city)
                ).retrieve().bodyToMono(String.class).block();
    }

    private String getURL(String city) {
        return UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host("openweathermap.org")
                .path("/data/2.5/find")
                .queryParam("q", city)
                .queryParam("appid", appid)
                .build()
                .toString();
    }
}
