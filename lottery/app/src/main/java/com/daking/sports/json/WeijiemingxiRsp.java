package com.daking.sports.json;

import java.util.List;

/**
 * Description:
 * Data：2018/4/18-18:58
 * steven
 */
public class WeijiemingxiRsp extends BaseModel {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * lid : 17269
         * sn : C418331113314270
         * game_type : football
         * username : vitovito
         * multiple : 5
         * bet_num : 12
         * amount : 120.0000
         * tax : 0.0000
         * status : 等待出票
         * bought_at : 2018-04-18 14:31:51
         * gate : 混合过关[3x3]
         */

        private String lid;
        private String sn;
        private String game_type;
        private String username;
        private String multiple;
        private String bet_num;
        private String amount;
        private String tax;
        private String status;
        private String bought_at;
        private String gate;

        public String getLid() {
            return lid;
        }

        public void setLid(String lid) {
            this.lid = lid;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getGame_type() {
            return game_type;
        }

        public void setGame_type(String game_type) {
            this.game_type = game_type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMultiple() {
            return multiple;
        }

        public void setMultiple(String multiple) {
            this.multiple = multiple;
        }

        public String getBet_num() {
            return bet_num;
        }

        public void setBet_num(String bet_num) {
            this.bet_num = bet_num;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBought_at() {
            return bought_at;
        }

        public void setBought_at(String bought_at) {
            this.bought_at = bought_at;
        }

        public String getGate() {
            return gate;
        }

        public void setGate(String gate) {
            this.gate = gate;
        }
    }
}
