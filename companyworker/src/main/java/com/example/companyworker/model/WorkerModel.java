package com.example.companyworker.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Workers")
public class WorkerModel extends BaseModel{

    @Column
    private int age;

    @Column
    private int salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_model_id", nullable = false)
    private CompanyModel company;

}
