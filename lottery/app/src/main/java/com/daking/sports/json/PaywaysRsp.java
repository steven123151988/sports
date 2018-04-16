package com.daking.sports.json;

import java.util.List;

/**
 * Description:
 * Data：2018/4/16-18:42
 * steven
 */
public class PaywaysRsp extends BaseModel {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : 银行
         * subset : [{"name":"工商银行","mark":"ICBC"},{"name":"农业银行","mark":"ABC"},{"name":"建设银行","mark":"CCB"},{"name":"中国银行","mark":"BOC"},{"name":"招商银行","mark":"CMB"},{"name":"北京银行","mark":"BCCB"},{"name":"交通银行","mark":"BOCO"},{"name":"兴业银行","mark":"CIB"},{"name":"南京银行","mark":"NJCB"},{"name":"民生银行","mark":"CMBC"},{"name":"光大银行","mark":"CEB"},{"name":"平安银行","mark":"PINGANBANK"},{"name":"渤海银行","mark":"CBHB"},{"name":"东亚银行","mark":"HKBEA"},{"name":"宁波银行","mark":"NBCB"},{"name":"中信银行","mark":"CTTIC"},{"name":"广发银行","mark":"GDB"},{"name":"上海银行","mark":"SHB"},{"name":"上海浦东发展银行","mark":"SPDB"},{"name":"中国邮政","mark":"PSBS"},{"name":"华夏银行","mark":"HXB"},{"name":"北京农村商业银行","mark":"BJRCB"},{"name":"上海农商银行","mark":"SRCB"},{"name":"深圳发展银行","mark":"SDB"},{"name":"浙江稠州商业银行","mark":"CZB"},{"name":"京东扫码","mark":"JDPAY"}]
         */

        private String type;
        private List<SubsetBean> subset;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<SubsetBean> getSubset() {
            return subset;
        }

        public void setSubset(List<SubsetBean> subset) {
            this.subset = subset;
        }

        public static class SubsetBean {
            /**
             * name : 工商银行
             * mark : ICBC
             */

            private String name;
            private String mark;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }
        }
    }
}
