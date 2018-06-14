package com.news.knews.repo;

import com.news.knews.domain.Thumbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ThumbsRepository extends JpaRepository<Thumbs,Long>{

}