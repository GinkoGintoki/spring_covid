package org.ginko.covidstat.model.base;

import lombok.Data;
import lombok.ToString;

import javax.persistence.MappedSuperclass;

@Data
@ToString(callSuper = true)
@MappedSuperclass
public class NewStatModel extends BaseModel {

    private Long newCases;

    private Long newDeaths;

    private Long newRecoveries;

    public Long getNewCases() {
        return newCases;
    }

    public void setNewCases(Long newCases) {
        this.newCases = newCases;
    }

    public Long getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Long newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Long getNewRecoveries() {
        return newRecoveries;
    }

    public void setNewRecoveries(Long newRecoveries) {
        this.newRecoveries = newRecoveries;
    }
}
