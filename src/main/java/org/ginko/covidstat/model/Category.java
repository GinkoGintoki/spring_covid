package org.ginko.covidstat.model;

import lombok.Data;
import org.ginko.covidstat.model.base.BaseModel;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category extends BaseModel {

    private String name;

    @OneToMany(mappedBy = "category")
    private List<DailyCategory> dailyCategoryList;

}