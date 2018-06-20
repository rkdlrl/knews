package com.news.knews.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class News implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;
    @Enumerated(EnumType.STRING)
    private Categories category;
    private String title;
    private String content;
    private Date regDate;

//    blob으로 할때
//    @JsonIgnore
//    @Transient
//    private MultipartFile fileImg;
//    @JsonProperty("fileImg")
//    private String fileNm;

//    dataUrl로 할때
    private String fileNm;
    @Transient
    private String fileImg;

//    @ManyToMany(mappedBy = "newses")
//    private List<User> userList;
    @OneToMany(mappedBy = "newsSeq", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Thumbs> thumbsList;

    public String getFileImg() {
        return fileImg;
    }

    public void setFileImg(String fileImg) {
        this.fileImg = fileImg;
    }

    public String getFileNm() {
        return fileNm;
    }

    public void setFileNm(String fileNm) {
        this.fileNm = fileNm;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public List<Thumbs> getThumbsList() {
        return thumbsList;
    }

    public void setThumbsList(List<Thumbs> thumbsList) {
        this.thumbsList = thumbsList;
    }
}
