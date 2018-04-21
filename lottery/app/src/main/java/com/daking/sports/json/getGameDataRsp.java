package com.daking.sports.json;

import java.io.Serializable;
import java.util.List;

public class getGameDataRsp extends BaseModel {


    private List<DataBeanX> data;

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * l_cn : 亚洲冠军联赛
         * num : 20
         * data : [{"lid":"20180305YX001","date":"03-05","time":"05:30","sale_stop_at":"2018-03-05 05:25:00","status":1,"h_cn":"纳萨夫","a_cn":"多哈萨德","show":1},{"lid":"20180305YX002","date":"03-05","time":"05:45","sale_stop_at":"2018-03-05 05:40:00","status":1,"h_cn":"波斯波利斯","a_cn":"迪拜瓦斯尔","show":1},{"lid":"20180305YX003","date":"03-05","time":"07:00","sale_stop_at":"2018-03-05 06:55:00","status":1,"h_cn":"阿布扎比贾兹拉","a_cn":"大不里士拖拉机","show":1},{"lid":"20180305YX004","date":"03-05","time":"07:10","sale_stop_at":"2018-03-05 07:05:00","status":1,"h_cn":"多哈加拉法","a_cn":"吉达阿赫利","show":1},{"lid":"20180402YX031","date":"04-02","time":"07:30","sale_stop_at":"2018-04-02 07:25:00","status":1,"h_cn":"纳萨夫","a_cn":"波斯波利斯","show":1},{"lid":"20180402YX032","date":"04-02","time":"08:30","sale_stop_at":"2018-04-02 08:25:00","status":1,"h_cn":"德黑兰独立","a_cn":"赖扬","show":1},{"lid":"20180402YX033","date":"04-02","time":"08:30","sale_stop_at":"2018-04-02 08:25:00","status":1,"h_cn":"阿布扎比艾因","a_cn":"利雅得希拉尔","show":1},{"lid":"20180402YX036","date":"04-02","time":"09:00","sale_stop_at":"2018-04-02 08:55:00","status":1,"h_cn":"多哈萨德","a_cn":"迪拜瓦斯尔","show":1},{"lid":"20180403YX001","date":"04-03","time":"18:00","sale_stop_at":"2018-04-03 17:55:00","status":1,"h_cn":"大阪樱花","a_cn":"济州联","show":1},{"lid":"20180403YX002","date":"04-03","time":"19:00","sale_stop_at":"2018-04-03 18:55:00","status":1,"h_cn":"布里兰","a_cn":"广州恒大","show":1},{"lid":"20180403YX003","date":"04-03","time":"19:00","sale_stop_at":"2018-04-03 18:55:00","status":1,"h_cn":"水原三星","a_cn":"悉尼FC","show":1},{"lid":"20180403YX004","date":"04-03","time":"20:00","sale_stop_at":"2018-04-03 19:55:00","status":1,"h_cn":"上海申花","a_cn":"鹿岛鹿角","show":1},{"lid":"20180403YX005","date":"04-03","time":"22:15","sale_stop_at":"2018-04-03 22:10:00","status":1,"h_cn":"扎巴汉","a_cn":"多哈杜海勒","show":1},{"lid":"20180403YX006","date":"04-03","time":"23:10","sale_stop_at":"2018-04-03 23:05:00","status":1,"h_cn":"阿布扎比瓦赫达","a_cn":"塔什干火车头","show":1},{"lid":"20180403YX007","date":"04-03","time":"23:30","sale_stop_at":"2018-04-03 23:25:00","status":1,"h_cn":"多哈加拉法","a_cn":"阿布扎比贾兹拉","show":1},{"lid":"20180403YX008","date":"04-04","time":"00:20","sale_stop_at":"2018-04-03 23:55:00","status":1,"h_cn":"吉达阿赫利","a_cn":"大不里士拖拉机","show":1},{"lid":"20180404YX001","date":"04-04","time":"18:00","sale_stop_at":"2018-04-04 17:55:00","status":1,"h_cn":"蔚山现代","a_cn":"墨尔本胜利","show":1},{"lid":"20180404YX010","date":"04-04","time":"18:30","sale_stop_at":"2018-04-04 18:25:00","status":1,"h_cn":"柏太阳神","a_cn":"全北现代","show":1},{"lid":"20180404YX011","date":"04-04","time":"20:00","sale_stop_at":"2018-04-04 19:55:00","status":1,"h_cn":"上海上港","a_cn":"川崎前锋","show":1},{"lid":"20180404YX012","date":"04-04","time":"20:00","sale_stop_at":"2018-04-04 19:55:00","status":1,"h_cn":"香港杰志","a_cn":"天津权健","show":1}]
         */

        private String l_cn;
        private int num;
        private List<DataBean> data;

        public String getL_cn() {
            return l_cn;
        }

        public void setL_cn(String l_cn) {
            this.l_cn = l_cn;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Serializable {
            /**
             * lid : 20180305YX001
             * date : 03-05
             * time : 05:30
             * sale_stop_at : 2018-03-05 05:25:00
             * status : 1
             * h_cn : 纳萨夫
             * a_cn : 多哈萨德
             * show : 1
             */

            private String lid;
            private String date;
            private String time;
            private String sale_stop_at;
            private int status;
            private String h_cn;
            private String a_cn;
            private int show;


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

            public String getSale_stop_at() {
                return sale_stop_at;
            }

            public void setSale_stop_at(String sale_stop_at) {
                this.sale_stop_at = sale_stop_at;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
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

            public int getShow() {
                return show;
            }

            public void setShow(int show) {
                this.show = show;
            }

        }
    }
}
