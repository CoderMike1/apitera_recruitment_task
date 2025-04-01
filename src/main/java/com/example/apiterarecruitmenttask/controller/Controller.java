package com.example.apiterarecruitmenttask.controller;


import com.example.apiterarecruitmenttask.dto.APIResponse;
import com.example.apiterarecruitmenttask.dto.RepoDTO;
import com.example.apiterarecruitmenttask.service.GitHubService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

@RestController
@RequestMapping("api")
public class Controller {
    private final GitHubService service;

    @Autowired
    public Controller(GitHubService service){
        this.service = service;
    }

    @GetMapping(path = "getRepos/{ownerLogin}")
    public ArrayList<APIResponse> hello(@PathVariable String ownerLogin) throws IOException, InterruptedException {

        return service.execute(ownerLogin);

    }

}
