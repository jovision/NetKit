package com.jovision.netkit.mvp.data.bean.response;

import java.util.ArrayList;


//设备待办列表
//http://172.18.3.246:3000/mock/382/v1/udms/device/to_do_list
public class ToDoListBean {


    private ArrayList<TransferDeviceBean> transferDeviceList;
    private ArrayList<RemoteOperationBean> remoteOperationList;

    public ArrayList<TransferDeviceBean> getTransferDeviceList() {
        return transferDeviceList;
    }

    public void setTransferDeviceList(ArrayList<TransferDeviceBean> transferDeviceList) {
        this.transferDeviceList = transferDeviceList;
    }

    public ArrayList<RemoteOperationBean> getRemoteOperationList() {
        return remoteOperationList;
    }

    public void setRemoteOperationList(ArrayList<RemoteOperationBean> remoteOperationList) {
        this.remoteOperationList = remoteOperationList;
    }


    private class TransferDeviceBean{
        private String senderPhone;
        private String deviceSn;


        public String getSenderPhone() {
            return senderPhone;
        }

        public void setSenderPhone(String senderPhone) {
            this.senderPhone = senderPhone;
        }

        public String getDeviceSn() {
            return deviceSn;
        }

        public void setDeviceSn(String deviceSn) {
            this.deviceSn = deviceSn;
        }
    }


    private class RemoteOperationBean{
        private String enterprisePhone;
        private String deviceSn;

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
    }
}
