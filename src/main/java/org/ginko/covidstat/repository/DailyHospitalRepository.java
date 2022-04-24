package org.ginko.covidstat.repository;

import org.ginko.covidstat.dto.DailyHospitalToCityDTO;
import org.ginko.covidstat.dto.DailyHospitalToHospitalDTO;
import org.ginko.covidstat.model.City;
import org.ginko.covidstat.model.DailyHospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyHospitalRepository extends JpaRepository<DailyHospital, Long> {

    @Query(value = "select *\n" +
            "from daily_hospital dh\n" +
            "inner join hospitals h on dh.hospital_id = h.id\n" +
            "inner join cities c on c.id = h.city_id\n" +
            "where dh.dt_update <= now() and extract(days from now() - dh.dt_update) >= 30 and c.id = 1\n" +
            "group by date_trunc('day', dh.dt_update), c.id;", nativeQuery = true)
    List<DailyHospitalToCityDTO> getDailyHospitalsToCity();

    List<DailyHospitalToHospitalDTO> getDailyHospitalsToHospital();
}
