package org.ginko.covidstat.dto;

import java.time.LocalDateTime;

public class DailyCityDTO {

    private Long cases;

    private Long deaths;

    private Long recoveries;

    private LocalDateTime dtUpdate;

    public Long getCases() {
        return cases;
    }

    public void setCases(Long cases) {
        this.cases = cases;
    }

    public Long getDeaths() {
        return deaths;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    public Long getRecoveries() {
        return recoveries;
    }

    public void setRecoveries(Long recoveries) {
        this.recoveries = recoveries;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }
}
