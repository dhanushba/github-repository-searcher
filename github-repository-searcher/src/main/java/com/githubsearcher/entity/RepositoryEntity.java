package com.githubsearcher.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "repository")
public class RepositoryEntity {

    @Id
    private Long id;

    private String name;
    private String description;
    private String owner;
    private String language;
    private int stars;
    private int forks;
    private ZonedDateTime lastUpdated;
}
