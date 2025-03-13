package com.githubsearcher.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class GitHubRepositoryDto {
    private Long id;
    private String name;
    private String description;
    private String owner;
    private String language;
    private int stars;
    private int forks;
    private ZonedDateTime lastUpdated;
}
