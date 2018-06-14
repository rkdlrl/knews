package com.news.knews.repo;

import com.news.knews.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,String>{
    User findUserByIdAndPassword(String id, String password);
}