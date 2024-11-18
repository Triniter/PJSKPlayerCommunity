package com.pjsk.entity;

public class Comment {

    private Integer commentid;
    private Integer postid;
    private Integer userid;
    private String text;
    private String username;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    @Override
    public String toString() {
        return "Comment{" +
                "commentid=" + commentid +
                ", postid=" + postid +
                ", userid=" + userid +
                ", text='" + text + '\'' +
                '}';
    }
}
