package org.ginko.covidstat.service;

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

    public HospitalDTO getHospitalByCityId(Long cityId, Long hospitalId) {
        Hospital hospital = hospitalRepository.findHospitalByCityIdAndId(cityId, hospitalId);

        HospitalDTO hospitalDTO = new HospitalDTO();
        hospitalDTO.setId(hospital.getId());
        hospitalDTO.setTotalCases(hospital.getTotalCases());
        hospitalDTO.setTotalDeaths(hospital.getTotalDeaths());
        hospitalDTO.setTotalRecoveries(hospital.getTotalRecoveries());
        hospitalDTO.setDtUpdateTotal(hospital.getDtUpdate());
        hospitalDTO.setCityName(hospital.getCity().getName());
        List<DailyHospital> dailyHospitals = dailyHospitalRepository.getDailyHospitalsToHospital(hospital.getId());
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

        return hospitalDTO;
    }

    public List<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

    public DailyHospital getDailyHospital(Long id) {
        return dailyHospitalRepository.findTopByIdOrderByIdDesc(id);
    }

    public List<Hospital> getHospitalsByCityId(Long id) {
        return hospitalRepository.findHospitalsByCityId(id);
    }
}
