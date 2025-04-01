package com.example.apiterarecruitmenttask;

import com.example.apiterarecruitmenttask.exception.NoRepositoriesFoundException;
import com.example.apiterarecruitmenttask.service.GitHubService;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AppIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnReposValidUser() throws Exception {
        String owner_name = "CoderMike1";

        mockMvc.perform(get("/api/getRepos/{ownerLogin}", owner_name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].ownerLogin").value(owner_name));
    }

    @Test
    public void shouldReturnErrorNotFoundUser() throws Exception{
        String imagine_owner = "isodj324zz";

        mockMvc.perform(get("/api/getRepos/{ownerLogin}", imagine_owner))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("user "+imagine_owner+" not found."));
    }

    @Test
    public void shouldReturnBranchFormat() throws Exception{
        String owner_name = "CoderMike1";

        mockMvc.perform(get("/api/getRepos/{ownerLogin}", owner_name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].repositoryName").exists())
                .andExpect(jsonPath("$[0].branches").isArray())
                .andExpect(jsonPath("$[0].branches[0].branchName").isString())
                .andExpect(jsonPath("$[0].branches[0].sha").exists());


    }

    @Test
    public void shouldReturnNoRepositoriesError() throws Exception{
        String owner_with_no_repositories = "user2212";

       mockMvc.perform(get("/api/getRepos/{owner_login}", owner_with_no_repositories))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("user '"+owner_with_no_repositories+"' does not have any repositories."));

    }





}
