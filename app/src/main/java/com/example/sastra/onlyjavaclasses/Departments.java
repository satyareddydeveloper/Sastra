package com.example.sastra.onlyjavaclasses;

public class Departments {
    int departmentid;
    String departname;

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public Departments(String departname, String manager, String contactperson) {
        this.departname = departname;
        this.manager = manager;
        this.contactperson = contactperson;
    }

    public Departments(int departmentid, String departname, String manager, String contactperson) {
        this.departmentid = departmentid;
        this.departname = departname;
        this.manager = manager;
        this.contactperson = contactperson;
    }

    String manager;
    String contactperson;
}
