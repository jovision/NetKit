package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

/**
 * 离岗检测
 */
public class DeviceAlarmLiGangBean implements Serializable {

    private int channelid;
    private int pdmax;//最大人员数量
    private String detection_rule;//人员检测規則,LT小于、GT大于、NE不等于
    private int pdnum;//区域报警检测人员数量
    private boolean bEnable;
    private boolean bEnableRecord;
    private int sensitivity;
    private int alarm_defence_plan_id;
    private int alarm_link_id;
    private int detect_time;//离开时长
    private int delay;//报警持续时长

    private boolean bMarkObject;//标记检测目标
    private int max_region_cnt;
    private int everyregion_max_point_cnt;
    private int maxRectW = 65535;
    private int maxRectH = 65535;
    private List<RegionBean> regions;

    public int getChannelid() {
        return channelid;
    }

    public void setChannelid(int channelid) {
        this.channelid = channelid;
    }

    public int getPdmax() {
        return pdmax;
    }

    public void setPdmax(int pdmax) {
        this.pdmax = pdmax;
    }

    public String getDetection_rule() {
        return detection_rule;
    }

    public void setDetection_rule(String detection_rule) {
        this.detection_rule = detection_rule;
    }

    public int getPdnum() {
        return pdnum;
    }

    public void setPdnum(int pdnum) {
        this.pdnum = pdnum;
    }

    public boolean isbEnable() {
        return bEnable;
    }

    public void setbEnable(boolean bEnable) {
        this.bEnable = bEnable;
    }

    public boolean isbEnableRecord() {
        return bEnableRecord;
    }

    public void setbEnableRecord(boolean bEnableRecord) {
        this.bEnableRecord = bEnableRecord;
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

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public int getDetect_time() {
        return detect_time;
    }

    public void setDetect_time(int detect_time) {
        this.detect_time = detect_time;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public boolean isbMarkObject() {
        return bMarkObject;
    }

    public void setbMarkObject(boolean bMarkObject) {
        this.bMarkObject = bMarkObject;
    }

    public int getMax_region_cnt() {
        return max_region_cnt;
    }

    public void setMax_region_cnt(int max_region_cnt) {
        this.max_region_cnt = max_region_cnt;
    }

    public int getEveryregion_max_point_cnt() {
        return everyregion_max_point_cnt;
    }

    public void setEveryregion_max_point_cnt(int everyregion_max_point_cnt) {
        this.everyregion_max_point_cnt = everyregion_max_point_cnt;
    }

    public int getMaxRectW() {
        return maxRectW;
    }

    public void setMaxRectW(int maxRectW) {
        this.maxRectW = maxRectW;
    }

    public int getMaxRectH() {
        return maxRectH;
    }

    public void setMaxRectH(int maxRectH) {
        this.maxRectH = maxRectH;
    }

    public List<RegionBean> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionBean> regions) {
        this.regions = regions;
    }

    public static class RegionBean implements Serializable {
        private List<PointsBean> points;

        public List<PointsBean> getPoints() {
            return points;
        }

        public void setStPoints(List<PointsBean> points) {
            this.points = points;
        }

        public static class PointsBean implements Serializable {

            private int x;
            private int y;

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
        }
    }

}
