package com.rockonengin.controller;

import com.rockonengin.common.exception.ResultCode;
import com.rockonengin.common.utils.CommonUtil;
import com.rockonengin.model.entity.Company;
import com.rockonengin.model.protocol.request.EditCompanyRequest;
import com.rockonengin.model.protocol.response.EditCompanyResponse;
import com.rockonengin.model.protocol.response.GetCompanyResponse;
import com.rockonengin.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tangfan on 2018/3/18.
 */
@RestController
@RequestMapping("/rockonenginService/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/info")
    public GetCompanyResponse getCompany(Integer id) {
        GetCompanyResponse response = new GetCompanyResponse();
        Company company = companyService.getCompany(id);
        if (CommonUtil.isEmpty(company)) {
            response.setResult(ResultCode.RESULT_NOT_FOUND_RECORD);
            response.setMessage("未找到满足条件的记录");
            return response;
        }
        response.setResult(ResultCode.RESULT_SUCCESS);
        response.setMessage("获取数据成功");
        response.setCompany(company);
        return response;
    }


    @PostMapping("/edit")
    public EditCompanyResponse editCompany(@RequestBody EditCompanyRequest request) {
        EditCompanyResponse response = new EditCompanyResponse();
        if (request == null) {
            response.setResult(ResultCode.RESULT_PARAMS_NOT_CORRECT);
            response.setMessage("参数不正确");
            return response;
        }
        Company company = new Company();
        BeanUtils.copyProperties(request, company);
        if (!companyService.update(company)) {
            response.setResult(ResultCode.RESULT_BUSINESS_FAIL);
            response.setMessage("更新失败！");
            return response;
        }

        response.setResult(ResultCode.RESULT_SUCCESS);
        response.setMessage("更新成功");
        return response;

    }
}
