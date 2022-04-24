package org.ginko.covidstat.repository;

import org.ginko.covidstat.dto.DailyHospitalToCityDTO;
import org.ginko.covidstat.dto.DailyHospitalToHospitalDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class DailyHospitalSearchImpl implements DailyHospitalSearchRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<DailyHospitalToCityDTO> getDailyHospitalsToCity(Long cityId) {
        Query query = em.createNativeQuery("" +
                "select sum(dh.new_cases), sum(dh.new_deaths), sum(dh.new_recoveries), c.id, dh.dt_update\n" +
                "from daily_hospital dh\n" +
                "inner join hospitals h on dh.hospital_id = h.id\n" +
                "inner join cities c on c.id = h.city_id\n" +
                "where dh.dt_update <= now() and extract(days from now() - dh.dt_update) >= 20 and c.id = 1\n" +
                "group by date_trunc('day', dh.dt_update), c.id");
        return null;
    }

    @Override
    public List<DailyHospitalToHospitalDTO> getDailyHospitalsToHospital(Long hospitalId) {
        return null;
    }
}
