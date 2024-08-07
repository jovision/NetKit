package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

//布防时间
public class DefencePlanBean implements Serializable {

    private int channelid;
    private int plan_id;
    private boolean all_time;//是否全时段布防
    private int everyday_max_timecnt;//每天布防时间数量最大值
    private List<TimeBean> plan_times;

    public int getChannelid() {
        return channelid;
    }

    public void setChannelid(int channelid) {
        this.channelid = channelid;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public boolean isAll_time() {
        return all_time;
    }

    public void setAll_time(boolean all_time) {
        this.all_time = all_time;
    }

    public int getEveryday_max_timecnt() {
        return everyday_max_timecnt;
    }

    public void setEveryday_max_timecnt(int everyday_max_timecnt) {
        this.everyday_max_timecnt = everyday_max_timecnt;
    }

    public List<TimeBean> getPlan_times() {
        return plan_times;
    }

    public void setPlan_times(List<TimeBean> plan_times) {
        this.plan_times = plan_times;
    }

    public static class TimeBean implements Serializable {
        /**
         * week : EveryDay
         * begin_hour : 0
         * begin_min : 0
         * begin_sec : 0
         * end_hour : 23
         * end_min : 59
         * end_sec : 59
         */

        private String week; // "Mon,Tues,Wed,Thur,Fri,Sat,Sun,EveryDay"  星期1~7,每天
        private int begin_hour;
        private int begin_min;
        private int begin_sec;
        private int end_hour;
        private int end_min;
        private int end_sec;

        public TimeBean() {
        }

        public TimeBean(String week, int begin_hour, int begin_min, int begin_sec, int end_hour, int end_min, int end_sec) {
            this.week = week;
            this.begin_hour = begin_hour;
            this.begin_min = begin_min;
            this.begin_sec = begin_sec;
            this.end_hour = end_hour;
            this.end_min = end_min;
            this.end_sec = end_sec;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public int getBegin_hour() {
            return begin_hour;
        }

        public void setBegin_hour(int begin_hour) {
            this.begin_hour = begin_hour;
        }

        public int getBegin_min() {
            return begin_min;
        }

        public void setBegin_min(int begin_min) {
            this.begin_min = begin_min;
        }

        public int getBegin_sec() {
            return begin_sec;
        }

        public void setBegin_sec(int begin_sec) {
            this.begin_sec = begin_sec;
        }

        public int getEnd_hour() {
            return end_hour;
        }

        public void setEnd_hour(int end_hour) {
            this.end_hour = end_hour;
        }

        public int getEnd_min() {
            return end_min;
        }

        public void setEnd_min(int end_min) {
            this.end_min = end_min;
        }

        public int getEnd_sec() {
            return end_sec;
        }

        public void setEnd_sec(int end_sec) {
            this.end_sec = end_sec;
        }

        @Override
        public String toString() {
            return "TimeBean{" +
                    "week='" + week + '\'' +
                    ", begin_hour=" + begin_hour +
                    ", begin_min=" + begin_min +
                    ", begin_sec=" + begin_sec +
                    ", end_hour=" + end_hour +
                    ", end_min=" + end_min +
                    ", end_sec=" + end_sec +
                    '}';
        }
    }

}
