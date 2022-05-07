package org.ginko.covidstat.controller;

import org.ginko.covidstat.dto.CategoryDTO;
import org.ginko.covidstat.model.Category;
import org.ginko.covidstat.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/get/city/{id}")
    public List<CategoryDTO> getCategoryByCity(@PathVariable Long id) {
        return categoryService.getCategoryByCity(id);
    }

    @GetMapping("/get/hospital/{id}")
    public List<CategoryDTO> getCategoryByHospital(@PathVariable Long id) {
        return categoryService.getCategoryByHospital(id);
    }

}
