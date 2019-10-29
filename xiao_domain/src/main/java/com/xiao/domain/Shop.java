package com.xiao.domain;

import java.util.List;

public class Shop {

    private int shop_id;
    private String shop_name;
    private String shop_tel;
    private String shop_discounts;
    private String shop_number;   //商店编号
    private List<Record> records;

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_tel() {
        return shop_tel;
    }

    public void setShop_tel(String shop_tel) {
        this.shop_tel = shop_tel;
    }

    public String getShop_discounts() {
        return shop_discounts;
    }

    public void setShop_discounts(String shop_discounts) {
        this.shop_discounts = shop_discounts;
    }

    public String getShop_number() {
        return shop_number;
    }

    public void setShop_number(String shop_number) {
        this.shop_number = shop_number;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shop_id=" + shop_id +
                ", shop_name='" + shop_name + '\'' +
                ", shop_tel='" + shop_tel + '\'' +
                ", shop_discounts='" + shop_discounts + '\'' +
                ", shop_number='" + shop_number + '\'' +
                '}';
    }
}
