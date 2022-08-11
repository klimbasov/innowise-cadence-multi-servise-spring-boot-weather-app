package com.innowise.weather.launcher.controller;

import com.innowise.weather.domain.dto.WeatherRecordDto;
import com.innowise.weather.launcher.service.LaunchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("testLauncher")
public class TaskController {

    private final LaunchService service;

    public TaskController(LaunchService service){
        this.service = service;
    }

    @PostMapping("/launch")
    ResponseEntity<WeatherRecordDto> launch(@RequestParam String city){
        WeatherRecordDto dto = service.launch(city);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
