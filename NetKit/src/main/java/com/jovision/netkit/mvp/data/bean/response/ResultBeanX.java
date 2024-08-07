package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

public class ResultBeanX {
    /**
     * total_cnt : 1000
     * snap_list : [{"name":"T01072123.jpg","path":"/progs/rec/00/20190808/T01072123.jpg","file_size":4096,"time":{"year":2019,"month":9,"day":7,"hour":18,"min":47,"sec":10},"snap_type":84}]
     */

    private int total_cnt;
    private List<SnapListBean> snap_list;

    public int getTotal_cnt() {
        return total_cnt;
    }

    public void setTotal_cnt(int total_cnt) {
        this.total_cnt = total_cnt;
    }

    public List<SnapListBean> getSnap_list() {
        return snap_list;
    }

    public void setSnap_list(List<SnapListBean> snap_list) {
        this.snap_list = snap_list;
    }
}
