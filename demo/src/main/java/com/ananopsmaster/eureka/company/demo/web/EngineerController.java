package com.ananopsmaster.eureka.company.demo.web;

import com.ananopsmaster.eureka.company.demo.model.Engineer;
import com.ananopsmaster.eureka.company.demo.service.EngineerServices;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ananopsmaster.eureka.company.demo.util.RandomUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/company/engineer")
@Api(tags = "工程师相关接口")
public class EngineerController {
    @Autowired
    private EngineerServices engineerServices;

    //添加工程师信息
    @ApiOperation("添加工程师信息")
    @RequestMapping(value = "/addEngineer",method = RequestMethod.POST)
    private Map<String,Object> addEngineer(@RequestBody Engineer engineer)
            throws IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",engineerServices.addEngineerSelective(engineer));
        return modelMap;
    }

    //修改工程师信息
    @ApiOperation("修改工程师信息")
    @RequestMapping (value = "/modifyEngineer",method = RequestMethod.POST)
    private Map<String,Object> modityEngineer(@RequestBody Engineer engineer)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",engineerServices.modifyEngineerSelective(engineer));
        return modelMap;
    }

    //通过工程师id查询服务商信息
    @ApiOperation("通过工程师id查询工程师信息")
    @RequestMapping (value = "/getEngineerById",method = RequestMethod.GET)
    private Map<String,Object> getEngineerById(long engineerId)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",engineerServices.getEngineerById(engineerId));
        return modelMap;
    }

    //查询所有的工程师信息
    @ApiOperation("查询所有的工程师信息")
    @RequestMapping(value = "getAllEngineer",method = RequestMethod.GET)
    private Map<String,Object> getAllEngineer(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Engineer> listEngineer =new ArrayList<>();
        listEngineer = engineerServices.getEngineerList();
        modelMap.put("companyList",listEngineer);
        return modelMap;
    }

    //删除工程师信息
    @ApiOperation("删除工程师信息")
    @RequestMapping(value = "deleteEngineerById",method = RequestMethod.GET)
    private Map<String, Object> deleteCompanyById(long engineerId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", engineerServices.deleteEngineer(engineerId));
        return modelMap;
    }

    @ApiOperation(value = "上传工程师证书图片信息")
    @PostMapping("/uploadImg")
    @ResponseBody
    public Map<String, Object> uploadImg(@RequestBody MultipartFile file, Long engineerId)
            throws JsonParseException, JsonMappingException, IOException{

        String originFileName = file.getOriginalFilename();
        String fileName = RandomUtils.createRandomString(10) + originFileName;
        File dest = new File("/home/ly/ananops-company/" + fileName);

        Map<String, Object> modelMap = new HashMap<String, Object>();

        if(engineerId == null){
            log.info("工程师id不存在");
        }else{
            log.info(engineerId + "上传工程师证书图片" + file.getOriginalFilename());//日志可加可不加
        }
        modelMap.put("success",engineerServices.uploadFileByPrimaryKeySelective(engineerId,fileName));
        file.transferTo(dest);
        return modelMap;
    }

}

