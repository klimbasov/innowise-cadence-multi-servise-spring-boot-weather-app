package com.innowise.weather.activityworker.service.impl;

import com.innowise.weather.activityworker.reposirory.WeatherRecordRepository;
import com.innowise.weather.activityworker.service.PersistentService;
import com.innowise.weather.activityworker.util.mappeer.WeatherRecordEntityDtoMapper;
import com.innowise.weather.domain.dto.WeatherRecordDto;
import com.innowise.weather.domain.entity.WeatherRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersistentServiceImpl implements PersistentService {

    private final WeatherRecordRepository dao;
    private final WeatherRecordEntityDtoMapper mapper;

    @Override
    public WeatherRecordDto save(WeatherRecordDto dto) {
        WeatherRecord entity = mapper.toEntity(dto);
        return mapper.toDto(dao.save(entity));
    }
}
