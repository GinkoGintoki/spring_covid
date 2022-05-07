package org.ginko.covidstat.controller;

import org.ginko.covidstat.dto.DailyCategoryDTO;
import org.ginko.covidstat.dto.DailyHospitalFilterDTO;
import org.ginko.covidstat.service.DailyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/daily")
public class DailyController {

    private final DailyService dailyService;

    public DailyController(DailyService dailyService) {
        this.dailyService = dailyService;
    }

    @PostMapping(value = "/hospitals")
    public Map<String, Object> updateDailyHospitals(@RequestBody DailyHospitalFilterDTO hospitalDTOS) {
        return dailyService.updateDailyHospital(hospitalDTOS);
    }

    @PostMapping(value = "/category")
    public Map<String, Object> updateDailyCategory(@RequestBody DailyCategoryDTO dailyCategory) {
        return dailyService.updateDailyCategories(dailyCategory);
    }
}
