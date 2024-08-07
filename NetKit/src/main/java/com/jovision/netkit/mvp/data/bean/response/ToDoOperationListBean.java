package com.jovision.netkit.mvp.data.bean.response;

import java.util.ArrayList;


//远程运维消息提醒列表
//http://172.18.3.246:3000/mock/382/v1/udms/device/remind/remote_operation_list
public class ToDoOperationListBean {

    private ArrayList<RemoteOperationBean> remoteOperationList;

    public ArrayList<RemoteOperationBean> getRemoteOperationList() {
        return remoteOperationList;
    }

    public void setRemoteOperationList(ArrayList<RemoteOperationBean> remoteOperationList) {
        this.remoteOperationList = remoteOperationList;
    }


    public class RemoteOperationBean{
        private String enterprisePhone;
        private String deviceSn;
        private String name;

        public String getEnterprisePhone() {
            return enterprisePhone;
        }

        public void setEnterprisePhone(String enterprisePhone) {
            this.enterprisePhone = enterprisePhone;
        }

        public String getDeviceSn() {
            return deviceSn;
        }

        public void setDeviceSn(String deviceSn) {
            this.deviceSn = deviceSn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
