package com.example.sastra.onlyjavaclasses;

public class Employees {
    int EmpId;
    String EmpName;

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int empId) {
        EmpId = empId;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public String getEmpEmail() {
        return EmpEmail;
    }

    public void setEmpEmail(String empEmail) {
        EmpEmail = empEmail;
    }

    public String getEmpMobile() {
        return EmpMobile;
    }

    public void setEmpMobile(String empMobile) {
        EmpMobile = empMobile;
    }

    public String getEmpDepartment() {
        return EmpDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        EmpDepartment = empDepartment;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Employees(String empName, String empEmail, String empMobile, String empDepartment, String role, String adress, String joiningDate) {
        EmpName = empName;
        EmpEmail = empEmail;
        EmpMobile = empMobile;
        EmpDepartment = empDepartment;
        Role = role;
        Adress = adress;
        this.joiningDate = joiningDate;
    }

    String EmpEmail;
    String EmpMobile;

    public Employees(int empId, String empName, String empEmail, String empMobile, String empDepartment, String role, String adress, String joiningDate) {
        EmpId = empId;
        EmpName = empName;
        EmpEmail = empEmail;
        EmpMobile = empMobile;
        EmpDepartment = empDepartment;
        Role = role;
        Adress = adress;
        this.joiningDate = joiningDate;
    }

    String EmpDepartment;
    String Role;
    String Adress;
    String joiningDate;

}
