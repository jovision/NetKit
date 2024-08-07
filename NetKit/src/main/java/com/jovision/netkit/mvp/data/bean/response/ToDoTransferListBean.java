package com.jovision.netkit.mvp.data.bean.response;

import java.util.ArrayList;


//设备转移提醒列表
//http://172.18.3.246:3000/mock/382/v1/udms/device/remind/device_transfer_list
public class ToDoTransferListBean {


    private ArrayList<TransferDeviceBean> transferDeviceList;

    public ArrayList<TransferDeviceBean> getTransferDeviceList() {
        return transferDeviceList;
    }

    public void setTransferDeviceList(ArrayList<TransferDeviceBean> transferDeviceList) {
        this.transferDeviceList = transferDeviceList;
    }


    public class TransferDeviceBean{
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



}
