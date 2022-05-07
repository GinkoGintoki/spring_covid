package org.ginko.covidstat.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class HospitalDTO {

    private Long id;

    private String name;

    private String cityName;

    private Long totalCases;

    private Long totalDeaths;

    private Long totalRecoveries;

    private LocalDateTime dtUpdateTotal;

    private List<DailyHospitalToHospitalDTO> dailyHospitalToHospitalDTO;

    private CategoryDTO categoryDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Long totalCases) {
        this.totalCases = totalCases;
    }

    public Long getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Long totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Long getTotalRecoveries() {
        return totalRecoveries;
    }

    public void setTotalRecoveries(Long totalRecoveries) {
        this.totalRecoveries = totalRecoveries;
    }

    public LocalDateTime getDtUpdateTotal() {
        return dtUpdateTotal;
    }

    public void setDtUpdateTotal(LocalDateTime dtUpdateTotal) {
        this.dtUpdateTotal = dtUpdateTotal;
    }

    public List<DailyHospitalToHospitalDTO> getDailyHospitalToHospitalDTO() {
        return dailyHospitalToHospitalDTO;
    }

    public void setDailyHospitalToHospitalDTO(List<DailyHospitalToHospitalDTO> dailyHospitalToHospitalDTO) {
        this.dailyHospitalToHospitalDTO = dailyHospitalToHospitalDTO;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
