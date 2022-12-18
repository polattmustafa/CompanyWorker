package com.example.companyworker.service;

import com.example.companyworker.model.CompanyModel;
import com.example.companyworker.model.WorkerModel;
import com.example.companyworker.repository.CompanyRepository;
import com.example.companyworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    CompanyService companyService;

    public boolean createWorker(WorkerModel workerModel, long companyId) {
        try {
            CompanyModel company = companyService.getCompanyById(companyId);
            workerModel.setCreatedDate(new Date());
            workerModel.setCompany(company);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public WorkerModel getWorkerById(long id) {
        Optional<WorkerModel> worker = workerRepository.findById(id);

        if (worker.isPresent()) {
            return worker.get();
        }
        return null;
    }

    public boolean deleteWorker(long id) {
        try {
            workerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public WorkerModel updateWorker(WorkerModel workerModel, long companyId) {
        Optional<WorkerModel> resultWorker = workerRepository.findById(companyId);
        if (resultWorker.isPresent()) {
            resultWorker.get().setAge(workerModel.getAge());
            resultWorker.get().setId(workerModel.getId());
            resultWorker.get().setSalary(workerModel.getSalary());
            resultWorker.get().setMail(workerModel.getMail());
            resultWorker.get().setName(workerModel.getName());
            resultWorker.get().setPhone(workerModel.getPhone());
            resultWorker.get().setUpdatedDate(new Date());
            return workerRepository.save(resultWorker.get());
        }
        return null;
    }

    public List<WorkerModel> getWorkers() {
        return workerRepository.findAll();
    }
}
