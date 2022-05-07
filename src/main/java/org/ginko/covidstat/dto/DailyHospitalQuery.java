package org.ginko.covidstat.dto;

import java.time.LocalDateTime;

public interface DailyHospitalQuery {
    Long getCases();
    Long getDeaths();
    Long getRecoveries();
    LocalDateTime getDateTime();
}
