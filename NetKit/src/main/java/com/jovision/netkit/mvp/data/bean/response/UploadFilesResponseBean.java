package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

public class UploadFilesResponseBean {

    private List<UploadFileBean> items;

    public List<UploadFileBean> getItems() {
        return items;
    }

    public void setItems(List<UploadFileBean> items) {
        this.items = items;
    }
}
