package org.ginko.covidstat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.ginko.covidstat.model.base.NewStatModel;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "daily_categoires")
public class DailyCategory extends NewStatModel {

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    private LocalDateTime dtUpdate;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }
}
