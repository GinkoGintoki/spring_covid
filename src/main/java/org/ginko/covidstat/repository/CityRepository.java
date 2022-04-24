package org.ginko.covidstat.repository;

import org.ginko.covidstat.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Modifying
    @Query("update City set totalCases = :cases, totalDeaths=:deaths, totalRecoveries=:recoveries, dtUpdate =:dateTime where id=:id")
    void updateCity(Long id, Long cases, Long deaths, Long recoveries, LocalDateTime dateTime);
}
