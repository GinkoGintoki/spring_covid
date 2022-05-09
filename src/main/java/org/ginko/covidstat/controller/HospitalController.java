package org.ginko.covidstat.controller;

import org.ginko.covidstat.dto.HospitalDTO;
import org.ginko.covidstat.model.DailyHospital;
import org.ginko.covidstat.model.Hospital;
import org.ginko.covidstat.service.HospitalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/info/get")
    public HospitalDTO getHospitalInfo(@RequestParam("city") Long cityId, @RequestParam("hospital") Long hospitalId) {
        return hospitalService.getHospitalByCityId(cityId, hospitalId);
    }

    @GetMapping("/getAll")
    public List<Hospital> getHospitals() {
        return hospitalService.getAll();
    }

    @GetMapping("/info/city/get/{id}")
    public List<Hospital> getHospitalsByCity(@PathVariable Long id) {
        return hospitalService.getHospitalsByCityId(id);
    }

    @GetMapping("/daily/get/{id}")
    public DailyHospital getDailyHospital(@PathVariable("id") Long id) {
        return hospitalService.getDailyHospital(id);
    }
}
