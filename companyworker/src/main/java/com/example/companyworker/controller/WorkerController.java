package com.example.companyworker.controller;

import com.example.companyworker.model.WorkerModel;
import com.example.companyworker.repository.WorkerRepository;
import com.example.companyworker.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @GetMapping("/getall")
    public ResponseEntity<List<WorkerModel>> getAllWorkers() {
        List<WorkerModel> workers = workerService.getWorkers();
        return ResponseEntity.ok(workers);
    }


    @PutMapping("/update/{company_id}")
    public ResponseEntity<WorkerModel> updateWorker(@RequestBody WorkerModel workerModel, @PathVariable("company_id") long companyId) {
        WorkerModel resultWorker = workerService.updateWorker(workerModel, companyId);
        return ResponseEntity.ok(resultWorker);
    }

    @PostMapping("/create/{company_id}")
    public String createWorker(@RequestBody WorkerModel workerModel, @PathVariable long companyId) {
        try {
            workerService.createWorker(workerModel,companyId);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "worker couldn't created";
        }
    }

    public String deleteWorker(@RequestParam long id) {
        try {
            workerService.deleteWorker(id);
            return "worker deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return "worker couldn't deleted";
        }

    }


}
