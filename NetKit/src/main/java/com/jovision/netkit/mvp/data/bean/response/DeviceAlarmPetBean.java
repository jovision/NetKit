package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

/**
 * 宠物检测
 */
public class DeviceAlarmPetBean implements Serializable {

    private int channelid;
    private String sensitivity;//high,middle,low 高中低
    private boolean ptz_trace;//云台追踪
    private int ptz_trace_sec;//追踪时长
    private int alarm_defence_plan_id;//布防时间计划id
    private int alarm_link_id;//报警联动计划id
    private boolean display_region;//显示检测区域和目标区域
    private int maxRect;//矩形最大个数
//    private int maxRectW = 65535;//矩形最大宽度
//    private int maxRectH = 65535;//矩形最大高度
    private List<RectsBean> rects;//矩形数组  0-65535，坐标以65535为最大参考值，注意转换

    public int getChannelid() {
        return channelid;
    }

    public void setChannelid(int channelid) {
        this.channelid = channelid;
    }


    public String getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(String sensitivity) {
        this.sensitivity = sensitivity;
    }

    public boolean isPtz_trace() {
        return ptz_trace;
    }

    public void setPtz_trace(boolean ptz_trace) {
        this.ptz_trace = ptz_trace;
    }

    public int getAlarm_defence_plan_id() {
        return alarm_defence_plan_id;
    }

    public void setAlarm_defence_plan_id(int alarm_defence_plan_id) {
        this.alarm_defence_plan_id = alarm_defence_plan_id;
    }

    public int getAlarm_link_id() {
        return alarm_link_id;
    }

    public void setAlarm_link_id(int alarm_link_id) {
        this.alarm_link_id = alarm_link_id;
    }

    public boolean isDisplay_region() {
        return display_region;
    }

    public void setDisplay_region(boolean display_region) {
        this.display_region = display_region;
    }

    public int getMaxRect() {
        return maxRect;
    }

    public void setMaxRect(int maxRect) {
        this.maxRect = maxRect;
    }

//    public int getMaxRectW() {
//        return maxRectW;
//    }
//
//    public void setMaxRectW(int maxRectW) {
//        this.maxRectW = maxRectW;
//    }
//
//    public int getMaxRectH() {
//        return maxRectH;
//    }
//
//    public void setMaxRectH(int maxRectH) {
//        this.maxRectH = maxRectH;
//    }

    public List<RectsBean> getRects() {
        return rects;
    }

    public void setRects(List<RectsBean> rects) {
        this.rects = rects;
    }

    public int getPtz_trace_sec() {
        return ptz_trace_sec;
    }

    public void setPtz_trace_sec(int ptz_trace_sec) {
        this.ptz_trace_sec = ptz_trace_sec;
    }

    public static class RectsBean implements Serializable {
        /**
         * x : 78
         * y : 300
         * w : 700
         * h : 500
         */

        private int x;
        private int y;
        private int w;
        private int h;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }
    }

}
