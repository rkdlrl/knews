package com.news.knews;

import javax.persistence.*;

@Entity
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;
    private String userId;
    private String content;
    @ManyToOne
    @JoinColumn(name = "NEWS_SEQ") //컬럼 추가
    private News news;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
