package org.ginko.covidstat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.ginko.covidstat.model.DailyHospital;

import java.util.List;

@Data
@Setter
@Getter
public class CityDTO {

    private Long id;

    private String name;

    private Long totalCases;

    private Long totalDeaths;

    private Long totalRecoveries;

    private List<DailyHospitalToCityDTO> dailyCity;

    public List<DailyHospitalToCityDTO> getDailyCity() {
        return dailyCity;
    }

    public void setDailyCity(List<DailyHospitalToCityDTO> dailyCity) {
        this.dailyCity = dailyCity;
    }

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
}
