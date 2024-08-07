package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

/**
 * 云视通2.0报警时间段设置bean类
 */
public class OctAlarmTask implements Serializable {

    /**
     * bsos : false
     * bAllTime : true
     * maxTime : 4
     */

    private List<TimeBean> time;
    private boolean bsos;
    private boolean bAllTime;
    private int maxTime;

    public boolean isBsos() {
        return bsos;
    }

    public void setBsos(boolean bsos) {
        this.bsos = bsos;
    }

    public boolean isBAllTime() {
        return bAllTime;
    }

    public void setBAllTime(boolean bAllTime) {
        this.bAllTime = bAllTime;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }


    public List<TimeBean> getTime() {
        return time;
    }

    public void setTime(List<TimeBean> time) {
        this.time = time;
    }

    public static class TimeBean implements Serializable {
        /**
         * week : Sun
         * begin_hour : 12
         * begin_min : 0
         * begin_sec : 0
         * end_hour : 14
         * end_min : 0
         * end_sec : 0
         */

        private String week;
        private int begin_hour;
        private int begin_min;
        private int begin_sec;
        private int end_hour;
        private int end_min;
        private int end_sec;

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

        public String getStr(){
            return begin_hour+""+begin_min+""+end_hour+""+end_min;
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

    @Override
    public String toString() {
        return "OctAlarmTask{" +
                "time=" + time +
                ", bsos=" + bsos +
                ", bAllTime=" + bAllTime +
                ", maxTime=" + maxTime +
                '}';
    }
}
