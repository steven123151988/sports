package com.daking.sports.json;

import java.util.List;

/**
 * Description:
 * Data：2018/4/18-19:51
 * steven
 */
public class GameNoticeRsp extends BaseModel {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * lid : 68
         * title : 【网银维护】1001建行网银升级公告
         * created_at : 2015-10-01 16:24:57
         */

        private String lid;
        private String title;
        private String created_at;

        public String getLid() {
            return lid;
        }

        public void setLid(String lid) {
            this.lid = lid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }
}
