package com.daking.sports.activity.money;

/**
 * Description:
 * Data：2018/4/16-19:07
 * steven
 */
class ProvinceBean {
  private int id;
  private String name;
    ProvinceBean(int id,String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
