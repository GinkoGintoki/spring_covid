package org.ginko.covidstat.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HospitalDTO {

    private Long id;

    private String name;

    private String cityName;

    private Long totalCases;

    private Long totalDeaths;

    private Long totalRecoveries;

    private LocalDateTime dtUpdateTotal;

    private DailyHospitalToHospitalDTO dailyHospitalToHospitalDTO;

    private CategoryDTO categoryDTO;
}
