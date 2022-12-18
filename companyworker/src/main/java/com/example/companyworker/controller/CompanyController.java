package com.example.companyworker.controller;

import com.example.companyworker.model.CompanyModel;
import com.example.companyworker.repository.CompanyRepository;
import com.example.companyworker.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/create")
    public String addCompany(@RequestBody CompanyModel companyModel) {
        boolean result = companyService.createCompany(companyModel);
        if (result == true) {
            return "Company created successfully";
        }else {
            return "Company couldn't created";
        }
    }

    @DeleteMapping("/delete")
    public boolean deleteCompany(@RequestParam long id) {
        try {
            return companyService.deleteCompany(id);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/get")
    public CompanyModel getCompanyById(@RequestParam long id) {
        try {
            return companyService.getCompanyById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
