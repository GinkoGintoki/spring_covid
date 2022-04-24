package org.ginko.covidstat.service;

import org.ginko.covidstat.model.Hospital;
import org.ginko.covidstat.repository.CityRepository;
import org.ginko.covidstat.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final CityRepository cityRepository;

    public HospitalService(HospitalRepository hospitalRepository, CityRepository cityRepository) {
        this.hospitalRepository = hospitalRepository;
        this.cityRepository = cityRepository;
    }

    public List<Hospital> getHospitalByCityId(Long cityId) {
        return hospitalRepository.findHospitalsByCity(cityRepository.getById(cityId));
    }

}
