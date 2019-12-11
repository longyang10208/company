package com.ananopsmaster.eureka.company.demo.service;

import com.ananopsmaster.eureka.company.demo.model.Company;

import java.util.List;

public interface CompanyServices {
    List<Company> getCompanyList();
    Company getCompanyById(long companyId);

    boolean addCompany(Company company);
    boolean addCompanySelective(Company company);

    boolean deleteCompany(long companyId);

    boolean modifyCompany(Company company);
    boolean modifyCompanySelective(Company company);
}
