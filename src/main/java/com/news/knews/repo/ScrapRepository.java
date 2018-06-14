package com.news.knews.repo;

import com.news.knews.domain.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ScrapRepository extends JpaRepository<Scrap,Long>{

}