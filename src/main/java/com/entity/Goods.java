package com.entity;

public class Goods {
    private String id;
    private String name;
    private String price;
    private String detail;

    public Goods() {
    }

    public Goods(String name, String price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}