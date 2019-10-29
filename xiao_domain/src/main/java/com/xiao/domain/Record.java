package com.xiao.domain;

import com.xiao.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Record {
    private int m_id;  //会员
    private Date r_date;  //刷卡时间
    private String dateStr;
    private int shop_id;  //商店id
    private List<Shop> shops;
    private List<Member> members;
    private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public Date getR_date() {
        return r_date;
    }

    public void setR_date(Date r_date) {
        this.r_date = r_date;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getDateStr() {
        if(r_date != null){
            dateStr = DateUtils.date2String(r_date,"yyyy年MM月dd HH:mm:ss");
        }
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }



}
