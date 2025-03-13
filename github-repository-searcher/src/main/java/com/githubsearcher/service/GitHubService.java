package com.githubsearcher.service;

import com.githubsearcher.client.GitHubApiClient;
import com.githubsearcher.dto.GitHubRepositoryDto;
import com.githubsearcher.entity.RepositoryEntity;
import com.githubsearcher.repository.RepositoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubService {

    private final RepositoryRepository repositoryRepository;
    private final GitHubApiClient gitHubApiClient;
    private final ModelMapper modelMapper;

    public GitHubService(RepositoryRepository repositoryRepository,
                         GitHubApiClient gitHubApiClient, ModelMapper modelMapper) {
        this.repositoryRepository = repositoryRepository;
        this.gitHubApiClient = gitHubApiClient;
        this.modelMapper = modelMapper;
    }

    public void searchAndSaveRepositories(String query, String language, String sort) {
        List<GitHubRepositoryDto> repositories = gitHubApiClient.searchRepositories(query, language, sort);
        List<RepositoryEntity> entities = repositories.stream()
                .map(dto -> modelMapper.map(dto, RepositoryEntity.class))
                .toList();
        repositoryRepository.saveAll(entities);
    }

    public List<RepositoryEntity> getRepositories() {
        return repositoryRepository.findAll();
    }
}
