package org.ginko.covidstat.service;

import org.ginko.covidstat.dto.CityDTO;
import org.ginko.covidstat.dto.DailyCityDTO;
import org.ginko.covidstat.dto.DailyHospitalQuery;
import org.ginko.covidstat.dto.DailyHospitalToCityDTO;
import org.ginko.covidstat.model.City;
import org.ginko.covidstat.repository.CityRepository;
import org.ginko.covidstat.repository.DailyHospitalRepository;
import org.ginko.covidstat.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    private final DailyHospitalRepository dailyHospitalRepository;

    private HospitalRepository hospitalRepository;

    public CityService(CityRepository cityRepository, DailyHospitalRepository dailyHospitalRepository, HospitalRepository hospitalRepository) {
        this.cityRepository = cityRepository;
        this.dailyHospitalRepository = dailyHospitalRepository;
        this.hospitalRepository = hospitalRepository;
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
        List<DailyHospitalQuery> dtos = dailyHospitalRepository.getDailyHospitalsToCity(cityId);
        List<DailyHospitalToCityDTO> res = new ArrayList<>();
        for (DailyHospitalQuery dto : dtos) {
            DailyHospitalToCityDTO dailyHospitalToCityDTO = new DailyHospitalToCityDTO();
            dailyHospitalToCityDTO.setCases(dto.getCases());
            dailyHospitalToCityDTO.setDeaths(dto.getDeaths());
            dailyHospitalToCityDTO.setRecoveries(dto.getRecoveries());
            dailyHospitalToCityDTO.setDateTime(dto.getDateTime());
            res.add(dailyHospitalToCityDTO);
        }
        cityDTO.setDailyCity(res);

        return cityDTO;
    }

    public DailyCityDTO getDailyCity(Long id) {
        DailyHospitalQuery dailyHospitalQuery = dailyHospitalRepository.getDailyCity(id);
        DailyCityDTO dto = new DailyCityDTO();
        dto.setCases(dailyHospitalQuery.getCases());
        dto.setDeaths(dailyHospitalQuery.getDeaths());
        dto.setRecoveries(dailyHospitalQuery.getRecoveries());
        dto.setDtUpdate(dailyHospitalQuery.getDateTime());
        return dto;
    }

    public Long getHospitalByCity(Long id) {
        return hospitalRepository.findTopByCityIdOrderByDtUpdate(id).getId();
    }
}
