package org.ginko.covidstat.model;

import lombok.Data;
import org.ginko.covidstat.model.base.NewStatModel;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "daily_hospital")
public class DailyHospital extends NewStatModel {

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    private LocalDateTime dtUpdate;

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
