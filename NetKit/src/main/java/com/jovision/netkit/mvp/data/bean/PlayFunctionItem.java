package com.jovision.netkit.mvp.data.bean;

/**
 * Created by zhp on 2020/11/5
 */
public class PlayFunctionItem {


    public static final int TYPE_GUN_BALL_PLAYBACK = 0;
    public static final int TYPE_SNAP = 1;
    public static final int TYPE_RECORD = 2;
    public static final int TYPE_CALL = 3;
    public static final int TYPE_PTZ = 4;
    public static final int TYPE_MORE = 5;
    public static final int TYPE_FILL_LIGHT = 10;
    public static final int TYPE_SIMPLE_DEFENCE = 11;
    public static final int TYPE_DRIVE_AWAY = 12;
    public static final int TYPE_CODE_RATE = 13;
    public static final int TYPE_PTZ_REST = 14;
    public static final int TYPE_SCREEN_FLIP = 15;
    public static final int TYPE_ALARM_CANCEL = 16;



    private int type;//类型区分，唯一
    //文字资源
    private String text;
    //图片资源
    private int resId;
    //选中状态，用于改变功能按钮的状态
    private boolean isSelected;
    //禁用状态
    private boolean isDisabled;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
