package org.ginko.covidstat.service;

import org.ginko.covidstat.dto.DailyHospitalToCityDTO;
import org.ginko.covidstat.dto.DailyHospitalToHospitalDTO;
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

    public HospitalService(HospitalRepository hospitalRepository, CityRepository cityRepository, DailyHospitalRepository dailyHospitalRepository, DailyHospitalRepository dailyHospitalRepository1) {
        this.hospitalRepository = hospitalRepository;
        this.cityRepository = cityRepository;
        this.dailyHospitalRepository = dailyHospitalRepository1;
    }

    public List<HospitalDTO> getHospitalsByCityId(Long cityId) {
        List<Hospital> hospitals = hospitalRepository.findHospitalsByCity(cityRepository.getById(cityId));
        List<HospitalDTO> dtos = new ArrayList<>();
        for (Hospital hospital : hospitals) {
            System.out.println(hospital.toString());
            HospitalDTO hospitalDTO = new HospitalDTO();
            hospitalDTO.setId(hospital.getId());
            hospitalDTO.setTotalCases(hospital.getTotalCases());
            hospitalDTO.setTotalDeaths(hospital.getTotalDeaths());
            hospitalDTO.setTotalRecoveries(hospital.getTotalRecoveries());
            hospitalDTO.setDtUpdateTotal(hospital.getDtUpdate());
            hospitalDTO.setCityName(hospital.getCity().getName());
            List<DailyHospital> dailyHospitals = dailyHospitalRepository.getDailyHospitalsToHospital();
            List<DailyHospitalToHospitalDTO> dailyHospitalToHospitalDTOS = new ArrayList<>();
            for (DailyHospital dailyHospital : dailyHospitals) {
                DailyHospitalToHospitalDTO dailyHospitalToHospitalDTO = new DailyHospitalToHospitalDTO();
                dailyHospitalToHospitalDTO.setCases(dailyHospital.getNewCases());
                dailyHospitalToHospitalDTO.setDeaths(dailyHospital.getNewDeaths());
                dailyHospitalToHospitalDTO.setRecoveries(dailyHospital.getNewRecoveries());
                dailyHospitalToHospitalDTO.setDateTime(dailyHospital.getDtUpdate());
                dailyHospitalToHospitalDTOS.add(dailyHospitalToHospitalDTO);
            }
            hospitalDTO.setDailyHospitalToHospitalDTO(dailyHospitalToHospitalDTOS);
            dtos.add(hospitalDTO);
        }
        return dtos;
    }

    public List<DailyHospitalToCityDTO> getDailyHospitalsByCity() {
        return null;
    }

}
