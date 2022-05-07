package org.ginko.covidstat.dto;

import java.time.LocalDateTime;

public interface DailyCategoryQuery {
    Long getNewCases();
    Long getNewRecoveries();
    Long getNewDeaths();
    LocalDateTime getDateTime();
    Long getCategoryId();
}
