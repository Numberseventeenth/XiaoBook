package com.xiao.domain;

import com.xiao.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Borrow {

    private int m_id;
    private Date b_start;
    private String bStartStr;
    private int day;
    private Date b_end;   //应该归还时间
    private String bEndStr;
    private int b_status;
    private String bStatusStr;
    private int b_day;
    private String book_isbn;
    private Date b_back;   //实际归还时间
    private String bBackStr;
    private List<Member> members;
    private List<Book> books;

    private Member member;
    private Book book;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getbStatusStr() {
        //1-借出  0-归还
        if(b_status == 1){
            bStatusStr = "已借出";
        }
        if(b_status == 0){
            bStatusStr = "已归还";
        }
        return bStatusStr;
    }

    public void setbStatusStr(String bStatusStr) {
        this.bStatusStr = bStatusStr;
    }

    public String getbStartStr() {
        if(b_start != null){
            bStartStr = DateUtils.date2String(b_start,"yyyy年MM月dd日 HH:mm");
        }
        return bStartStr;
    }

    public void setbStartStr(String bStartStr) {
        this.bStartStr = bStartStr;
    }

    public String getbEndStr() {
        if(b_end != null){
            bEndStr = DateUtils.date2String(b_end,"yyyy年MM月dd日 HH:mm");
        }
        return bEndStr;
    }

    public void setbEndStr(String bEndStr) {
        this.bEndStr = bEndStr;
    }

    public String getbBackStr() {
        if(b_back != null){
            bBackStr = DateUtils.date2String(b_back,"yyyy年MM月dd日 HH:mm");
        }
        return bBackStr;
    }

    public void setbBackStr(String bBackStr) {
        this.bBackStr = bBackStr;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public int getB_day() {
        return b_day;
    }

    public void setB_day(int b_day) {
        this.b_day = b_day;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public Date getB_start() {
        return b_start;
    }

    public void setB_start(Date b_start) {
        this.b_start = b_start;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Date getB_end() {
        return b_end;
    }

    public void setB_end(Date b_end) {
        this.b_end = b_end;
    }

    public int getB_status() {
        return b_status;
    }

    public void setB_status(int b_status) {
        this.b_status = b_status;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public Date getB_back() {
        return b_back;
    }

    public void setB_back(Date b_back) {
        this.b_back = b_back;
    }


}
