package org.ginko.covidstat.repository;

import org.ginko.covidstat.dto.DailyCategoryQuery;
import org.ginko.covidstat.model.DailyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyCategoryRepository extends JpaRepository<DailyCategory, Long> {

    @Query(value = "select sum(dc.new_cases) as newCases, sum(dc.new_deaths) as newDeaths, sum(dc.new_recoveries) as newRecoveries, max(dc.dt_update) as dateTime, dc.category_id as categoryId\n" +
            "from daily_categoires dc\n" +
            "inner join hospitals h on h.id = dc.hospital_id\n" +
            "where h.city_id = ?1\n" +
            "group by category_id", nativeQuery = true)
    List<DailyCategoryQuery> getDailyCategoryByCity(Long id);

    @Query(value = "select sum(dc.new_cases) as newCases, sum(dc.new_deaths) as newDeaths, sum(dc.new_recoveries) as newRecoveries, max(dc.dt_update) as dateTime, dc.category_id as categoryId\n" +
            "from daily_categoires dc\n" +
            "where dc.hospital_id = ?1\n"+
            "group by category_id", nativeQuery = true)
    List<DailyCategoryQuery> getDailyCategoryByHospital(Long id);
}
