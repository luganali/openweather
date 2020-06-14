package com.interview.openweather.api;

import com.interview.openweather.entity.City;
import com.interview.openweather.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CityApi {

    @Autowired
    private CityService cityService;

    @GetMapping(path = "/cities/{id}")
    public ResponseEntity findByCityId(@PathVariable("id") Long id){

        Optional<City> city = cityService.findByCityId(id);
        return ResponseEntity.ok().body(city.get());
    }

    @PostMapping(path = "/cities")
    public ResponseEntity save(@RequestBody City city){
        City city1 =cityService.save(city);
        return ResponseEntity.ok().body(city1);
    }
}
