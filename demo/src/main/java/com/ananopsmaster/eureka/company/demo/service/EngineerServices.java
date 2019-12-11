package com.ananopsmaster.eureka.company.demo.service;

import com.ananopsmaster.eureka.company.demo.model.Engineer;

import java.util.List;

public interface EngineerServices {
    List<Engineer> getEngineerList();
    Engineer getEngineerById(long engineerId);

    boolean addEngineer(Engineer engineer);
    boolean addEngineerSelective(Engineer engineer);

    boolean deleteEngineer(long engineerId);

    boolean modifyEngineer(Engineer engineer);
    boolean modifyEngineerSelective(Engineer engineer);

    boolean uploadFileByPrimaryKeySelective(Long id,String photo);
}
