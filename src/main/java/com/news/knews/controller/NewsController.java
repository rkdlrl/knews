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
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    NewsRepository newsRepository;

    //이미지 형식 현재는 png만 선택가능
    private final String BASE_64_PREFIX = "data:image/png;base64,";
//    png, gif, jpg 모두 검사하기??
//    private final HashMap<String, String> basePrefix = new HashMap<String, String>() {
//        {
//            put("data:image/png;base64,", "png");
//            put("data:image/png;base64,", "jpg");
//            put("data:image/gif;base64,", "gif");
//        }
//    };
    //이미지 저장 위치
    private final String newsImgPath = "D:/img/";

//    파일형식이 multipart(Bolb)라면 요렇게 받기
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseBody
//    public News PostSubmit(@ModelAttribute News news){
//        return news;
//    }

//   파일 형식이 dataUrl라면 컨트롤러에서는 이렇게 받아야한다.
    @RequestMapping(method = RequestMethod.POST)
    public News insertNews(@RequestBody News news) throws IOException {
        News result = newsRepository.save(news);
        storeNewsImg(decodeBase64ToBytes(news.getFileImg()), getImgNm(news), Paths.get(newsImgPath));
        return result;
    }

    //모든 뉴스 가져오기
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<News> getNewsAll() throws IOException {
        Iterable<News> result = newsRepository.findAll();
        for(News item : result) {
            item.setFileImg(getNewsImgByLocal(item));
        }
        return result;
    }



    // dataUrl형식을 byte[]로 바꾸기
    public byte[] decodeBase64ToBytes(String imageString) {
        if (imageString.startsWith(BASE_64_PREFIX))
            return Base64.getDecoder().decode(imageString.substring(BASE_64_PREFIX.length()));
        else
            throw new IllegalStateException("it is not base 64 string");
    }

    // db에 있는 파일 이름 받아서 dataUrl로 바꾸기
    public String encodeBytesToBase64(String imgNm) throws IOException {
        byte[] imageArray;
        StringBuilder sb = new StringBuilder();

        //path에 있는 이미지 찾아서 가져오기
        imageArray = Files.readAllBytes(Paths.get(newsImgPath+imgNm));
        sb.append("data:image/png;base64,");
        sb.append(StringUtils.newStringUtf8(Base64.getEncoder().encode(imageArray)));

        return sb.toString();
    }

    // byte로 path에 이미지 저장
    public String storeNewsImg(byte[] bytes, String name, Path path) throws IOException {
        Files.copy(new ByteArrayInputStream(bytes), path.resolve(name));
        return path.resolve(name).toAbsolutePath().toString();
    }

    // 함수를 부르는 함수..? 왜만들었지..
    public String getNewsImgByLocal(News news) throws IOException {
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

    // 이미지 저장할때 이미지의 이름 세팅
    public String getImgNm(News news) {
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH;mm;ss");
        String date = transFormat.format(news.getRegDate());
        return news.getSeq()+"_"+date+".png";
    }
}
