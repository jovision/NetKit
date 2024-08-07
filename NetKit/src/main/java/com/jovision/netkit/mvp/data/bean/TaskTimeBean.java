package com.jovision.netkit.mvp.data.bean;

import java.io.Serializable;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/11/27
 * 描述：
 */
public class TaskTimeBean implements Serializable {

    public TaskTimeBean() {
    }

    public TaskTimeBean(String week, int begin_hour, int begin_min, int begin_sec, int end_hour, int end_min, int end_sec) {
        this.week = week;
        this.begin_hour = begin_hour;
        this.begin_min = begin_min;
        this.begin_sec = begin_sec;
        this.end_hour = end_hour;
        this.end_min = end_min;
        this.end_sec = end_sec;
    }

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

    public int getEnd_sec() {
        return end_sec;
    }

    public void setEnd_sec(int end_sec) {
        this.end_sec = end_sec;
    }

    @Override
    public String toString() {
        return "TaskTimeBean{" +
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
