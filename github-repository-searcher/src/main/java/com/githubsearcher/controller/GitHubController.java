package com.githubsearcher.controller;

import com.githubsearcher.service.GitHubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GitHubController {

    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @PostMapping("/search")
    public void searchRepositories(@RequestParam String query,
                                   @RequestParam String language,
                                   @RequestParam String sort) {
        gitHubService.searchAndSaveRepositories(query, language, sort);
    }

    @GetMapping("/repositories")
    public List<RepositoryEntity> getRepositories() {
        return gitHubService.getRepositories();
    }
}
