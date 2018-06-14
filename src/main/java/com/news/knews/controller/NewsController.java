package com.news.knews.controller;

import com.news.knews.domain.News;
import com.news.knews.repo.NewsRepository;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    NewsRepository newsRepository;

    private final String BASE_64_PREFIX = "data:image/png;base64,";
//    png, gif, jpg 모두 검사하기??
//    private final HashMap<String, String> basePrefix = new HashMap<String, String>() {
//        {
//            put("data:image/png;base64,", "png");
//            put("data:image/png;base64,", "jpg");
//            put("data:image/gif;base64,", "gif");
//        }
//    };
    private final String newsImgPath = "D:/img/";

//    multipart(Bolb)로 할 때는 요렇게 받기
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseBody
//    public News PostSubmit(@ModelAttribute News news){
//        return news;
//    }

//   dataUrl로 할땐 요렇게
    @RequestMapping(method = RequestMethod.POST)
    public News PostInput(@RequestBody News news){

        News result = newsRepository.save(news);
        storeNewsImg(decodeBase64ToBytes(news.getFileImg()), getImgNm(news), Paths.get(newsImgPath));

        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<News> getNewsList(){
        Iterable<News> result = newsRepository.findAll();

        for(News item : result) {
            item.setFileImg(getNewsImgByLocal(item));
        }

        return result;
    }




    public byte[] decodeBase64ToBytes(String imageString) {
        if (imageString.startsWith(BASE_64_PREFIX))
            return Base64.getDecoder().decode(imageString.substring(BASE_64_PREFIX.length()));
        else
            throw new IllegalStateException("it is not base 64 string");
    }

    public String encodeBytesToBase64(String imgNm) {
        byte[] imageArray = new byte[0];
        StringBuilder sb = new StringBuilder();

        try {
            imageArray = Files.readAllBytes(Paths.get(newsImgPath+imgNm));
            sb.append("data:image/png;base64,");
            sb.append(StringUtils.newStringUtf8(Base64.getEncoder().encode(imageArray)));
//        sb.append((Base64.getEncoder().encodeToString(imageArray));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public String storeNewsImg(byte[] bytes, String name, Path path) {
        try {
            Files.copy(new ByteArrayInputStream(bytes), path.resolve(name));
            return path.resolve(name).toAbsolutePath().toString();
        } catch (IOException e) {
            return "error";
        }
    }

    public String getNewsImgByLocal(News news) {
        return encodeBytesToBase64(getImgNm(news));
    }

//    public void setImgNm(News news) {
//        String extension;
//        for(String prefix : basePrefix.keySet()) {
//            if(news.getFileImg().startsWith(prefix)){
//                extension = basePrefix.get(prefix);
//                news.setFileNm(news.getSeq()+"_"+news.getTitle()+"."+extension);
//            } else {
//                news.setFileNm(null);
//            }
//        }
//    }

    public String getImgNm(News news) {
        return news.getSeq()+"_"+news.getTitle()+".png";
    }
}
