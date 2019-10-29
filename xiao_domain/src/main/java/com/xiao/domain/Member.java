package com.xiao.domain;

import com.xiao.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Member {
    private int m_id;
    private String m_name;
    private int m_sex;
    private String sexStr;
    private String m_idcard;
    private String m_class;
    private String m_tel;
    private String m_dept;
    private String m_desc;
    private Date m_date;
    private String dateStr;
    private int m_status;   //会员状态1-正常0-注销
    private String statusStr;
    private int m_grade;    //会员等级 0-...
    private String gradeStr;
    private int m_integral;  //会员积分
    private List<Record> records;



    public int getM_status() {
        return m_status;
    }

    public void setM_status(int m_status) {
        this.m_status = m_status;
    }

    public String getStatusStr() {
        if(m_status == 1){
            statusStr = "正常";
        }else if(m_status == 0){
            statusStr = "注销";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public int getM_grade() {
        return m_grade;
    }

    public void setM_grade(int m_grade) {
        this.m_grade = m_grade;
    }

    public String getGradeStr() {
        switch (m_grade){
            case 0:
                gradeStr = "初级";
                break;
            case 5:
                gradeStr = "中级";
                break;
            case 10:
                gradeStr = "高级";
                break;
        }
        return gradeStr;
    }

    public void setGradeStr(String gradeStr) {
        this.gradeStr = gradeStr;
    }

    public int getM_integral() {
        return m_integral;
    }

    public void setM_integral(int m_integral) {
        this.m_integral = m_integral;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public int getM_sex() {
        return m_sex;
    }

    public void setM_sex(int m_sex) {
        this.m_sex = m_sex;
    }

    public String getSexStr() {
        if(m_sex == 0){
            sexStr = "男";
        }
        if(m_sex == 1){
            sexStr = "女";
        }
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getM_idcard() {
        return m_idcard;
    }

    public void setM_idcard(String m_idcard) {
        this.m_idcard = m_idcard;
    }

    public String getM_class() {
        return m_class;
    }

    public void setM_class(String m_class) {
        this.m_class = m_class;
    }

    public String getM_tel() {
        return m_tel;
    }

    public void setM_tel(String m_tel) {
        this.m_tel = m_tel;
    }

    public String getM_dept() {
        return m_dept;
    }

    public void setM_dept(String m_dept) {
        this.m_dept = m_dept;
    }

    public String getM_desc() {
        return m_desc;
    }

    public void setM_desc(String m_desc) {
        this.m_desc = m_desc;
    }

    public Date getM_date() {
        return m_date;
    }

    public void setM_date(Date m_date) {
        this.m_date = m_date;
    }

    public String getDateStr() {
        if(m_date != null){
            dateStr = DateUtils.date2String(m_date,"yyyy年MM月dd");
        }
        return dateStr;
    }
    public String getDateStr2(){
        if(m_date != null){
            dateStr = DateUtils.date2String(m_date,"yyyy年MM月dd HH:mm:ss");
        }
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Member{" +
                "m_id=" + m_id +
                ", m_name='" + m_name + '\'' +
                ", m_sex=" + m_sex +
                ", sexStr='" + sexStr + '\'' +
                ", m_idcard='" + m_idcard + '\'' +
                ", m_class='" + m_class + '\'' +
                ", m_tel='" + m_tel + '\'' +
                ", m_dept='" + m_dept + '\'' +
                ", m_desc='" + m_desc + '\'' +
                ", m_date=" + m_date +
                ", dateStr='" + dateStr + '\'' +
                ", m_status=" + m_status +
                ", statusStr='" + statusStr + '\'' +
                ", m_grade=" + m_grade +
                ", gradeStr='" + gradeStr + '\'' +
                ", m_integral=" + m_integral +
                ", records=" + records +
                '}';
    }
}
