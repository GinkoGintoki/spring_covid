package org.ginko.covidstat.controller;

import org.ginko.covidstat.dto.CityDTO;
import org.ginko.covidstat.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public List<CityDTO> getAllCities() {
        return cityService.getAllCities();
    }

}
