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

    //user sign up
    @RequestMapping(method = RequestMethod.POST)
    public User insertUser(@RequestBody User user){
        User result = userRepository.save(user);
        return result;
    }

    //모든 유저 가져오기
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getUserAll(){
        Iterable<User> result = userRepository.findAll();

        return result;
    }

    //로그인
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User loginUser(@RequestBody User user){
        //레파지토리에 함수 작성하여 검색, id와 password가 같은지 확인 후 user 리턴
        User result = userRepository.findUserByIdAndPassword(user.getId(), user.getPassword());
        return result;
    }

}
