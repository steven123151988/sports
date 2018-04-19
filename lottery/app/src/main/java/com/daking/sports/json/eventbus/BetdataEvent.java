package com.daking.sports.json.eventbus;

/**
 * Description:
 * Data：2018/4/19-17:35
 * steven
 */
public class BetdataEvent {
    private String lid;
    private String rate;
    private boolean add;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    @Override
    public String toString() {
        return "BetdataEvent{" +
                "lid='" + lid + '\'' +
                ", rate='" + rate + '\'' +
                ", add=" + add +
                '}';
    }
}
