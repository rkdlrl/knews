package com.news.knews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NewsRepository extends JpaRepository<News,Long>{

}