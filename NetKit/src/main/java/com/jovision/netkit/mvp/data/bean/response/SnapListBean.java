package com.jovision.netkit.mvp.data.bean.response;

public class SnapListBean {
    /**
     * name : T01072123.jpg
     * path : /progs/rec/00/20190808/T01072123.jpg
     * file_size : 4096
     * time : {"year":2019,"month":9,"day":7,"hour":18,"min":47,"sec":10}
     * snap_type : 84
     */

    private String name;
    private String path;
    private int file_size;
    private TimeBean time;
    private int snap_type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getFile_size() {
        return file_size;
    }

    public void setFile_size(int file_size) {
        this.file_size = file_size;
    }

    public TimeBean getTime() {
        return time;
    }

    public void setTime(TimeBean time) {
        this.time = time;
    }

    public int getSnap_type() {
        return snap_type;
    }

    public void setSnap_type(int snap_type) {
        this.snap_type = snap_type;
    }
}
