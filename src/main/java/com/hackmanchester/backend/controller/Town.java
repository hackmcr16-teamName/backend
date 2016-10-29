package com.hackmanchester.backend.controller;

/**
 * Created by ben on 29/10/16.
 */
public class Town {

    private int townID;
    private String town;

    public Town(int townID, String town) {
        this.townID = townID;
        this.town = town;
    }

    public Town() {}

    public int getTownID() {
        return townID;
    }

    public void setTownID(int townID) {
        this.townID = townID;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
