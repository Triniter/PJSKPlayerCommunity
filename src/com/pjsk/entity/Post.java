package com.pjsk.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Post {
    private Integer postid;
    private Integer userid;
    private String profile;
    private String title;
    private String text;
    private Date posttime;
    private String username;


    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public Integer getUser() {
        return postid;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }




    // toString 方法，用于打印和日志记录
    @Override
    public String toString() {
        return "Post{" +
                "postid=" + postid +
                ", userid=" + userid +
                ", profile='" + profile + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", posttime=" + posttime +
                '}';
    }

}
