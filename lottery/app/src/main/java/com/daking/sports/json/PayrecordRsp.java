package com.daking.sports.json;

import java.util.List;

/**
 * Description:
 * Data：2018/4/18-11:50
 * steven
 */
public class PayrecordRsp extends BaseModel {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * username : vito001
         * platform_identifier : GT
         * order_no : 7445895945ad598c38b073
         * created_at : 2018-04-17 14:48:35
         * amount : 503.00
         * status : 申请成功
         */

        private String username;
        private String platform_identifier;
        private String order_no;
        private String created_at;
        private String amount;
        private String status;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPlatform_identifier() {
            return platform_identifier;
        }

        public void setPlatform_identifier(String platform_identifier) {
            this.platform_identifier = platform_identifier;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
