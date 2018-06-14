package com.news.knews.domain;

import javax.persistence.*;

@Entity
public class Thumbs {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    @JoinColumn(name = "user_id") //컬럼 추가   역시 단반향으로
    private String userId;

//    @ManyToOne    // 무한반복 에러
    @JoinColumn(name = "NEWS_SEQ") //컬럼 추가
    private long newsSeq;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public long getNewsSeq() {
        return newsSeq;
    }

    public void setNewsSeq(long newsSeq) {
        this.newsSeq = newsSeq;
    }
}
