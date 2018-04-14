package com.daking.sports.json;

import java.util.List;

/**
 * Description:
 * Data：2018/4/14-14:19
 * steven
 */
public class AreaRsp extends BaseModel {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * province_id : 17
         * name : 四川
         * children : [{"id":387,"name":"南充"},{"id":397,"name":"凉山自治州"},{"id":396,"name":"甘孜自治州"},{"id":395,"name":"阿坝自治州"},{"id":394,"name":"资阳"},{"id":393,"name":"眉山"},{"id":392,"name":"雅安"},{"id":391,"name":"巴中"},{"id":390,"name":"达州"},{"id":389,"name":"广安"},{"id":388,"name":"宜宾"},{"id":377,"name":"成都"},{"id":386,"name":"乐山"},{"id":385,"name":"内江"},{"id":384,"name":"遂宁"},{"id":383,"name":"广元"},{"id":382,"name":"绵阳"},{"id":381,"name":"德阳"},{"id":380,"name":"泸州"},{"id":379,"name":"攀枝花"},{"id":378,"name":"自贡"}]
         */

        private String province_id;
        private String name;
        private List<ChildrenBean> children;

        public String getProvince_id() {
            return province_id;
        }

        public void setProvince_id(String province_id) {
            this.province_id = province_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * id : 387
             * name : 南充
             */

            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
