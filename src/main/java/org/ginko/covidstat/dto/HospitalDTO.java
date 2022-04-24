package org.ginko.covidstat.dto;

import org.ginko.covidstat.model.DailyCategory;
import org.ginko.covidstat.model.DailyHospital;

import java.time.LocalDateTime;
import java.util.List;

public class HospitalDTO {

    private Long id;

    private String name;

    private String cityName;

    private Long totalCase;

    private Long totalDeaths;

    private Long totalRecoveries;

    private LocalDateTime dtUpdate;
}
