package com.rockonengin.model.protocol.response;

import com.rockonengin.model.entity.Company;

/**
 * Created by Administrator on 2018/3/18.
 */
public class GetCompanyResponse extends BaseResponse {
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
