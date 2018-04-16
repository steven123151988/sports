package com.daking.sports.json;

import java.util.List;

/**
 * Description:
 * Data：2018/4/16-18:10
 * steven
 */
public class getPayPlatformRsp extends BaseModel {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * lid : GT
         * name : 线路1
         */

        private String lid;
        private String name;

        public String getLid() {
            return lid;
        }

        public void setLid(String lid) {
            this.lid = lid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
