package com.example.companyworker.repository;


import com.example.companyworker.model.WorkerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerModel, Long> {
}
