package com.news.knews;

import javax.persistence.*;
import java.util.List;

@Entity
public class News {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;
    private String title;
    private String content;
//    @ManyToMany(mappedBy = "newses")
//    private List<User> userList;

    @OneToMany(mappedBy = "news")
    private List<Comment> commentList;

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

//    public List<User> getUserList() {
//        return userList;
//    }
//
//    public void setUserList(List<User> userList) {
//        this.userList = userList;
//    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
