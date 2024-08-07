package com.jovision.netkit.mvp.data.bean.response;

public class OrderBean {
    private long id;//订单id
    private String orderNumber;//	订单编号
    private String deviceSn;//	设备序列号
    private int channelId;//	通道编号
    private String storageId;//	套餐模板id
    private String storageType;//套餐类型 DYNAMIC：动检 FULL：全量
    private String storageName;//套餐模板名称
    private int storageDays;//	套餐存储天数
    private int expireDays;//套餐有效天数
    private long amount;//	订单金额（单位分）
    private String paymentType;//支付类型 ALIPAY-支付宝
    private String orderStatus;//订单状态,WAIT_PAY-待支付、PAID-已支付、CANCELED-已取消
    private String createTime;//下单时间
    private String updateTime;//	更新时间
    private int orderType;//订单类型：1：正常订单 2：首次签约 3：自动续费;  1显示支付宝和微信支付按钮2显示支付宝按钮3不显示按钮

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public int getStorageDays() {
        return storageDays;
    }

    public void setStorageDays(int storageDays) {
        this.storageDays = storageDays;
    }

    public int getExpireDays() {
        return expireDays;
    }

    public void setExpireDays(int expireDays) {
        this.expireDays = expireDays;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", deviceSn='" + deviceSn + '\'' +
                ", channelId=" + channelId +
                ", storageId='" + storageId + '\'' +
                ", storageType=" + storageType +
                ", storageName='" + storageName + '\'' +
                ", storageDays=" + storageDays +
                ", expireDays=" + expireDays +
                ", amount=" + amount +
                ", paymentType=" + paymentType +
                ", orderStatus=" + orderStatus +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
