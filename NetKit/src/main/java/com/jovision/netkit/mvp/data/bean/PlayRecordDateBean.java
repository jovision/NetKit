package com.jovision.netkit.mvp.data.bean;

/**
 * Created by zhp on 2020/11/13
 */
public class PlayRecordDateBean {

    private String bitmap;//所传年月报警消息掩码（固定31位） 1-当天有报警消息 0-无报警消息

    public String getBitmap() {
        return bitmap;
    }

    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }
}
