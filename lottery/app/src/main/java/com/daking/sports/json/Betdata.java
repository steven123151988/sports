package com.daking.sports.json;

import java.util.List;

/**
 * Description:
 * Data：2018/4/19-10:09
 * steven
 */
public class Betdata {


    /**
     * lid : “fdsajlXXfd2”
     * data : ["\u201ch_1 .40\u201d","\u201cd_1 .40\u201d"]
     */

    private String lid;
    private List<String> data;

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
