package org.ginko.covidstat.dto;

import lombok.Data;
import org.ginko.covidstat.model.Category;

import java.time.LocalDateTime;

@Data
public class CategoryDTO {

    private Long totalCases;

    private Long totalDeaths;

    private Long totalRecoveries;

    private LocalDateTime dtUpdate;

    private Category category;

    public Long getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Long totalCases) {
        this.totalCases = totalCases;
    }

    public Long getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Long totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Long getTotalRecoveries() {
        return totalRecoveries;
    }

    public void setTotalRecoveries(Long totalRecoveries) {
        this.totalRecoveries = totalRecoveries;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
