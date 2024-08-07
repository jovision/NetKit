package com.jovision.netkit.mvp.data.bean;

import java.io.Serializable;
import java.util.List;

public class ContractorServiceListItem implements Serializable {

    /**
     * 类别编号
     */
    private int mode;
    /**
     * 类别名称
     */
    private String modeName;
    private List<ServiceItemBean> serviceInfos;

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public List<ServiceItemBean> getServiceInfos() {
        return serviceInfos;
    }

    public void setServiceInfos(List<ServiceItemBean> serviceInfos) {
        this.serviceInfos = serviceInfos;
    }
}
