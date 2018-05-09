package com.news.knews;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Scrap {
    @Id
    private Long seq;
    @ManyToOne
    @JoinColumn(name = "USER_ID") //컬럼 추가
    private User user;
    @ManyToOne
    @JoinColumn(name = "NEWS_SEQ") //컬럼 추가
    private News news;

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
