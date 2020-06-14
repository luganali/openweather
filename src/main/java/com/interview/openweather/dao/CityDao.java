package com.interview.openweather.dao;

import com.interview.openweather.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Long> {
    City findByName(String name);
}
