package com.news.knews.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
//    private long seq;
    
//    @Column(name="id", unique=true)
    @Id
    private String id;
    private String password;
    private String name;
//    @ManyToMany
//    @JoinTable(name = "user_scrap_news",
//            joinColumns = @JoinColumn(name = "USER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "NEWS_SEQ"))
//    private List<News> scrapNewsList;
    @OneToMany(mappedBy = "userId")
    private List<Thumbs> thumbsList;

//    public long getSeq() {
//        return seq;
//    }
//
//    public void setSeq(long seq) {
//        this.seq = seq;
//    }

    public List<Thumbs> getThumbsList() {
        return thumbsList;
    }

    public void setThumbsList(List<Thumbs> thumbsList) {
        this.thumbsList = thumbsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
