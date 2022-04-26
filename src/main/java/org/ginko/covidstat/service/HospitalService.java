package org.ginko.covidstat.service;

import org.ginko.covidstat.dto.DailyHospitalToCityDTO;
import org.ginko.covidstat.dto.HospitalDTO;
import org.ginko.covidstat.model.DailyHospital;
import org.ginko.covidstat.model.Hospital;
import org.ginko.covidstat.repository.CityRepository;
import org.ginko.covidstat.repository.DailyHospitalRepository;
import org.ginko.covidstat.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final CityRepository cityRepository;
    private final DailyHospitalRepository dailyHospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository, CityRepository cityRepository, DailyHospitalRepository dailyHospitalRepository) {
        this.hospitalRepository = hospitalRepository;
        this.cityRepository = cityRepository;
        this.dailyHospitalRepository = dailyHospitalRepository;
    }

    public List<HospitalDTO> getHospitalsByCityId(Long cityId) {
        List<Hospital> hospitals = hospitalRepository.findHospitalsByCity(cityRepository.getById(cityId));
        List<HospitalDTO> dtos = new ArrayList<>();
        for (Hospital hospital : hospitals) {
            HospitalDTO hospitalDTO = new HospitalDTO();
            hospitalDTO.setId(hospital.getId());
            hospitalDTO.setTotalCases(hospital.getTotalCases());
            hospitalDTO.setTotalDeaths(hospital.getTotalDeaths());
            hospitalDTO.setTotalRecoveries(hospital.getTotalRecoveries());
            hospitalDTO.setDtUpdateTotal(hospital.getDtUpdate());
            hospitalDTO.setCityName(hospital.getCity().getName());
//            List<DailyHospital> dailyHospitals = dailyHospitalRepository.get
//            dtos.add()
        }
        return null;
    }

    public List<DailyHospitalToCityDTO> getDailyHospitalsByCity() {
        return null;
    }

}
