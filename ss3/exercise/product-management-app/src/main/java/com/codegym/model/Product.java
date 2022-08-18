package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String price;
    private String describe;
    private String produce;

    public Product() {
    }

    public Product(int id, String name, String price, String describe, String produce) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.produce = produce;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }
}
