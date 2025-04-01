package com.example.apiterarecruitmenttask.service;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

@Service
public class GitHubService {


    public void getRepositories(String owner) throws IOException, InterruptedException {


        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/"+owner+"/repos"))
                .header("Accept","application/vnd.github+json")
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        JSONArray jsonArray = new JSONArray(response.body());

        for(int i = 0 ; i<jsonArray.length(); i++){
            JSONObject repo = jsonArray.getJSONObject(i);

            String repositoryName = repo.getString("name");
            Boolean isFork = repo.getBoolean("fork");

        }



    }



}
