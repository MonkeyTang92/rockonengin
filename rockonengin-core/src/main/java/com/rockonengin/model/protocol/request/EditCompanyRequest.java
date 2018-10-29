package com.rockonengin.model.protocol.request;

/**
 * Created by tangfan on 2018/3/18.
 */
public class EditCompanyRequest {
    private Integer id;

    private String companyName;

    private String companyIntro;

    private String companyCulture;

    private String companyStructurePicPath;

    private String companyAddress;

    private String companyContact;

    private String companyPhone;

    private String companyEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyIntro() {
        return companyIntro;
    }

    public void setCompanyIntro(String companyIntro) {
        this.companyIntro = companyIntro;
    }

    public String getCompanyCulture() {
        return companyCulture;
    }

    public void setCompanyCulture(String companyCulture) {
        this.companyCulture = companyCulture;
    }

    public String getCompanyStructurePicPath() {
        return companyStructurePicPath;
    }

    public void setCompanyStructurePicPath(String companyStructurePicPath) {
        this.companyStructurePicPath = companyStructurePicPath;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }
}
