package com.example.sastra.onlyjavaclasses;

public class Company {
    int companyId;
    String companyPhone;
    String companyMobile;
    String companyName;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyMobile() {
        return companyMobile;
    }

    public void setCompanyMobile(String companyMobile) {
        this.companyMobile = companyMobile;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyContactPerson() {
        return companyContactPerson;
    }

    public void setCompanyContactPerson(String companyContactPerson) {
        this.companyContactPerson = companyContactPerson;
    }

    public String getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public Company(String companyPhone, String companyMobile, String companyName, String companyEmail, String companyContactPerson, String companyAdress, String companyDescription) {
        this.companyPhone = companyPhone;
        this.companyMobile = companyMobile;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyContactPerson = companyContactPerson;
        this.companyAdress = companyAdress;
        this.companyDescription = companyDescription;
    }

    public Company(int companyId, String companyPhone, String companyMobile, String companyName, String companyEmail, String companyContactPerson, String companyAdress, String companyDescription) {
        this.companyId = companyId;
        this.companyPhone = companyPhone;
        this.companyMobile = companyMobile;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyContactPerson = companyContactPerson;
        this.companyAdress = companyAdress;
        this.companyDescription = companyDescription;
    }

    String companyEmail;
    String companyContactPerson;
    String companyAdress;
    String companyDescription;


}
