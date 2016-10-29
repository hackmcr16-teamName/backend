package com.hackmanchester.backend.controller;

/**
 * Created by ben on 29/10/16.
 */
public class Interest {

    private int interestID;
    private String name;

    public Interest(int interestID, String name) {
        this.interestID = interestID;
        this.name = name;
    }

    public Interest() {}

    public int getInterestID() {
        return interestID;
    }

    public void setInterestID(int interestID) {
        this.interestID = interestID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
