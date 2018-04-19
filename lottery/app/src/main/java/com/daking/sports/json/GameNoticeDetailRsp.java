package com.daking.sports.json;

/**
 * Description:
 * Data：2018/4/18-20:42
 * steven
 */
public class GameNoticeDetailRsp extends BaseModel {

    /**
     * data : {"lid":"64","category_id":"2","title":"【苹果活动】中秋佳节金苹果献好礼","content":"尊敬的客户&nbsp; 您好：中秋佳节来临之际，金苹果与您一同过中秋。在活动期间(9/18～9/27)，凡是有效投注流水满6000的客户，即可领取精美月饼一份。满足条件的客户即可向在线客服提交自己的联系方式与地址，我们会尽快将月饼送达您手中。【活动说明】1. 活动时间：2015/09/18&nbsp; 15：00：00 － 2015/09/27&nbsp; 23：59：592. 活动期间每人仅限领取一次月饼礼盒，恕不折抵彩金。更多精彩活动即将上线,敬请期待。永远新奇&nbsp; 值得期待 \u2013 金苹果2015年 09月 18日","created_at":"2015-09-18 15:00:31"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * lid : 64
         * category_id : 2
         * title : 【苹果活动】中秋佳节金苹果献好礼
         * content : 尊敬的客户&nbsp; 您好：中秋佳节来临之际，金苹果与您一同过中秋。在活动期间(9/18～9/27)，凡是有效投注流水满6000的客户，即可领取精美月饼一份。满足条件的客户即可向在线客服提交自己的联系方式与地址，我们会尽快将月饼送达您手中。【活动说明】1. 活动时间：2015/09/18&nbsp; 15：00：00 － 2015/09/27&nbsp; 23：59：592. 活动期间每人仅限领取一次月饼礼盒，恕不折抵彩金。更多精彩活动即将上线,敬请期待。永远新奇&nbsp; 值得期待 – 金苹果2015年 09月 18日
         * created_at : 2015-09-18 15:00:31
         */

        private String lid;
        private String category_id;
        private String title;
        private String content;
        private String created_at;

        public String getLid() {
            return lid;
        }

        public void setLid(String lid) {
            this.lid = lid;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }
}
