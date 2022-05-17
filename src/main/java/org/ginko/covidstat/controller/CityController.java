package org.ginko.covidstat.controller;

import org.ginko.covidstat.dto.CityDTO;
import org.ginko.covidstat.model.City;
import org.ginko.covidstat.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/info/get/{id}")
    public CityDTO getCityInfo(@PathVariable(name = "id") Long cityId) {
        return cityService.getCityInfo(cityId);
    }
}
