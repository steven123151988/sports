package com.daking.sports.json;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 * Data：2018/4/9-11:14
 * steven
 */
public class HotgameRsp extends BaseModel{

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * lid : 20180407YX003
         * date : 04-07
         * time : 13:00
         * sale_start_at : 2018-04-09 09:00:00
         * sale_stop_at : 2018-04-07 12:55:00
         * status : 1
         * h_cn : 仁川联
         * a_cn : 全南天龙
         * show : 1
         */

        private String lid;
        private String date;
        private String time;
        private String sale_start_at;
        private String sale_stop_at;
        private String status;
        private String h_cn;
        private String a_cn;
        private String show;

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

        public String getSale_start_at() {
            return sale_start_at;
        }

        public void setSale_start_at(String sale_start_at) {
            this.sale_start_at = sale_start_at;
        }

        public String getSale_stop_at() {
            return sale_stop_at;
        }

        public void setSale_stop_at(String sale_stop_at) {
            this.sale_stop_at = sale_stop_at;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

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

        public String getShow() {
            return show;
        }

        public void setShow(String show) {
            this.show = show;
        }
    }
}
