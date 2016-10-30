package com.hackmanchester.backend.model;

/**
 * Created by ben on 29/10/16.
 */
public class User {

    private int userID, branchID;
    private String name, telNo, base64Image;

    public User(int userID, String name, String telNo, int branchID) {
        this.userID = userID;
        this.name = name;
        this.telNo = telNo;
        this.branchID = branchID;
    }

    public User(int userID, String name, String telNo, int branchID, String base64Image) {
        this.userID = userID;
        this.name = name;
        this.telNo = telNo;
        this.branchID = branchID;
        this.base64Image = base64Image;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getBase64Image()
    {
        return base64Image;
    }

    public void setBase64Image(String base64Image)
    {
        this.base64Image = base64Image;
    }
}
