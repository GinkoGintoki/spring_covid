package org.ginko.covidstat.service;

import org.ginko.covidstat.dto.DailyCategoryDTO;
import org.ginko.covidstat.dto.DailyHospitalFilterDTO;
import org.ginko.covidstat.model.City;
import org.ginko.covidstat.model.DailyCategory;
import org.ginko.covidstat.model.DailyHospital;
import org.ginko.covidstat.model.Hospital;
import org.ginko.covidstat.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class DailyService {

    private final DailyHospitalRepository dailyHospitalRepository;
    private final HospitalRepository hospitalRepository;
    private final CityRepository cityRepository;

    private final CategoryRepository categoryRepository;
    private final DailyCategoryRepository dailyCategoryRepository;

    public DailyService(DailyHospitalRepository dailyHospitalRepository, HospitalRepository hospitalRepository, CityRepository cityRepository, CategoryRepository categoryRepository, DailyCategoryRepository dailyCategoryRepository) {
        this.dailyHospitalRepository = dailyHospitalRepository;
        this.hospitalRepository = hospitalRepository;
        this.cityRepository = cityRepository;
        this.categoryRepository = categoryRepository;
        this.dailyCategoryRepository = dailyCategoryRepository;
    }

    @Transactional
    public Map<String, Object> updateDailyHospital(DailyHospitalFilterDTO dto) {
        DailyHospital dailyHospital = new DailyHospital();
        dailyHospital.setNewCases(dto.getNewCases() != null ? dto.getNewCases() : 0);
        dailyHospital.setNewDeaths(dto.getNewDeaths() != null ? dto.getNewDeaths() : 0);
        dailyHospital.setNewRecoveries(dto.getNewRecoveries() != null ? dto.getNewRecoveries() : 0);
        dailyHospital.setHospital(hospitalRepository.findById(dto.getHospitalId()).orElse(null));
        Hospital hospital = dailyHospital.getHospital();
        hospitalRepository.updateHospital(hospital.getId(), Objects.requireNonNullElse(hospital.getTotalCases(), 0L) + dailyHospital.getNewCases(),
                Objects.requireNonNullElse(hospital.getTotalDeaths(), 0L) + dailyHospital.getNewDeaths(),
                Objects.requireNonNullElse(hospital.getTotalRecoveries(), 0L) + dailyHospital.getNewRecoveries(), LocalDateTime.now());
        City city = hospital.getCity();
        cityRepository.updateCity(city.getId(), Objects.requireNonNullElse(city.getTotalCases(), 0L) + dailyHospital.getNewCases(),
                Objects.requireNonNullElse(city.getTotalDeaths(), 0L) + dailyHospital.getNewDeaths(),
                Objects.requireNonNullElse(city.getTotalRecoveries(), 0L) + dailyHospital.getNewRecoveries(), LocalDateTime.now());
        dailyHospitalRepository.save(dailyHospital);

        return new HashMap<>() {
            {
                put("status", true);
            }
        };
    }

    @Transactional
    public Map<String, Object> updateDailyCategories(DailyCategoryDTO dailyCategoryDTO) {
        DailyCategory dailyCategory = new DailyCategory();
        dailyCategory.setCategory(categoryRepository.getById(dailyCategoryDTO.getCategoryId()));
        dailyCategory.setHospital(hospitalRepository.getById(dailyCategoryDTO.getHospitalId()));
        dailyCategory.setNewCases(dailyCategoryDTO.getNewCases() != null ? dailyCategoryDTO.getNewCases() : 0);
        dailyCategory.setNewDeaths(dailyCategoryDTO.getNewDeaths() != null ? dailyCategoryDTO.getNewDeaths() : 0);
        dailyCategory.setNewRecoveries(dailyCategoryDTO.getNewRecoveries() != null ? dailyCategoryDTO.getNewRecoveries() : 0);
        dailyCategory.setDtUpdate(LocalDateTime.now());
        dailyCategoryRepository.save(dailyCategory);
        return new HashMap<>() {{
            put("status", true);
        }};
    }

}
