package com.rockonengin.dao.rockonengin;


import com.rockonengin.model.entity.Company;

public interface CompanyMapper {
    Company selectById(Integer id);

    Integer update(Company company);

}