package org.ginko.covidstat.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalServiceTest {

    @Autowired
    private HospitalService hospitalService;

    @Test
    void getHospitalsByCityId() {
//        hospitalService.getHospitalByCityId(1L);
    }

    @Test
    void getDailyHospitalsByCity() {
    }
}