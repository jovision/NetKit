package com.jovision.netkit.mvp.data.bean;

/**
 * Created by zhp on 2020/12/7
 */
public class CloudPowerBean {

    private String name;
    private int img;

    public CloudPowerBean(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
