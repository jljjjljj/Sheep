package com.jianglijiuju.model;

//单元格类 0代表无牌 1代表有牌
public class Cell {
    private Integer state=0;
    private Brand brand;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
