package com.ananopsmaster.eureka.company.demo.mapper;

import com.ananopsmaster.eureka.company.demo.model.Engineer;

import java.util.List;

public interface EngineerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Engineer record);

    int insertSelective(Engineer record);

    Engineer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Engineer record);

    int updateByPrimaryKey(Engineer record);

    List<Engineer> getEngineerList();

    int uploadFileByPrimaryKeySelective(Long id,String photo);
}