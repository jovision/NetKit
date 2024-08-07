package com.jovision.netkit.mvp.data.bean.response;

import com.jovision.netkit.mvp.data.bean.FeedBackIssueTypeBean;

import java.util.List;

public class FeedbackTypeResponseBean {
    private List<FeedBackIssueTypeBean> items;

    @Override
    public String toString() {
        return "FeedbackTypeResponseBean{" +
                ", items=" + items +
                '}';
    }


    public List<FeedBackIssueTypeBean> getItems() {
        return items;
    }

    public void setItems(List<FeedBackIssueTypeBean> items) {
        this.items = items;
    }
}
