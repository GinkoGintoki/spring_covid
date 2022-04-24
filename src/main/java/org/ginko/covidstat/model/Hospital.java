package org.ginko.covidstat.model;

import lombok.Data;
import org.ginko.covidstat.model.base.TotalStatModel;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "hospitals")
@Data
public class Hospital extends TotalStatModel {

    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "hospital")
    private List<DailyHospital> dailyHospitals;

    @OneToMany(mappedBy = "hospital")
    private List<DailyCategory> dailyCategoryList;

    private LocalDateTime dtUpdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<DailyHospital> getDailyHospitals() {
        return dailyHospitals;
    }

    public void setDailyHospitals(List<DailyHospital> dailyHospitals) {
        this.dailyHospitals = dailyHospitals;
    }

    public List<DailyCategory> getDailyCategoryList() {
        return dailyCategoryList;
    }

    public void setDailyCategoryList(List<DailyCategory> dailyCategoryList) {
        this.dailyCategoryList = dailyCategoryList;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }
}
