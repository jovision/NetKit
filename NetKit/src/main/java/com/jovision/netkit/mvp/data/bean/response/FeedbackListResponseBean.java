package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

public class FeedbackListResponseBean {
    private PageBean page;
    private List<FeedbackListItemBean> items;

    @Override
    public String toString() {
        return "FeedbackListResponseBean{" +
                "page=" + page +
                ", items=" + items +
                '}';
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public List<FeedbackListItemBean> getItems() {
        return items;
    }

    public void setItems(List<FeedbackListItemBean> items) {
        this.items = items;
    }
}
