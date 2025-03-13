package com.githubsearcher.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.githubsearcher.dto.GitHubRepositoryDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class GitHubApiClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GitHubApiClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public List<GitHubRepositoryDto> searchRepositories(String query, String language, String sort) {
        String url = String.format("https://api.github.com/search/repositories?q=%s+language:%s&sort=%s", query, language, sort);
        String jsonResponse = restTemplate.getForObject(url, String.class);
        List<GitHubRepositoryDto> results = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(jsonResponse);
            for (JsonNode item : root.get("items")) {
                GitHubRepositoryDto dto = objectMapper.treeToValue(item, GitHubRepositoryDto.class);
                results.add(dto);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse GitHub response", e);
        }
        return results;
    }
}
