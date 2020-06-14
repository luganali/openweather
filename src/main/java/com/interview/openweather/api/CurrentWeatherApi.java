package com.interview.openweather.api;

import com.interview.openweather.dto.WeatherDto;
import com.interview.openweather.services.CurrentWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentWeatherApi {

    @Autowired
    private CurrentWeatherService currentWeatherService;

    @GetMapping(path = "/weather/city")
    public ResponseEntity<WeatherDto> getWeatherInformation(@RequestParam(value = "id") String cityId) {
        WeatherDto weatherDto =  currentWeatherService.getCurrentWeatherByCityID(cityId);
        return ResponseEntity.ok().body(weatherDto);
    }

}
