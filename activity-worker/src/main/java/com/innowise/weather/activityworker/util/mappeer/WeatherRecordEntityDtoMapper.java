package com.innowise.weather.activityworker.util.mappeer;

import com.innowise.weather.domain.dto.WeatherRecordDto;
import com.innowise.weather.domain.entity.WeatherRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WeatherRecordEntityDtoMapper {
    @Mapping(target = "id", constant = "0L")
    @Mapping(target = "creationDateTime", expression = "java(java.time.LocalDateTime.parse(dto.getCreationDate()))")
    @Mapping(target = "city", source = "city")
    WeatherRecord toEntity(WeatherRecordDto dto);
    WeatherRecordDto toDto(WeatherRecord entity);
}
