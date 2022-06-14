package org.ginko.covidstat.service;

import org.ginko.covidstat.dto.CityDTO;
import org.ginko.covidstat.model.City;
import org.ginko.covidstat.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public CityDTO getCityInfo(Long cityId) {
        City city = cityRepository.getById(cityId);

        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(cityId);
        cityDTO.setName(city.getName());
        cityDTO.setTotalCases(city.getTotalCases());
        cityDTO.setTotalDeaths(city.getTotalDeaths());
        cityDTO.setTotalRecoveries(city.getTotalRecoveries());
        cityDTO.setDtUpdate(city.getDtUpdate());

        return cityDTO;
    }
}
