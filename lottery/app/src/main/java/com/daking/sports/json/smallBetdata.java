package com.daking.sports.json;

import java.io.Serializable;

/**
 * Description:
 * Data：2018/4/20-18:34
 * steven
 */
public class smallBetdata  implements Serializable{
    private String lid;
    private String rate;
    private boolean ifadd;

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public boolean isIfadd() {
        return ifadd;
    }

    public void setIfadd(boolean ifadd) {
        this.ifadd = ifadd;
    }

    @Override
    public String toString() {
        return "smallBetdata{" +
                "lid='" + lid + '\'' +
                ", rate='" + rate + '\'' +
                ", ifadd=" + ifadd +
                '}';
    }
}
