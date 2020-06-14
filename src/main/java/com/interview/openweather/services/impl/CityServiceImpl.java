package com.interview.openweather.services.impl;

import com.interview.openweather.dao.CityDao;
import com.interview.openweather.entity.City;
import com.interview.openweather.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityDao cityDao;


    @Override
    public Optional<City> findByCityId(Long id) {
        return cityDao.findById(id);
    }

    @Override
    public City findByCityName(String name) {
        return cityDao.findByName(name);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public City save(City city) {
        cityDao.save(city);
        return city;
    }
}
