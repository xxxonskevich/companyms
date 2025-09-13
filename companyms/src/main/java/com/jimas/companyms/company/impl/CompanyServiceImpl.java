package com.jimas.companyms.company.impl;


import com.jimas.companyms.company.Company;
import com.jimas.companyms.company.CompanyRepository;
import com.jimas.companyms.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }


    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            companyRepository.save(company);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }


}
