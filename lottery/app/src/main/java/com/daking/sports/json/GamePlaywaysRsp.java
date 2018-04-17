package com.daking.sports.json;

import java.util.List;

/**
 * Description:
 * Data：2018/4/9-16:54
 * steven
 */
public class GamePlaywaysRsp extends BaseModel {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * alias : 胜平负玩法
         * type : had
         * detail : [{"pre":"h","mp":"3.35","up":-1,"px":"h_3.35"},{"pre":"d","mp":"3.15","up":-1,"px":"d_3.15"},{"pre":"a","mp":"1.95","up":-1,"px":"a_1.95"}]
         */

        private String alias;
        private String type;
        private List<DetailBean> detail;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<DetailBean> getDetail() {
            return detail;
        }

        public void setDetail(List<DetailBean> detail) {
            this.detail = detail;
        }

        public static class DetailBean {
            /**
             * pre : h
             * mp : 3.35
             * up : -1
             * px : h_3.35
             */

            private String pre;
            private String mp;
            private int up;
            private String px;
            private String sc;

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getPre() {
                return pre;
            }

            public void setPre(String pre) {
                this.pre = pre;
            }

            public String getMp() {
                return mp;
            }

            public void setMp(String mp) {
                this.mp = mp;
            }

            public int getUp() {
                return up;
            }

            public void setUp(int up) {
                this.up = up;
            }

            public String getPx() {
                return px;
            }

            public void setPx(String px) {
                this.px = px;
            }
        }
    }
}
