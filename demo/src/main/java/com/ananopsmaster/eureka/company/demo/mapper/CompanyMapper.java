package com.ananopsmaster.eureka.company.demo.mapper;

import com.ananopsmaster.eureka.company.demo.model.Company;

import java.util.List;

public interface CompanyMapper {
    List<Company> getCompanyList();

    int deleteByPrimaryKey(Long id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}