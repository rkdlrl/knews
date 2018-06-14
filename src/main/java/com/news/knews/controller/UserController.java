package com.news.knews.controller;

import com.news.knews.domain.News;
import com.news.knews.domain.Thumbs;
import com.news.knews.domain.User;
import com.news.knews.repo.NewsRepository;
import com.news.knews.repo.ThumbsRepository;
import com.news.knews.repo.UserRepository;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    public User insertUser(@RequestBody User user){

        User result = userRepository.save(user);

        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getUserAll(){
        Iterable<User> result = userRepository.findAll();

        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User loginUser(@RequestBody User user){
        User result = userRepository.findUserByIdAndPassword(user.getId(), user.getPassword());
        return result;
    }

}
