package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

/**
 * 串货举报-列表
 *
 * @author liteng
 * @date 2022/9/23
 */
public class CrossShipmentReportListBean {
    private int total;
    private List<CrossShipmentReportBean> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<CrossShipmentReportBean> getItems() {
        return items;
    }

    public void setItems(List<CrossShipmentReportBean> items) {
        this.items = items;
    }
}
