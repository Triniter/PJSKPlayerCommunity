package com.pjsk.entity;

import java.util.Date;

public class OrderVO {

    private int orderid;
    private int goodid;
    private int userid;
    private int quantity;
    private String order_status;
    private Date ordertime;
    private float total;

    private String goodname;
    private String photo;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "orderid=" + orderid +
                ", goodid=" + goodid +
                ", userid=" + userid +
                ", quantity=" + quantity +
                ", order_status='" + order_status + '\'' +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", goodname='" + goodname + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
