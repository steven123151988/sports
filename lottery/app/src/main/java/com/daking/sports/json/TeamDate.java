package com.daking.sports.json;

import java.io.Serializable;

/**
 * Description:
 * Data：2018/4/17-19:26
 * steven
 */
public class TeamDate  implements Serializable{
    private String h_cn;
    private String a_cn;
    private String lid;
    private String date;
    private String time;

    public String getH_cn() {
        return h_cn;
    }

    public void setH_cn(String h_cn) {
        this.h_cn = h_cn;
    }

    public String getA_cn() {
        return a_cn;
    }

    public void setA_cn(String a_cn) {
        this.a_cn = a_cn;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
