package org.ginko.covidstat.repository;

import org.ginko.covidstat.model.City;
import org.ginko.covidstat.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Hospital findHospitalByCityIdAndId(Long cityId, Long id);

    List<Hospital> findHospitalsByCityId(Long city_id);

}
