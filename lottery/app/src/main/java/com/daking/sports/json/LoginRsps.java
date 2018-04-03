package com.daking.sports.json;

public class LoginRsps extends BaseModel{


    /**
     * errno : 0
     * error : null
     * data : {"id":10,"username":"toptop","is_agent":1,"account_id":10,"portrait_code":6,"name":"toptop","nickname":"t8888","email":"top@top.com","mobile":"","is_tester":0,"qq":"","skype":"","bet_coefficient":"1.000","login_ip":"192.168.254.108","signin_at":"2018-04-03 01:53:08","register_at":"2015-09-08 02:48:01","parent_id":0,"parent":null,"forefather_ids":null,"forefathers":null,"prize_group":"0","blocked":0,"abalance":"17337914.7083","token":"22441c03ade39bac8a561005edfe56be4f2d48f9"}
     * sign : 0150fc3b76d0a9e360c6d27b03634182
     */


    private DataBean data;
    private String sign;


    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
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
         * signin_at : 2018-04-03 01:53:08
         * register_at : 2015-09-08 02:48:01
         * parent_id : 0
         * parent : null
         * forefather_ids : null
         * forefathers : null
         * prize_group : 0
         * blocked : 0
         * abalance : 17337914.7083
         * token : 22441c03ade39bac8a561005edfe56be4f2d48f9
         */

        private int id;
        private String username;
        private int is_agent;
        private int account_id;
        private int portrait_code;
        private String name;
        private String nickname;
        private String email;
        private String mobile;
        private int is_tester;
        private String qq;
        private String skype;
        private String bet_coefficient;
        private String login_ip;
        private String signin_at;
        private String register_at;
        private int parent_id;
        private Object parent;
        private Object forefather_ids;
        private Object forefathers;
        private String prize_group;
        private int blocked;
        private String abalance;
        private String token;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getIs_agent() {
            return is_agent;
        }

        public void setIs_agent(int is_agent) {
            this.is_agent = is_agent;
        }

        public int getAccount_id() {
            return account_id;
        }

        public void setAccount_id(int account_id) {
            this.account_id = account_id;
        }

        public int getPortrait_code() {
            return portrait_code;
        }

        public void setPortrait_code(int portrait_code) {
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

        public int getIs_tester() {
            return is_tester;
        }

        public void setIs_tester(int is_tester) {
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

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public Object getParent() {
            return parent;
        }

        public void setParent(Object parent) {
            this.parent = parent;
        }

        public Object getForefather_ids() {
            return forefather_ids;
        }

        public void setForefather_ids(Object forefather_ids) {
            this.forefather_ids = forefather_ids;
        }

        public Object getForefathers() {
            return forefathers;
        }

        public void setForefathers(Object forefathers) {
            this.forefathers = forefathers;
        }

        public String getPrize_group() {
            return prize_group;
        }

        public void setPrize_group(String prize_group) {
            this.prize_group = prize_group;
        }

        public int getBlocked() {
            return blocked;
        }

        public void setBlocked(int blocked) {
            this.blocked = blocked;
        }

        public String getAbalance() {
            return abalance;
        }

        public void setAbalance(String abalance) {
            this.abalance = abalance;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
