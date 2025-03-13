package com.githubsearcher.repository;

import com.githubsearcher.entity.RepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRepository extends JpaRepository<RepositoryEntity, Long> {
}
