package com.ananopsmaster.eureka.company.demo.service.impl;

import com.ananopsmaster.eureka.company.demo.mapper.EngineerMapper;
import com.ananopsmaster.eureka.company.demo.model.Engineer;
import com.ananopsmaster.eureka.company.demo.service.EngineerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
@Service
public class EngineerServicesImpl implements EngineerServices {
    @Autowired
    private EngineerMapper engineerMapper;

    @Transactional
    @Override
    public List<Engineer> getEngineerList() {
        return engineerMapper.getEngineerList();
    }

    @Transactional
    @Override
    public Engineer getEngineerById(long engineerId) {
        return engineerMapper.selectByPrimaryKey(engineerId);
    }

    @Transactional
    @Override
    public boolean addEngineer(Engineer engineer) {
        if(engineer.getId()!=null){
            try{
                int effectedNum = engineerMapper.insert((engineer));
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("添加失败！");
                }
            } catch (Exception e){
                throw new RuntimeException("添加失败:"+e.toString());
            }
        } else {
            throw new RuntimeException("工程师id不能为空");
        }
    }

    @Transactional
    @Override
    public boolean addEngineerSelective(Engineer engineer) {
        if(engineer.getId()!=null){
            try{
                int effectedNum = engineerMapper.insertSelective(engineer);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("添加失败！");
                }
            } catch (Exception e){
                throw new RuntimeException("添加失败:"+e.toString());
            }
        } else {
            throw new RuntimeException("工程师id不能为空");
        }
    }

    @Transactional
    @Override
    public boolean deleteEngineer(long engineerId) {
        if(engineerId>0){
            try{
                int effectedNum = engineerMapper.deleteByPrimaryKey(engineerId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除失败");
                }
            } catch (Exception e){
                throw new RuntimeException("删除失败:"+e.toString());
            }
        } else {
            throw new RuntimeException("工程师id不存在");
        }
    }

    @Transactional
    @Override
    public boolean modifyEngineer(Engineer engineer) {
        if (engineer.getId() != null && engineer.getId() > 0) {
            try {
                int effectedNum = engineerMapper.updateByPrimaryKey(engineer);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("修改失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("工程师id不存在");
        }
    }

    @Transactional
    @Override
    public boolean modifyEngineerSelective(Engineer engineer) {
        if (engineer.getId() != null && engineer.getId() > 0) {
            try {
                int effectedNum = engineerMapper.updateByPrimaryKeySelective(engineer);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("修改失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("工程师id不存在");
        }
    }

    @Transactional
    @Override
    public boolean uploadFileByPrimaryKeySelective(Long engineerId, String photo) {
        if (engineerId>0) {
            try {
                int effectedNum = engineerMapper.uploadFileByPrimaryKeySelective(engineerId, photo);
                if (effectedNum > 0) {
                    log.info("证书图片url上传成功");
                    return true;
                } else {
                    throw new RuntimeException("图片url上传失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("图片url上传失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("工程师id不存在");
        }
    }
}
