package org.ginko.covidstat.controller;

import org.ginko.covidstat.dto.HospitalDTO;
import org.ginko.covidstat.service.HospitalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/get")
    public List<HospitalDTO> getHospitalInfo(@RequestParam("city") Long cityId) {
        return hospitalService.getHospitalsByCityId(cityId);
    }
}
