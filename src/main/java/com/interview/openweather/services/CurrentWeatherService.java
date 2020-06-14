package com.interview.openweather.services;

import com.interview.openweather.dto.WeatherDto;

public interface CurrentWeatherService {
    WeatherDto getCurrentWeatherByCityID(String cityId);
    WeatherDto getCurrentWeatherByGeographicCoordinates(String lat, String lon);
    WeatherDto getCurrentWeatherByZipCode(String zipCode);
}
