package com.daking.sports.json;

import java.util.List;

/**
 * Description:
 * Data：2018/4/10-16:21
 * steven
 */
public class BankcardList extends BaseModel{

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bid : 1
         * name : 中国工商银行
         */

        private String bid;
        private String name;

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
