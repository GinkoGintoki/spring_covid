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

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id: " + getId() +
                ",name='" + name + '\'' +
                ", city=" + city +
                ", dtUpdate=" + dtUpdate +
                '}';
    }
}
