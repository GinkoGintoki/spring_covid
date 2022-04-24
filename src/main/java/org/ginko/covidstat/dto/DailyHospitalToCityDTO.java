package org.ginko.covidstat.dto;

import java.time.LocalDateTime;

public class DailyHospitalToCityDTO {
    private Long cases;

    private Long deaths;

    private Long recoveries;

    private Long cityId;

    private LocalDateTime dateTime;

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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
