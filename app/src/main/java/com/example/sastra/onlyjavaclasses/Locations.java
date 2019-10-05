package com.example.sastra.onlyjavaclasses;

public class Locations {
    int locationid;

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    public String getLoactionDescription() {
        return loactionDescription;
    }

    public void setLoactionDescription(String loactionDescription) {
        this.loactionDescription = loactionDescription;
    }

    String locationname;

    public Locations(int locationid, String locationname, String loactionDescription) {
        this.locationid = locationid;
        this.locationname = locationname;
        this.loactionDescription = loactionDescription;
    }

    String loactionDescription;

    public Locations(String locationname, String loactionDescription) {
        this.locationname = locationname;
        this.loactionDescription = loactionDescription;
    }
}
