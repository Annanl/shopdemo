package com.entity;

public class Goods {
    private int id;
    private String name;
    private String price;
    private String detail;
    private int number;

    public Goods() {
    }

    public Goods(int id, String name, String price, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public Goods(int id, String name, String price, String detail, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
