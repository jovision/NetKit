package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

public class MyOrdersBean {
    private List<OrderBean> items;

    public List<OrderBean> getItems() {
        return items;
    }

    public void setItems(List<OrderBean> items) {
        this.items = items;
    }
}
