package com.hackmanchester.backend.model;

/**
 * Created by ben on 29/10/16.
 */
public class User {

    private int userID, branchID;
    private String firstName, surname, telNo;

    public User(int userID, String firstName, String surname, String telNo, int branchID) {
        this.userID = userID;
        this.firstName = firstName;
        this.surname = surname;
        this.telNo = telNo;
        this.branchID = branchID;
    }

    public User() {}

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
}
