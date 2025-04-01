package com.example.apiterarecruitmenttask.controller;


import com.example.apiterarecruitmenttask.service.GitHubService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("get-repos")
public class Controller {
    private final GitHubService service;

    @Autowired
    public Controller(GitHubService service){
        this.service = service;
    }

    @GetMapping
    public void hello() throws IOException, InterruptedException {

        service.getRepo();


    }

}
