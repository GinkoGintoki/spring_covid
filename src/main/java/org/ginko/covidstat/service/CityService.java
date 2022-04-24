package org.ginko.covidstat.service;

import org.ginko.covidstat.dto.CityDTO;
import org.ginko.covidstat.dto.mapper.CityMapper;
import org.ginko.covidstat.model.City;
import org.ginko.covidstat.repository.CityRepository;
import org.ginko.covidstat.repository.DailyHospitalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;

    private final DailyHospitalRepository dailyHospitalRepository;

    public CityService(CityRepository cityRepository, DailyHospitalRepository dailyHospitalRepository) {
        this.cityRepository = cityRepository;
        this.dailyHospitalRepository = dailyHospitalRepository;
    }

    public List<CityDTO> getAllCities() {
        List<City> cities = cityRepository.findAll();
        List<CityDTO> cityDTOS = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            CityDTO cityDTO = new CityDTO();
            cityDTO.setId(cities.get(i).getId());
            cityDTO.setName(cities.get(i).getName());
            cityDTO.setTotalCases(cities.get(i).getTotalCases());
            cityDTO.setTotalDeaths(cities.get(i).getTotalDeaths());
            cityDTO.setTotalRecoveries(cities.get(i).getTotalRecoveries());

            cityDTOS.add(cityDTO);
        }
        return cityDTOS;
    }
}
