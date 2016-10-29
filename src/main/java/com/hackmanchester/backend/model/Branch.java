package com.hackmanchester.backend.model;

/**
 * Created by ben on 29/10/16.
 */
public class Branch {

    private int branchID;
    private String postCode;

    public Branch(int branchID, String postCode) {
        this.branchID = branchID;
        this.postCode = postCode;
    }

    public Branch() {}

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
