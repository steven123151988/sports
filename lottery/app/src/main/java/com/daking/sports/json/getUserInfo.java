package com.daking.sports.json;

/**
 * Description:获取当前用户详情
 * Data：2018/4/14-17:40
 * steven
 */
public class getUserInfo extends BaseModel {

    /**
     * data : {"id":"10","username":"toptop","is_agent":"1","account_id":"10","portrait_code":"6","name":"toptop","nickname":"t8888","email":"top@top.com","mobile":"","is_tester":"0","qq":"","skype":"","bet_coefficient":"1.000","login_ip":"192.168.254.108","signin_at":"2018-04-06 15:16:54","register_at":"2015-09-08 02:48:01","parent_id":"0","parent":"","forefather_ids":"","forefathers":"","prize_group":"0","blocked":"0","abalance":"17336914.7083","fund_pwd":"1","bank_num":"3"}
     */

    public DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 10
         * username : toptop
         * is_agent : 1
         * account_id : 10
         * portrait_code : 6
         * name : toptop
         * nickname : t8888
         * email : top@top.com
         * mobile :
         * is_tester : 0
         * qq :
         * skype :
         * bet_coefficient : 1.000
         * login_ip : 192.168.254.108
         * signin_at : 2018-04-06 15:16:54
         * register_at : 2015-09-08 02:48:01
         * parent_id : 0
         * parent :
         * forefather_ids :
         * forefathers :
         * prize_group : 0
         * blocked : 0
         * abalance : 17336914.7083
         * fund_pwd : 1
         * bank_num : 3
         */

        private String id;
        private String username;
        private String is_agent;
        private String account_id;
        private String portrait_code;
        private String name;
        private String nickname;
        private String email;
        private String mobile;
        private String is_tester;
        private String qq;
        private String skype;
        private String bet_coefficient;
        private String login_ip;
        private String signin_at;
        private String register_at;
        private String parent_id;
        private String parent;
        private String forefather_ids;
        private String forefathers;
        private String prize_group;
        private String blocked;
        private String abalance;
        private String fund_pwd;
        private String bank_num;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getIs_agent() {
            return is_agent;
        }

        public void setIs_agent(String is_agent) {
            this.is_agent = is_agent;
        }

        public String getAccount_id() {
            return account_id;
        }

        public void setAccount_id(String account_id) {
            this.account_id = account_id;
        }

        public String getPortrait_code() {
            return portrait_code;
        }

        public void setPortrait_code(String portrait_code) {
            this.portrait_code = portrait_code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getIs_tester() {
            return is_tester;
        }

        public void setIs_tester(String is_tester) {
            this.is_tester = is_tester;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getSkype() {
            return skype;
        }

        public void setSkype(String skype) {
            this.skype = skype;
        }

        public String getBet_coefficient() {
            return bet_coefficient;
        }

        public void setBet_coefficient(String bet_coefficient) {
            this.bet_coefficient = bet_coefficient;
        }

        public String getLogin_ip() {
            return login_ip;
        }

        public void setLogin_ip(String login_ip) {
            this.login_ip = login_ip;
        }

        public String getSignin_at() {
            return signin_at;
        }

        public void setSignin_at(String signin_at) {
            this.signin_at = signin_at;
        }

        public String getRegister_at() {
            return register_at;
        }

        public void setRegister_at(String register_at) {
            this.register_at = register_at;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getForefather_ids() {
            return forefather_ids;
        }

        public void setForefather_ids(String forefather_ids) {
            this.forefather_ids = forefather_ids;
        }

        public String getForefathers() {
            return forefathers;
        }

        public void setForefathers(String forefathers) {
            this.forefathers = forefathers;
        }

        public String getPrize_group() {
            return prize_group;
        }

        public void setPrize_group(String prize_group) {
            this.prize_group = prize_group;
        }

        public String getBlocked() {
            return blocked;
        }

        public void setBlocked(String blocked) {
            this.blocked = blocked;
        }

        public String getAbalance() {
            return abalance;
        }

        public void setAbalance(String abalance) {
            this.abalance = abalance;
        }

        public String getFund_pwd() {
            return fund_pwd;
        }

        public void setFund_pwd(String fund_pwd) {
            this.fund_pwd = fund_pwd;
        }

        public String getBank_num() {
            return bank_num;
        }

        public void setBank_num(String bank_num) {
            this.bank_num = bank_num;
        }
    }
}
