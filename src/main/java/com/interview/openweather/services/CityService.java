package com.interview.openweather.services;

import com.interview.openweather.entity.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    Optional<City> findByCityId(Long id);
    City findByCityName(String name);
    List<City> findAll();
    City save(City city);
}
