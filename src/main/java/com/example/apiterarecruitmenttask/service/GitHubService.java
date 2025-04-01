package com.example.apiterarecruitmenttask.service;


import com.example.apiterarecruitmenttask.dto.APIResponse;
import com.example.apiterarecruitmenttask.dto.BranchDTO;
import com.example.apiterarecruitmenttask.dto.RepoDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
@Service
public class GitHubService {
    public ArrayList<RepoDTO> getRepositories(String owner) throws IOException, InterruptedException {

        ArrayList<RepoDTO> repos = new ArrayList<>();
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/"+owner+"/repos"))
                .header("Accept","application/vnd.github+json")
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        JSONArray jsonArray = new JSONArray(response.body());

        for(int i = 0 ; i<jsonArray.length(); i++){
            JSONObject repo = jsonArray.getJSONObject(i);
            boolean isFork = repo.getBoolean("fork");
            if(!isFork){
                String repositoryName = repo.getString("name");
                String ownerLogin = repo.getJSONObject("owner").getString("login");

                repos.add(new RepoDTO(repositoryName,ownerLogin));
            }

        }

        return repos;



    }

    public ArrayList<BranchDTO> getBranches(RepoDTO repo) throws IOException, InterruptedException {
        ArrayList<BranchDTO> branches = new ArrayList<>();

        String repo_owner = repo.getOwnerLogin();
        String repo_name = repo.getRepositoryName();

        String url = "https://api.github.com/repos/"+repo_owner+"/"+repo_name+"/branches";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept","application/vnd.github+json")
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        JSONArray array = new JSONArray(response.body());

        for(int i =0;i<array.length();i++){

            JSONObject obj = array.getJSONObject(i);

            String branch_name = obj.getString("name");
            String sha = obj.getJSONObject("commit").getString("sha");

            branches.add(new BranchDTO(branch_name,sha));

        }

        return branches;



    }


    public ArrayList<APIResponse> execute(String owner) throws IOException, InterruptedException {
        ArrayList<APIResponse> resp = new ArrayList<>();
        ArrayList<RepoDTO> repos = getRepositories(owner);

        for(RepoDTO r : repos){

            ArrayList<BranchDTO> branches = getBranches(r);

            resp.add(new APIResponse(r.getRepositoryName(),r.getOwnerLogin(),branches));
        }

        return resp;

    }



}
