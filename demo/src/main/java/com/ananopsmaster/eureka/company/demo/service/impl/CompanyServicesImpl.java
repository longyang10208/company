package com.ananopsmaster.eureka.company.demo.service.impl;

import com.ananopsmaster.eureka.company.demo.mapper.CompanyMapper;
import com.ananopsmaster.eureka.company.demo.model.Company;
import com.ananopsmaster.eureka.company.demo.service.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServicesImpl implements CompanyServices {
    @Autowired
    private CompanyMapper companyMapper;

    @Transactional
    @Override
    public List<Company> getCompanyList() {
        return companyMapper.getCompanyList();
    }

    @Transactional
    @Override
    public Company getCompanyById(long companyId) {
        return companyMapper.selectByPrimaryKey(companyId);
    }

    @Transactional
    @Override
    public boolean addCompany(Company company) {
        if(company.getId()!=null){
            try{
                int effectedNum = companyMapper.insert((company));
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("添加失败！");
                }
            } catch (Exception e){
                throw new RuntimeException("添加失败:"+e.toString());
            }
        } else {
            throw new RuntimeException("公司id不能为空");
        }
    }

    @Transactional
    @Override
    public boolean addCompanySelective(Company company) {
        //System.out.println(company.getId());
        //if(company.getId()!=null&&"".equals(company.getId())){
        if(company.getId()!=null){
            try{
                int effectedNum = companyMapper.insertSelective(company);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("添加失败！");
                }
            } catch (Exception e){
                throw new RuntimeException("添加失败:"+e.toString());
            }
        } else {
            throw new RuntimeException("公司id不能为空");
        }
    }

    @Transactional
    @Override
    public boolean deleteCompany(long companyId) {
        if(companyId>0){
            try{
                int effectedNum = companyMapper.deleteByPrimaryKey(companyId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除失败");
                }
            } catch (Exception e){
                throw new RuntimeException("删除失败:"+e.toString());
            }
        } else {
            throw new RuntimeException("公司id不存在");
        }
    }

    @Transactional
    @Override
    public boolean modifyCompany(Company company) {
        //System.out.println(company.getId());
        if (company.getId() != null && company.getId() > 0) {
            try {
                int effectedNum = companyMapper.updateByPrimaryKey(company);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("修改失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("公司id不存在");
        }
    }

    @Transactional
    @Override
    public boolean modifyCompanySelective(Company company) {
        if (company.getId() != null && company.getId() > 0) {
            try {
                int effectedNum = companyMapper.updateByPrimaryKeySelective(company);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("修改失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("公司id不存在");
        }
    }
}
