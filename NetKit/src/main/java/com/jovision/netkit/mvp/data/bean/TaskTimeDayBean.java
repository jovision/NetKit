package com.jovision.netkit.mvp.data.bean;

import java.util.List;

public class TaskTimeDayBean {

    private String week;
    private List<TaskTimeBean> timeList;

    public TaskTimeDayBean() {
    }

    public TaskTimeDayBean(String week, List<TaskTimeBean> timeList) {
        this.week = week;
        this.timeList = timeList;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public List<TaskTimeBean> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<TaskTimeBean> timeList) {
        this.timeList = timeList;
    }
}
