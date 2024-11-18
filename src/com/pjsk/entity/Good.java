package com.pjsk.entity;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;

public class Good {

    private int goodid;
    private String goodname;
    private float price;
    private int quantity;
    private String photo;
    private int userid;

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodid=" + goodid +
                ", goodname='" + goodname + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", photo='" + photo + '\'' +
                ", userid=" + userid +
                '}';
    }
}
