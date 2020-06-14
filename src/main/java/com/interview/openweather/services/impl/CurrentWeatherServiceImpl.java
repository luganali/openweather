package com.interview.openweather.services.impl;

import com.interview.openweather.dto.WeatherDto;
import com.interview.openweather.services.CurrentWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    @Value("${openweather.api.url}")
    private String apiURL;

    @Value("${openweather.api.version}")
    private String apiVersion;

    private static final String MICRO_SERVICE_URL="/weather";


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherDto getCurrentWeatherByCityID(String cityId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiURL+apiVersion+MICRO_SERVICE_URL)
                .queryParam("id", cityId);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<WeatherDto> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                WeatherDto.class);

        return response.getBody();
    }

    @Override
    public WeatherDto getCurrentWeatherByGeographicCoordinates(String lat, String lon) {
        return null;
    }

    @Override
    public WeatherDto getCurrentWeatherByZipCode(String zipCode) {
        return null;
    }

}
