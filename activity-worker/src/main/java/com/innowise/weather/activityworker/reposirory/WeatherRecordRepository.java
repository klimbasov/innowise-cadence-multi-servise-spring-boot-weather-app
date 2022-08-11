package com.innowise.weather.activityworker.reposirory;

import com.innowise.weather.domain.entity.WeatherRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRecordRepository extends JpaRepository<WeatherRecord, Long> {
}
