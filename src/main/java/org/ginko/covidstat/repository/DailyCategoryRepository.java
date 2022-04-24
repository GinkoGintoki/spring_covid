package org.ginko.covidstat.repository;

import org.ginko.covidstat.model.DailyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyCategoryRepository extends JpaRepository<DailyCategory, Long> {
}
