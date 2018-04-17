package com.rockonengin.service;

import com.rockonengin.model.entity.Company;

/**
 * Created by tangfan on 2018/2/13.
 */
public interface CompanyService {

    Company getCompany(Integer id);

    boolean update(Company company);
}
