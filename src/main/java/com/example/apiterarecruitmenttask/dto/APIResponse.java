package com.example.apiterarecruitmenttask.dto;

import java.util.ArrayList;
import java.util.List;

public class APIResponse {

    private String repositoryName;
    private String ownerLogin;
    private ArrayList<BranchDTO> branches;

    public APIResponse(String repositoryName, String ownerLogin, ArrayList<BranchDTO> branches) {
        this.repositoryName = repositoryName;
        this.ownerLogin = ownerLogin;
        this.branches = branches;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public ArrayList<BranchDTO> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<BranchDTO> branches) {
        this.branches = branches;
    }
}
