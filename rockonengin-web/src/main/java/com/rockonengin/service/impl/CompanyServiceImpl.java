package com.rockonengin.service.impl;

/**
 * Created by tangfan on 2018/2/13.
 */

import com.rockonengin.dao.rockonengin.CompanyMapper;
import com.rockonengin.model.entity.Company;
import com.rockonengin.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyMapper companyMapper;

    public Company getCompany(Integer id) {
        return companyMapper.selectById(id);
    }

    public boolean update(Company company){

        return companyMapper.update(company) == 1;
    }
}
