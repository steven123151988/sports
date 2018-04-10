package com.daking.sports.json;

import java.util.List;

/**
 * Description:
 * Data：2018/4/9-16:54
 * steven
 */
public class GamePlaywaysRsp extends BaseModel {

    /**
     * data : {"wayOdds":[{"identity":"h","max_gate":8},{"identity":"d","max_gate":8},{"identity":"a","max_gate":8},{"identity":"ch","max_gate":8},{"identity":"cd","max_gate":8},{"identity":"ca","max_gate":8},{"identity":"hh","max_gate":4},{"identity":"hd","max_gate":4},{"identity":"ha","max_gate":4},{"identity":"dh","max_gate":4},{"identity":"dd","max_gate":4},{"identity":"da","max_gate":4},{"identity":"ah","max_gate":4},{"identity":"ad","max_gate":4},{"identity":"aa","max_gate":4},{"identity":"s0","max_gate":6},{"identity":"s1","max_gate":6},{"identity":"s2","max_gate":6},{"identity":"s3","max_gate":6},{"identity":"s4","max_gate":6},{"identity":"s5","max_gate":6},{"identity":"s6","max_gate":6},{"identity":"s7","max_gate":6},{"identity":"0100","max_gate":4},{"identity":"0200","max_gate":4},{"identity":"0201","max_gate":4},{"identity":"0300","max_gate":4},{"identity":"0301","max_gate":4},{"identity":"0302","max_gate":4},{"identity":"0400","max_gate":4},{"identity":"0401","max_gate":4},{"identity":"0402","max_gate":4},{"identity":"0500","max_gate":4},{"identity":"0501","max_gate":4},{"identity":"0502","max_gate":4},{"identity":"-1-h","max_gate":4},{"identity":"0000","max_gate":4},{"identity":"0101","max_gate":4},{"identity":"0202","max_gate":4},{"identity":"0303","max_gate":4},{"identity":"-1-d","max_gate":4},{"identity":"0001","max_gate":4},{"identity":"0002","max_gate":4},{"identity":"0102","max_gate":4},{"identity":"0003","max_gate":4},{"identity":"0103","max_gate":4},{"identity":"0203","max_gate":4},{"identity":"0004","max_gate":4},{"identity":"0104","max_gate":4},{"identity":"0204","max_gate":4},{"identity":"0005","max_gate":4},{"identity":"0105","max_gate":4},{"identity":"0205","max_gate":4},{"identity":"-1-a","max_gate":4},{"identity":"chp","max_gate":1},{"identity":"fnl","max_gate":1},{"identity":"bkh","max_gate":8},{"identity":"bka","max_gate":8},{"identity":"bkhh","max_gate":8},{"identity":"bkha","max_gate":8},{"identity":"bkw1","max_gate":4},{"identity":"bkw2","max_gate":4},{"identity":"bkw3","max_gate":4},{"identity":"bkw4","max_gate":4},{"identity":"bkw5","max_gate":4},{"identity":"bkw6","max_gate":4},{"identity":"bkl1","max_gate":4},{"identity":"bkl2","max_gate":4},{"identity":"bkl3","max_gate":4},{"identity":"bkl4","max_gate":4},{"identity":"bkl5","max_gate":4},{"identity":"bkl6","max_gate":4},{"identity":"bkbsh","max_gate":8},{"identity":"bkbsl","max_gate":8}],"lid":"20180410YX003","lottery":{"had":{"h":{"mp":"4.25","up":-1,"px":"h_4.25"},"d":{"mp":"4.05","up":-1,"px":"d_4.05"},"a":{"mp":"1.55","up":-1,"px":"a_1.55"}},"hhad":{"h":{"mp":"2.15","up":-1,"px":"ch_2.15"},"d":{"mp":"3.60","up":-1,"px":"cd_3.60"},"a":{"mp":"2.59","up":-1,"px":"ca_2.59"},"fixed":"1"},"ttg":{"s0":{"mp":"19.00","up":-1,"px":"s0_19.00"},"s1":{"mp":"6.50","up":-1,"px":"s1_6.50"},"s2":{"mp":"3.80","up":-1,"px":"s2_3.80"},"s3":{"mp":"3.70","up":-1,"px":"s3_3.70"},"s4":{"mp":"4.30","up":-1,"px":"s4_4.30"},"s5":{"mp":"6.10","up":-1,"px":"s5_6.10"},"s6":{"mp":"9.75","up":-1,"px":"s6_9.75"},"s7":{"mp":"13.50","up":-1,"px":"s7_13.50"}},"hafu":{"hh":{"mp":"6.50","up":-1,"px":"hh_6.50"},"hd":{"mp":"13.00","up":-1,"px":"hd_13.00"},"ha":{"mp":"19.00","up":-1,"px":"ha_19.00"},"dh":{"mp":"10.50","up":-1,"px":"dh_10.50"},"dd":{"mp":"7.00","up":-1,"px":"dd_7.00"},"da":{"mp":"4.80","up":-1,"px":"da_4.80"},"ah":{"mp":"33.00","up":-1,"px":"ah_33.00"},"ad":{"mp":"13.00","up":-1,"px":"ad_13.00"},"aa":{"mp":"2.10","up":-1,"px":"aa_2.10"}},"crs":{"h":[{"sc":"1:0","up":"16.00","mp":-1,"px":"0100_16.00"},{"sc":"2:0","up":"25.00","mp":-1,"px":"0200_25.00"},{"sc":"2:1","up":"12.00","mp":-1,"px":"0201_12.00"},{"sc":"3:0","up":"50.00","mp":-1,"px":"0300_50.00"},{"sc":"3:1","up":"30.00","mp":-1,"px":"0301_30.00"},{"sc":"3:2","up":"25.00","mp":-1,"px":"0302_25.00"},{"sc":"4:0","up":"150.00","mp":-1,"px":"0400_150.00"},{"sc":"4:1","up":"80.00","mp":-1,"px":"0401_80.00"},{"sc":"4:2","up":"70.00","mp":-1,"px":"0402_70.00"},{"sc":"5:0","up":"300.00","mp":-1,"px":"0500_300.00"},{"sc":"5:1","up":"250.00","mp":-1,"px":"0501_250.00"},{"sc":"5:2","up":"250.00","mp":-1,"px":"0502_250.00"},{"sc":"胜其它","up":"70.00","mp":-1,"px":"-1-h_70.00"}],"d":[{"sc":"0:0","up":"19.00","mp":-1,"px":"0000_19.00"},{"sc":"1:1","up":"8.00","mp":-1,"px":"0101_8.00"},{"sc":"2:2","up":"11.50","mp":-1,"px":"0202_11.50"},{"sc":"3:3","up":"35.00","mp":-1,"px":"0303_35.00"},{"sc":"平其它","up":"125.00","mp":-1,"px":"-1-d_125.00"}],"a":[{"sc":"0:1","up":"9.00","mp":-1,"px":"0001_9.00"},{"sc":"0:2","up":"9.50","mp":-1,"px":"0002_9.50"},{"sc":"1:2","up":"7.25","mp":-1,"px":"0102_7.25"},{"sc":"1:3","up":"11.00","mp":-1,"px":"0103_11.00"},{"sc":"2:3","up":"16.00","mp":-1,"px":"0203_16.00"},{"sc":"0:4","up":"23.00","mp":-1,"px":"0004_23.00"},{"sc":"1:4","up":"20.00","mp":-1,"px":"0104_20.00"},{"sc":"2:4","up":"30.00","mp":-1,"px":"0204_30.00"},{"sc":"0:5","up":"50.00","mp":-1,"px":"0005_50.00"},{"sc":"1:5","up":"40.00","mp":-1,"px":"0105_40.00"},{"sc":"2:5","up":"60.00","mp":-1,"px":"0205_60.00"},{"sc":"负其它","up":"22.00","mp":-1,"px":"-1-a_22.00"}]}}}
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
         * wayOdds : [{"identity":"h","max_gate":8},{"identity":"d","max_gate":8},{"identity":"a","max_gate":8},{"identity":"ch","max_gate":8},{"identity":"cd","max_gate":8},{"identity":"ca","max_gate":8},{"identity":"hh","max_gate":4},{"identity":"hd","max_gate":4},{"identity":"ha","max_gate":4},{"identity":"dh","max_gate":4},{"identity":"dd","max_gate":4},{"identity":"da","max_gate":4},{"identity":"ah","max_gate":4},{"identity":"ad","max_gate":4},{"identity":"aa","max_gate":4},{"identity":"s0","max_gate":6},{"identity":"s1","max_gate":6},{"identity":"s2","max_gate":6},{"identity":"s3","max_gate":6},{"identity":"s4","max_gate":6},{"identity":"s5","max_gate":6},{"identity":"s6","max_gate":6},{"identity":"s7","max_gate":6},{"identity":"0100","max_gate":4},{"identity":"0200","max_gate":4},{"identity":"0201","max_gate":4},{"identity":"0300","max_gate":4},{"identity":"0301","max_gate":4},{"identity":"0302","max_gate":4},{"identity":"0400","max_gate":4},{"identity":"0401","max_gate":4},{"identity":"0402","max_gate":4},{"identity":"0500","max_gate":4},{"identity":"0501","max_gate":4},{"identity":"0502","max_gate":4},{"identity":"-1-h","max_gate":4},{"identity":"0000","max_gate":4},{"identity":"0101","max_gate":4},{"identity":"0202","max_gate":4},{"identity":"0303","max_gate":4},{"identity":"-1-d","max_gate":4},{"identity":"0001","max_gate":4},{"identity":"0002","max_gate":4},{"identity":"0102","max_gate":4},{"identity":"0003","max_gate":4},{"identity":"0103","max_gate":4},{"identity":"0203","max_gate":4},{"identity":"0004","max_gate":4},{"identity":"0104","max_gate":4},{"identity":"0204","max_gate":4},{"identity":"0005","max_gate":4},{"identity":"0105","max_gate":4},{"identity":"0205","max_gate":4},{"identity":"-1-a","max_gate":4},{"identity":"chp","max_gate":1},{"identity":"fnl","max_gate":1},{"identity":"bkh","max_gate":8},{"identity":"bka","max_gate":8},{"identity":"bkhh","max_gate":8},{"identity":"bkha","max_gate":8},{"identity":"bkw1","max_gate":4},{"identity":"bkw2","max_gate":4},{"identity":"bkw3","max_gate":4},{"identity":"bkw4","max_gate":4},{"identity":"bkw5","max_gate":4},{"identity":"bkw6","max_gate":4},{"identity":"bkl1","max_gate":4},{"identity":"bkl2","max_gate":4},{"identity":"bkl3","max_gate":4},{"identity":"bkl4","max_gate":4},{"identity":"bkl5","max_gate":4},{"identity":"bkl6","max_gate":4},{"identity":"bkbsh","max_gate":8},{"identity":"bkbsl","max_gate":8}]
         * lid : 20180410YX003
         * lottery : {"had":{"h":{"mp":"4.25","up":-1,"px":"h_4.25"},"d":{"mp":"4.05","up":-1,"px":"d_4.05"},"a":{"mp":"1.55","up":-1,"px":"a_1.55"}},"hhad":{"h":{"mp":"2.15","up":-1,"px":"ch_2.15"},"d":{"mp":"3.60","up":-1,"px":"cd_3.60"},"a":{"mp":"2.59","up":-1,"px":"ca_2.59"},"fixed":"1"},"ttg":{"s0":{"mp":"19.00","up":-1,"px":"s0_19.00"},"s1":{"mp":"6.50","up":-1,"px":"s1_6.50"},"s2":{"mp":"3.80","up":-1,"px":"s2_3.80"},"s3":{"mp":"3.70","up":-1,"px":"s3_3.70"},"s4":{"mp":"4.30","up":-1,"px":"s4_4.30"},"s5":{"mp":"6.10","up":-1,"px":"s5_6.10"},"s6":{"mp":"9.75","up":-1,"px":"s6_9.75"},"s7":{"mp":"13.50","up":-1,"px":"s7_13.50"}},"hafu":{"hh":{"mp":"6.50","up":-1,"px":"hh_6.50"},"hd":{"mp":"13.00","up":-1,"px":"hd_13.00"},"ha":{"mp":"19.00","up":-1,"px":"ha_19.00"},"dh":{"mp":"10.50","up":-1,"px":"dh_10.50"},"dd":{"mp":"7.00","up":-1,"px":"dd_7.00"},"da":{"mp":"4.80","up":-1,"px":"da_4.80"},"ah":{"mp":"33.00","up":-1,"px":"ah_33.00"},"ad":{"mp":"13.00","up":-1,"px":"ad_13.00"},"aa":{"mp":"2.10","up":-1,"px":"aa_2.10"}},"crs":{"h":[{"sc":"1:0","up":"16.00","mp":-1,"px":"0100_16.00"},{"sc":"2:0","up":"25.00","mp":-1,"px":"0200_25.00"},{"sc":"2:1","up":"12.00","mp":-1,"px":"0201_12.00"},{"sc":"3:0","up":"50.00","mp":-1,"px":"0300_50.00"},{"sc":"3:1","up":"30.00","mp":-1,"px":"0301_30.00"},{"sc":"3:2","up":"25.00","mp":-1,"px":"0302_25.00"},{"sc":"4:0","up":"150.00","mp":-1,"px":"0400_150.00"},{"sc":"4:1","up":"80.00","mp":-1,"px":"0401_80.00"},{"sc":"4:2","up":"70.00","mp":-1,"px":"0402_70.00"},{"sc":"5:0","up":"300.00","mp":-1,"px":"0500_300.00"},{"sc":"5:1","up":"250.00","mp":-1,"px":"0501_250.00"},{"sc":"5:2","up":"250.00","mp":-1,"px":"0502_250.00"},{"sc":"胜其它","up":"70.00","mp":-1,"px":"-1-h_70.00"}],"d":[{"sc":"0:0","up":"19.00","mp":-1,"px":"0000_19.00"},{"sc":"1:1","up":"8.00","mp":-1,"px":"0101_8.00"},{"sc":"2:2","up":"11.50","mp":-1,"px":"0202_11.50"},{"sc":"3:3","up":"35.00","mp":-1,"px":"0303_35.00"},{"sc":"平其它","up":"125.00","mp":-1,"px":"-1-d_125.00"}],"a":[{"sc":"0:1","up":"9.00","mp":-1,"px":"0001_9.00"},{"sc":"0:2","up":"9.50","mp":-1,"px":"0002_9.50"},{"sc":"1:2","up":"7.25","mp":-1,"px":"0102_7.25"},{"sc":"1:3","up":"11.00","mp":-1,"px":"0103_11.00"},{"sc":"2:3","up":"16.00","mp":-1,"px":"0203_16.00"},{"sc":"0:4","up":"23.00","mp":-1,"px":"0004_23.00"},{"sc":"1:4","up":"20.00","mp":-1,"px":"0104_20.00"},{"sc":"2:4","up":"30.00","mp":-1,"px":"0204_30.00"},{"sc":"0:5","up":"50.00","mp":-1,"px":"0005_50.00"},{"sc":"1:5","up":"40.00","mp":-1,"px":"0105_40.00"},{"sc":"2:5","up":"60.00","mp":-1,"px":"0205_60.00"},{"sc":"负其它","up":"22.00","mp":-1,"px":"-1-a_22.00"}]}}
         */

        private String lid;
        private LotteryBean lottery;
        private List<WayOddsBean> wayOdds;

        public String getLid() {
            return lid;
        }

        public void setLid(String lid) {
            this.lid = lid;
        }

        public LotteryBean getLottery() {
            return lottery;
        }

        public void setLottery(LotteryBean lottery) {
            this.lottery = lottery;
        }

        public List<WayOddsBean> getWayOdds() {
            return wayOdds;
        }

        public void setWayOdds(List<WayOddsBean> wayOdds) {
            this.wayOdds = wayOdds;
        }

        public static class LotteryBean {
            /**
             * had : {"h":{"mp":"4.25","up":-1,"px":"h_4.25"},"d":{"mp":"4.05","up":-1,"px":"d_4.05"},"a":{"mp":"1.55","up":-1,"px":"a_1.55"}}
             * hhad : {"h":{"mp":"2.15","up":-1,"px":"ch_2.15"},"d":{"mp":"3.60","up":-1,"px":"cd_3.60"},"a":{"mp":"2.59","up":-1,"px":"ca_2.59"},"fixed":"1"}
             * ttg : {"s0":{"mp":"19.00","up":-1,"px":"s0_19.00"},"s1":{"mp":"6.50","up":-1,"px":"s1_6.50"},"s2":{"mp":"3.80","up":-1,"px":"s2_3.80"},"s3":{"mp":"3.70","up":-1,"px":"s3_3.70"},"s4":{"mp":"4.30","up":-1,"px":"s4_4.30"},"s5":{"mp":"6.10","up":-1,"px":"s5_6.10"},"s6":{"mp":"9.75","up":-1,"px":"s6_9.75"},"s7":{"mp":"13.50","up":-1,"px":"s7_13.50"}}
             * hafu : {"hh":{"mp":"6.50","up":-1,"px":"hh_6.50"},"hd":{"mp":"13.00","up":-1,"px":"hd_13.00"},"ha":{"mp":"19.00","up":-1,"px":"ha_19.00"},"dh":{"mp":"10.50","up":-1,"px":"dh_10.50"},"dd":{"mp":"7.00","up":-1,"px":"dd_7.00"},"da":{"mp":"4.80","up":-1,"px":"da_4.80"},"ah":{"mp":"33.00","up":-1,"px":"ah_33.00"},"ad":{"mp":"13.00","up":-1,"px":"ad_13.00"},"aa":{"mp":"2.10","up":-1,"px":"aa_2.10"}}
             * crs : {"h":[{"sc":"1:0","up":"16.00","mp":-1,"px":"0100_16.00"},{"sc":"2:0","up":"25.00","mp":-1,"px":"0200_25.00"},{"sc":"2:1","up":"12.00","mp":-1,"px":"0201_12.00"},{"sc":"3:0","up":"50.00","mp":-1,"px":"0300_50.00"},{"sc":"3:1","up":"30.00","mp":-1,"px":"0301_30.00"},{"sc":"3:2","up":"25.00","mp":-1,"px":"0302_25.00"},{"sc":"4:0","up":"150.00","mp":-1,"px":"0400_150.00"},{"sc":"4:1","up":"80.00","mp":-1,"px":"0401_80.00"},{"sc":"4:2","up":"70.00","mp":-1,"px":"0402_70.00"},{"sc":"5:0","up":"300.00","mp":-1,"px":"0500_300.00"},{"sc":"5:1","up":"250.00","mp":-1,"px":"0501_250.00"},{"sc":"5:2","up":"250.00","mp":-1,"px":"0502_250.00"},{"sc":"胜其它","up":"70.00","mp":-1,"px":"-1-h_70.00"}],"d":[{"sc":"0:0","up":"19.00","mp":-1,"px":"0000_19.00"},{"sc":"1:1","up":"8.00","mp":-1,"px":"0101_8.00"},{"sc":"2:2","up":"11.50","mp":-1,"px":"0202_11.50"},{"sc":"3:3","up":"35.00","mp":-1,"px":"0303_35.00"},{"sc":"平其它","up":"125.00","mp":-1,"px":"-1-d_125.00"}],"a":[{"sc":"0:1","up":"9.00","mp":-1,"px":"0001_9.00"},{"sc":"0:2","up":"9.50","mp":-1,"px":"0002_9.50"},{"sc":"1:2","up":"7.25","mp":-1,"px":"0102_7.25"},{"sc":"1:3","up":"11.00","mp":-1,"px":"0103_11.00"},{"sc":"2:3","up":"16.00","mp":-1,"px":"0203_16.00"},{"sc":"0:4","up":"23.00","mp":-1,"px":"0004_23.00"},{"sc":"1:4","up":"20.00","mp":-1,"px":"0104_20.00"},{"sc":"2:4","up":"30.00","mp":-1,"px":"0204_30.00"},{"sc":"0:5","up":"50.00","mp":-1,"px":"0005_50.00"},{"sc":"1:5","up":"40.00","mp":-1,"px":"0105_40.00"},{"sc":"2:5","up":"60.00","mp":-1,"px":"0205_60.00"},{"sc":"负其它","up":"22.00","mp":-1,"px":"-1-a_22.00"}]}
             */

            private HadBean had;
            private HhadBean hhad;
            private TtgBean ttg;
            private HafuBean hafu;
            private CrsBean crs;

            public HadBean getHad() {
                return had;
            }

            public void setHad(HadBean had) {
                this.had = had;
            }

            public HhadBean getHhad() {
                return hhad;
            }

            public void setHhad(HhadBean hhad) {
                this.hhad = hhad;
            }

            public TtgBean getTtg() {
                return ttg;
            }

            public void setTtg(TtgBean ttg) {
                this.ttg = ttg;
            }

            public HafuBean getHafu() {
                return hafu;
            }

            public void setHafu(HafuBean hafu) {
                this.hafu = hafu;
            }

            public CrsBean getCrs() {
                return crs;
            }

            public void setCrs(CrsBean crs) {
                this.crs = crs;
            }

            public static class HadBean {
                /**
                 * h : {"mp":"4.25","up":-1,"px":"h_4.25"}
                 * d : {"mp":"4.05","up":-1,"px":"d_4.05"}
                 * a : {"mp":"1.55","up":-1,"px":"a_1.55"}
                 */

                private HBean h;
                private DBean d;
                private ABean a;

                public HBean getH() {
                    return h;
                }

                public void setH(HBean h) {
                    this.h = h;
                }

                public DBean getD() {
                    return d;
                }

                public void setD(DBean d) {
                    this.d = d;
                }

                public ABean getA() {
                    return a;
                }

                public void setA(ABean a) {
                    this.a = a;
                }

                public static class HBean {
                    /**
                     * mp : 4.25
                     * up : -1
                     * px : h_4.25
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class DBean {
                    /**
                     * mp : 4.05
                     * up : -1
                     * px : d_4.05
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class ABean {
                    /**
                     * mp : 1.55
                     * up : -1
                     * px : a_1.55
                     */

                    private String mp;
                    private int up;
                    private String px;

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

            public static class HhadBean {
                /**
                 * h : {"mp":"2.15","up":-1,"px":"ch_2.15"}
                 * d : {"mp":"3.60","up":-1,"px":"cd_3.60"}
                 * a : {"mp":"2.59","up":-1,"px":"ca_2.59"}
                 * fixed : 1
                 */

                private HBeanX h;
                private DBeanX d;
                private ABeanX a;
                private String fixed;

                public HBeanX getH() {
                    return h;
                }

                public void setH(HBeanX h) {
                    this.h = h;
                }

                public DBeanX getD() {
                    return d;
                }

                public void setD(DBeanX d) {
                    this.d = d;
                }

                public ABeanX getA() {
                    return a;
                }

                public void setA(ABeanX a) {
                    this.a = a;
                }

                public String getFixed() {
                    return fixed;
                }

                public void setFixed(String fixed) {
                    this.fixed = fixed;
                }

                public static class HBeanX {
                    /**
                     * mp : 2.15
                     * up : -1
                     * px : ch_2.15
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class DBeanX {
                    /**
                     * mp : 3.60
                     * up : -1
                     * px : cd_3.60
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class ABeanX {
                    /**
                     * mp : 2.59
                     * up : -1
                     * px : ca_2.59
                     */

                    private String mp;
                    private int up;
                    private String px;

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

            public static class TtgBean {
                /**
                 * s0 : {"mp":"19.00","up":-1,"px":"s0_19.00"}
                 * s1 : {"mp":"6.50","up":-1,"px":"s1_6.50"}
                 * s2 : {"mp":"3.80","up":-1,"px":"s2_3.80"}
                 * s3 : {"mp":"3.70","up":-1,"px":"s3_3.70"}
                 * s4 : {"mp":"4.30","up":-1,"px":"s4_4.30"}
                 * s5 : {"mp":"6.10","up":-1,"px":"s5_6.10"}
                 * s6 : {"mp":"9.75","up":-1,"px":"s6_9.75"}
                 * s7 : {"mp":"13.50","up":-1,"px":"s7_13.50"}
                 */

                private S0Bean s0;
                private S1Bean s1;
                private S2Bean s2;
                private S3Bean s3;
                private S4Bean s4;
                private S5Bean s5;
                private S6Bean s6;
                private S7Bean s7;

                public S0Bean getS0() {
                    return s0;
                }

                public void setS0(S0Bean s0) {
                    this.s0 = s0;
                }

                public S1Bean getS1() {
                    return s1;
                }

                public void setS1(S1Bean s1) {
                    this.s1 = s1;
                }

                public S2Bean getS2() {
                    return s2;
                }

                public void setS2(S2Bean s2) {
                    this.s2 = s2;
                }

                public S3Bean getS3() {
                    return s3;
                }

                public void setS3(S3Bean s3) {
                    this.s3 = s3;
                }

                public S4Bean getS4() {
                    return s4;
                }

                public void setS4(S4Bean s4) {
                    this.s4 = s4;
                }

                public S5Bean getS5() {
                    return s5;
                }

                public void setS5(S5Bean s5) {
                    this.s5 = s5;
                }

                public S6Bean getS6() {
                    return s6;
                }

                public void setS6(S6Bean s6) {
                    this.s6 = s6;
                }

                public S7Bean getS7() {
                    return s7;
                }

                public void setS7(S7Bean s7) {
                    this.s7 = s7;
                }

                public static class S0Bean {
                    /**
                     * mp : 19.00
                     * up : -1
                     * px : s0_19.00
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class S1Bean {
                    /**
                     * mp : 6.50
                     * up : -1
                     * px : s1_6.50
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class S2Bean {
                    /**
                     * mp : 3.80
                     * up : -1
                     * px : s2_3.80
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class S3Bean {
                    /**
                     * mp : 3.70
                     * up : -1
                     * px : s3_3.70
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class S4Bean {
                    /**
                     * mp : 4.30
                     * up : -1
                     * px : s4_4.30
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class S5Bean {
                    /**
                     * mp : 6.10
                     * up : -1
                     * px : s5_6.10
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class S6Bean {
                    /**
                     * mp : 9.75
                     * up : -1
                     * px : s6_9.75
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class S7Bean {
                    /**
                     * mp : 13.50
                     * up : -1
                     * px : s7_13.50
                     */

                    private String mp;
                    private int up;
                    private String px;

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

            public static class HafuBean {
                /**
                 * hh : {"mp":"6.50","up":-1,"px":"hh_6.50"}
                 * hd : {"mp":"13.00","up":-1,"px":"hd_13.00"}
                 * ha : {"mp":"19.00","up":-1,"px":"ha_19.00"}
                 * dh : {"mp":"10.50","up":-1,"px":"dh_10.50"}
                 * dd : {"mp":"7.00","up":-1,"px":"dd_7.00"}
                 * da : {"mp":"4.80","up":-1,"px":"da_4.80"}
                 * ah : {"mp":"33.00","up":-1,"px":"ah_33.00"}
                 * ad : {"mp":"13.00","up":-1,"px":"ad_13.00"}
                 * aa : {"mp":"2.10","up":-1,"px":"aa_2.10"}
                 */

                private HhBean hh;
                private HdBean hd;
                private HaBean ha;
                private DhBean dh;
                private DdBean dd;
                private DaBean da;
                private AhBean ah;
                private AdBean ad;
                private AaBean aa;

                public HhBean getHh() {
                    return hh;
                }

                public void setHh(HhBean hh) {
                    this.hh = hh;
                }

                public HdBean getHd() {
                    return hd;
                }

                public void setHd(HdBean hd) {
                    this.hd = hd;
                }

                public HaBean getHa() {
                    return ha;
                }

                public void setHa(HaBean ha) {
                    this.ha = ha;
                }

                public DhBean getDh() {
                    return dh;
                }

                public void setDh(DhBean dh) {
                    this.dh = dh;
                }

                public DdBean getDd() {
                    return dd;
                }

                public void setDd(DdBean dd) {
                    this.dd = dd;
                }

                public DaBean getDa() {
                    return da;
                }

                public void setDa(DaBean da) {
                    this.da = da;
                }

                public AhBean getAh() {
                    return ah;
                }

                public void setAh(AhBean ah) {
                    this.ah = ah;
                }

                public AdBean getAd() {
                    return ad;
                }

                public void setAd(AdBean ad) {
                    this.ad = ad;
                }

                public AaBean getAa() {
                    return aa;
                }

                public void setAa(AaBean aa) {
                    this.aa = aa;
                }

                public static class HhBean {
                    /**
                     * mp : 6.50
                     * up : -1
                     * px : hh_6.50
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class HdBean {
                    /**
                     * mp : 13.00
                     * up : -1
                     * px : hd_13.00
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class HaBean {
                    /**
                     * mp : 19.00
                     * up : -1
                     * px : ha_19.00
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class DhBean {
                    /**
                     * mp : 10.50
                     * up : -1
                     * px : dh_10.50
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class DdBean {
                    /**
                     * mp : 7.00
                     * up : -1
                     * px : dd_7.00
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class DaBean {
                    /**
                     * mp : 4.80
                     * up : -1
                     * px : da_4.80
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class AhBean {
                    /**
                     * mp : 33.00
                     * up : -1
                     * px : ah_33.00
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class AdBean {
                    /**
                     * mp : 13.00
                     * up : -1
                     * px : ad_13.00
                     */

                    private String mp;
                    private int up;
                    private String px;

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

                public static class AaBean {
                    /**
                     * mp : 2.10
                     * up : -1
                     * px : aa_2.10
                     */

                    private String mp;
                    private int up;
                    private String px;

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

            public static class CrsBean {
                private List<HBeanXX> h;
                private List<DBeanXX> d;
                private List<ABeanXX> a;

                public List<HBeanXX> getH() {
                    return h;
                }

                public void setH(List<HBeanXX> h) {
                    this.h = h;
                }

                public List<DBeanXX> getD() {
                    return d;
                }

                public void setD(List<DBeanXX> d) {
                    this.d = d;
                }

                public List<ABeanXX> getA() {
                    return a;
                }

                public void setA(List<ABeanXX> a) {
                    this.a = a;
                }

                public static class HBeanXX {
                    /**
                     * sc : 1:0
                     * up : 16.00
                     * mp : -1
                     * px : 0100_16.00
                     */

                    private String sc;
                    private String up;
                    private int mp;
                    private String px;

                    public String getSc() {
                        return sc;
                    }

                    public void setSc(String sc) {
                        this.sc = sc;
                    }

                    public String getUp() {
                        return up;
                    }

                    public void setUp(String up) {
                        this.up = up;
                    }

                    public int getMp() {
                        return mp;
                    }

                    public void setMp(int mp) {
                        this.mp = mp;
                    }

                    public String getPx() {
                        return px;
                    }

                    public void setPx(String px) {
                        this.px = px;
                    }
                }

                public static class DBeanXX {
                    /**
                     * sc : 0:0
                     * up : 19.00
                     * mp : -1
                     * px : 0000_19.00
                     */

                    private String sc;
                    private String up;
                    private int mp;
                    private String px;

                    public String getSc() {
                        return sc;
                    }

                    public void setSc(String sc) {
                        this.sc = sc;
                    }

                    public String getUp() {
                        return up;
                    }

                    public void setUp(String up) {
                        this.up = up;
                    }

                    public int getMp() {
                        return mp;
                    }

                    public void setMp(int mp) {
                        this.mp = mp;
                    }

                    public String getPx() {
                        return px;
                    }

                    public void setPx(String px) {
                        this.px = px;
                    }
                }

                public static class ABeanXX {
                    /**
                     * sc : 0:1
                     * up : 9.00
                     * mp : -1
                     * px : 0001_9.00
                     */

                    private String sc;
                    private String up;
                    private int mp;
                    private String px;

                    public String getSc() {
                        return sc;
                    }

                    public void setSc(String sc) {
                        this.sc = sc;
                    }

                    public String getUp() {
                        return up;
                    }

                    public void setUp(String up) {
                        this.up = up;
                    }

                    public int getMp() {
                        return mp;
                    }

                    public void setMp(int mp) {
                        this.mp = mp;
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

        public static class WayOddsBean {
            /**
             * identity : h
             * max_gate : 8
             */

            private String identity;
            private int max_gate;

            public String getIdentity() {
                return identity;
            }

            public void setIdentity(String identity) {
                this.identity = identity;
            }

            public int getMax_gate() {
                return max_gate;
            }

            public void setMax_gate(int max_gate) {
                this.max_gate = max_gate;
            }
        }
    }
}
