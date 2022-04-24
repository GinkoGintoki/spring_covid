package org.ginko.covidstat.dto;

public class DailyHospitalFilterDTO {

    private Long newCases;

    private Long newDeaths;

    private Long newRecoveries;

    private Long hospitalId;

    public Long getNewCases() {
        return newCases;
    }

    public void setNewCases(Long newCases) {
        this.newCases = newCases;
    }

    public Long getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Long newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Long getNewRecoveries() {
        return newRecoveries;
    }

    public void setNewRecoveries(Long newRecoveries) {
        this.newRecoveries = newRecoveries;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }
}
