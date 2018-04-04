package com.news.knews;

import javax.persistence.*;

@Entity
public class ProductOrder {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;
    private String title;
    private String content;
    @ManyToOne //*:1 관계
    @JoinColumn(name = "MEMBER_SEQ") //컬럼 추가
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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
}
