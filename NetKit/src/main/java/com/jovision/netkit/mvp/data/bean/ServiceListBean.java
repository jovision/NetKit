package com.jovision.netkit.mvp.data.bean;

import java.io.Serializable;
import java.util.List;

public class ServiceListBean implements Serializable {

    private List<ServiceItemBean> afterServices;
    private List<ServiceItemBean> tools;
    private List<ContractorServiceListItem> engineers;

    public List<ServiceItemBean> getAfterServices() {
        return afterServices;
    }

    public void setAfterServices(List<ServiceItemBean> afterServices) {
        this.afterServices = afterServices;
    }

    public List<ServiceItemBean> getTools() {
        return tools;
    }

    public void setTools(List<ServiceItemBean> tools) {
        this.tools = tools;
    }

    public List<ContractorServiceListItem> getEngineers() {
        return engineers;
    }

    public void setEngineers(List<ContractorServiceListItem> engineers) {
        this.engineers = engineers;
    }
}
