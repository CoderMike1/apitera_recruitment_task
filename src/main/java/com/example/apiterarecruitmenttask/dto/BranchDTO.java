package com.example.apiterarecruitmenttask.dto;

public class BranchDTO {

    private String branchName;
    private String sha;


    public BranchDTO(String branchName, String sha) {
        this.branchName = branchName;
        this.sha = sha;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
