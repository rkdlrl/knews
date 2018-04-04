package com.news.knews;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(name = "user_scrap_news",
            joinColumns = @JoinColumn(name = "USER_SEQ"),
            inverseJoinColumns = @JoinColumn(name = "NEWS_SEQ"))
    private List<News> scrapNewsList;
    private String name;

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getScrapNewsList() {
        return scrapNewsList;
    }

    public void setScrapNewsList(List<News> scrapNewsList) {
        this.scrapNewsList = scrapNewsList;
    }
}
