package org.ginko.covidstat.dto;

public class DailyCategoryDTO {

    private Long categoryId;

    private Long hospitalId;

    private Long newCases;

    private Long newDeaths;

    private Long newRecoveries;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

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
}
