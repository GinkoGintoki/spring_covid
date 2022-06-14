package org.ginko.covidstat.service;

import org.ginko.covidstat.dto.HospitalDTO;
import org.ginko.covidstat.model.Hospital;
import org.ginko.covidstat.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
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

        return hospitalDTO;
    }

    public List<Hospital> getHospitalsByCityId(Long id) {
        return hospitalRepository.findHospitalsByCityId(id);
    }
}
