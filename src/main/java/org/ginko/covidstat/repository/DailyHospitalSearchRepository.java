package org.ginko.covidstat.repository;

import org.ginko.covidstat.dto.DailyHospitalToCityDTO;
import org.ginko.covidstat.dto.DailyHospitalToHospitalDTO;
import org.ginko.covidstat.model.DailyHospital;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyHospitalSearchRepository extends org.springframework.data.repository.Repository<DailyHospital, Long> {
//    List<DailyHospitalToCityDTO> getDailyHospitalsToCity(Long cityId);
//
//    List<DailyHospitalToHospitalDTO> getDailyHospitalsToHospital(Long hospitalId);
}
