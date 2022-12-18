package com.example.companyworker.service;

import com.example.companyworker.model.CompanyModel;
import com.example.companyworker.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public boolean createCompany(CompanyModel companyModel) {
        try {
            companyModel.setCreatedDate(new Date());
            companyRepository.save(companyModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCompany(long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public CompanyModel getCompanyById(long id) {
        return companyRepository.getById(id);
    }
}
