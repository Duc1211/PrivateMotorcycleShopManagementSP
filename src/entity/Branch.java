package entity;

import java.io.Serializable;

public class Branch implements Serializable {
    private String branchCode;
    private String branchName;
    private String branchLocation;

    public Branch() {
    }

    public Branch(String branchCode, String branchName, String branchLocation) {
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.branchLocation = branchLocation;
    }

    public String getBranchCode() {
        return branchCode;
    }


    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }
}
