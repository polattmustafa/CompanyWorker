package com.example.companyworker.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Company")
public class CompanyModel extends BaseModel{

    @Column
    private int workerCount;

    @Column
    private String workingField;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company_id")
    private Collection<WorkerModel> workers;

}
