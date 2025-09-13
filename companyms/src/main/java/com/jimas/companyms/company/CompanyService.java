package com.jimas.companyms.company;

import java.util.List;

public interface CompanyService {
    List<Company> getCompanies();

    boolean updateCompany(Long id, Company company);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);
}
