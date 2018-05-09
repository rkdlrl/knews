package com.news.knews;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class News {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;
    @Enumerated(EnumType.STRING)
    private Categories category;
    private String title;
    private String content;
    private Date regDate;
//    @ManyToMany(mappedBy = "newses")
//    private List<User> userList;
    @OneToMany(mappedBy = "news")
    private List<Scrap> scrapList;
    @OneToMany(mappedBy = "news")
    private List<Comment> commentList;

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

    public List<Scrap> getScrapList() {
        return scrapList;
    }

    public void setScrapList(List<Scrap> scrapList) {
        this.scrapList = scrapList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
