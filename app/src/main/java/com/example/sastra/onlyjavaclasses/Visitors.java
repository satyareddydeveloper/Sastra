package com.example.sastra.onlyjavaclasses;

public class Visitors {
    int VISITORID;
    String VisitorMobile;

    public int getVISITORID() {
        return VISITORID;
    }

    public void setVISITORID(int VISITORID) {
        this.VISITORID = VISITORID;
    }

    public String getVisitorMobile() {
        return VisitorMobile;
    }

    public void setVisitorMobile(String visitorMobile) {
        VisitorMobile = visitorMobile;
    }

    public String getVisitorName() {
        return VisitorName;
    }

    public void setVisitorName(String visitorName) {
        VisitorName = visitorName;
    }

    public String getVisitorEmail() {
        return VisitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        VisitorEmail = visitorEmail;
    }

    public String getVisitorCompany() {
        return VisitorCompany;
    }

    public void setVisitorCompany(String visitorCompany) {
        VisitorCompany = visitorCompany;
    }

    public String getVisitorRole() {
        return VisitorRole;
    }

    public void setVisitorRole(String visitorRole) {
        VisitorRole = visitorRole;
    }

    public String getVisitorProof() {
        return VisitorProof;
    }

    public void setVisitorProof(String visitorProof) {
        VisitorProof = visitorProof;
    }

    public String getVisitorProofNumber() {
        return VisitorProofNumber;
    }

    public void setVisitorProofNumber(String visitorProofNumber) {
        VisitorProofNumber = visitorProofNumber;
    }

    public String getVisitorAdress() {
        return VisitorAdress;
    }

    public void setVisitorAdress(String visitorAdress) {
        VisitorAdress = visitorAdress;
    }

    String VisitorName;
    String VisitorEmail;

    public Visitors(String visitorMobile, String visitorName, String visitorEmail, String visitorCompany, String visitorRole, String visitorProof, String visitorProofNumber, String visitorAdress) {
        VisitorMobile = visitorMobile;
        VisitorName = visitorName;
        VisitorEmail = visitorEmail;
        VisitorCompany = visitorCompany;
        VisitorRole = visitorRole;
        VisitorProof = visitorProof;
        VisitorProofNumber = visitorProofNumber;
        VisitorAdress = visitorAdress;
    }

    public Visitors(int VISITORID, String visitorMobile, String visitorName, String visitorEmail, String visitorCompany, String visitorRole, String visitorProof, String visitorProofNumber, String visitorAdress) {
        this.VISITORID = VISITORID;
        VisitorMobile = visitorMobile;
        VisitorName = visitorName;
        VisitorEmail = visitorEmail;
        VisitorCompany = visitorCompany;
        VisitorRole = visitorRole;
        VisitorProof = visitorProof;
        VisitorProofNumber = visitorProofNumber;
        VisitorAdress = visitorAdress;
    }

    String VisitorCompany;
    String VisitorRole;
    String VisitorProof;
    String VisitorProofNumber;
    String VisitorAdress;

}
