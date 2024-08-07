package com.jovision.netkit.mvp.data.bean;

public class AlarmSound {

    private int index = 0;//报警音index
    private String alarmTitle = "";//报警文件名称,文件名称，不允许重复;对应file_name字段，老协议展示这个字段；新老协议发命令用此字段
    private String fileIntro = "";//报警文件名称,文件名称，不允许重复;对应file_intro字段，新协议展示这个字段，此字段仅用于展示


    private String alarmFilePath = "";//报警文件路径
    private boolean isDiy = false;//是否自定义音频，等同于bModify  true就是自定义，可修改    false系统的，不可修改
    private String alarmDetail = "";//报警描述

    //以下是存在设备端的报警音的三个字段
    private String fileType = "";//编码格式，目前只支持pcm格式
    private int fileSize;//文件大小
    private boolean bModify = false;//是否可删除（true:可以删除；false:不可删除）

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAlarmTitle() {
        return alarmTitle;
    }

    public void setAlarmTitle(String alarmTitle) {
        this.alarmTitle = alarmTitle;
    }

    public String getAlarmFilePath() {
        return alarmFilePath;
    }

    public void setAlarmFilePath(String alarmFilePath) {
        this.alarmFilePath = alarmFilePath;
    }

    public boolean isDiy() {
        return isDiy;
    }

    public void setDiy(boolean diy) {
        isDiy = diy;
    }

    public String getAlarmDetail() {
        return alarmDetail;
    }

    public void setAlarmDetail(String alarmDetail) {
        this.alarmDetail = alarmDetail;
    }


    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public boolean isbModify() {
        return bModify;
    }

    public void setbModify(boolean bModify) {
        this.bModify = bModify;
    }


    public String getFileIntro() {
        return fileIntro;
    }

    public void setFileIntro(String fileIntro) {
        this.fileIntro = fileIntro;
    }
}
