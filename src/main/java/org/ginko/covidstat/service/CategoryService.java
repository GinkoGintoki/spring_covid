package org.ginko.covidstat.service;

import org.ginko.covidstat.dto.CategoryDTO;
import org.ginko.covidstat.dto.DailyCategoryQuery;
import org.ginko.covidstat.model.Category;
import org.ginko.covidstat.repository.CategoryRepository;
import org.ginko.covidstat.repository.DailyCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private DailyCategoryRepository dailyCategoryRepository;

    public CategoryService(CategoryRepository categoryRepository, DailyCategoryRepository dailyCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.dailyCategoryRepository = dailyCategoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<CategoryDTO> getCategoryByCity(Long id) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<DailyCategoryQuery> dailyCategoryQueries = dailyCategoryRepository.getDailyCategoryByCity(id);
        fromDailyCategoryQueryToCategoryDTO(categoryDTOS, dailyCategoryQueries);

        return categoryDTOS;
    }

    public List<CategoryDTO> getCategoryByHospital(Long id) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<DailyCategoryQuery> dailyCategoryQueries = dailyCategoryRepository.getDailyCategoryByHospital(id);
        fromDailyCategoryQueryToCategoryDTO(categoryDTOS, dailyCategoryQueries);

        return categoryDTOS;
    }

    private void fromDailyCategoryQueryToCategoryDTO(List<CategoryDTO> categoryDTOS, List<DailyCategoryQuery> dailyCategoryQueries) {
        for (DailyCategoryQuery dailyCategoryQuery : dailyCategoryQueries) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setTotalCases(dailyCategoryQuery.getNewCases());
            categoryDTO.setTotalDeaths(dailyCategoryQuery.getNewDeaths());
            categoryDTO.setTotalRecoveries(dailyCategoryQuery.getNewRecoveries());
            categoryDTO.setCategory(categoryRepository.findById(dailyCategoryQuery.getCategoryId()).get());
            categoryDTO.setDtUpdate(dailyCategoryQuery.getDateTime());
            categoryDTOS.add(categoryDTO);
        }
    }
}
