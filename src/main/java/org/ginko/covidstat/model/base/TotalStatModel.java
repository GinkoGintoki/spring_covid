package org.ginko.covidstat.model.base;

import lombok.Data;
import lombok.ToString;

import javax.persistence.MappedSuperclass;

@Data
@ToString(callSuper = true)
@MappedSuperclass
public class TotalStatModel extends BaseModel {

    private Long totalCases;

    private Long totalDeaths;

    private Long totalRecoveries;

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
}
