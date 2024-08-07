package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

/**
 * 占道检测
 */
public class DeviceAlarmZhanDaoBean implements Serializable {

    private int channelid;
    private boolean enable;
    private int sensitivity;
    private boolean display_region;//显示检测区域和检测框
    private int alarm_defence_plan_id;//布防时间计划id
    private int alarm_link_id;//报警联动计划id
    private int detect_time;
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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public boolean isDisplay_region() {
        return display_region;
    }

    public void setDisplay_region(boolean display_region) {
        this.display_region = display_region;
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

    public int getDetect_time() {
        return detect_time;
    }

    public void setDetect_time(int detect_time) {
        this.detect_time = detect_time;
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
