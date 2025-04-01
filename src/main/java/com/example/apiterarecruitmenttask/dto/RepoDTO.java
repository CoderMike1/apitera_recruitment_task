package com.example.apiterarecruitmenttask.dto;

import java.util.List;

public class RepoDTO {

    private String repositoryName;
    private String ownerLogin;
    private List<BranchDTO> branches;

    public RepoDTO(String repositoryName, String ownerLogin) {
        this.repositoryName = repositoryName;
        this.ownerLogin = ownerLogin;
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
}
