package com.ananopsmaster.eureka.company.demo.web;

import com.ananopsmaster.eureka.company.demo.model.Company;
import com.ananopsmaster.eureka.company.demo.service.CompanyServices;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/company")
@Api(tags = "服务商相关接口")
public class CompanyController {
    @Autowired
    private CompanyServices companyServices;

    @ApiOperation("添加服务商信息")
    //添加服务商信息
   @RequestMapping (value = "/addCompany",method = RequestMethod.POST)
    private Map<String,Object> addCompany(@RequestBody Company company)
           throws IOException {
       Map<String, Object> modelMap = new HashMap<String, Object>();
       modelMap.put("success",companyServices.addCompanySelective(company));
       return modelMap;
   }

    @ApiOperation("修改服务商信息")
    //修改服务商信息
    @RequestMapping (value = "/modifyCompany",method = RequestMethod.POST)
    private Map<String,Object> modityCompany(@RequestBody Company company)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",companyServices.modifyCompanySelective(company));
        return modelMap;
    }

    @ApiOperation("通过服务商id查询服务商信息")
    //通过服务商id查询服务商信息
    @RequestMapping (value = "/getCompanyById",method = RequestMethod.GET)
    private Map<String,Object> getCompanyById(long companyId)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",companyServices.getCompanyById(companyId));
        return modelMap;
    }

    @ApiOperation("查询所有的服务商信息")
    //查询所有的服务商信息
    @RequestMapping(value = "getAllCompany",method = RequestMethod.GET)
    private Map<String,Object> getAllCompany(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Company> listCompany =new ArrayList<>();
        listCompany = companyServices.getCompanyList();
        modelMap.put("companyList",listCompany);
        return modelMap;
    }

    @ApiOperation("删除服务商信息")
    //删除服务商信息
    @RequestMapping(value = "deleteCompanyById",method = RequestMethod.GET)
    private Map<String, Object> deleteCompanyById(long companyId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", companyServices.deleteCompany(companyId));
        return modelMap;
    }


}
