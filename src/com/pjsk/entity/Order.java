package com.pjsk.entity;

import java.util.Date;

public class Order {

    private int orderid;
    private int goodid;
    private int userid;
    private int quantity;
    private String status;
    private Float total;
    private Date ordertime;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getTotal() { return total;}

    public void setTotal(Float total) { this.total = total; }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", goodid=" + goodid +
                ", userid=" + userid +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", ordertime=" + ordertime +
                '}';
    }
}
