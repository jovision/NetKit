package com.jovision.netkit.mvp.data.bean;

/**
 * @ProjectName: SAAS
 * @Package: com.jovision.saas.multiplay.smart.bean
 * @ClassName: NativePaymentData
 * @Description: java类作用描述
 * @CreateDate: 2024/5/17 16:54
 * @Version: 1.0
 *
 * {"packageType": "aaaaa","channelCount":1,"deviceSn":"122SSSSSSSS"}
 */
public class NativePaymentData {
    private String packageType;

    private int channelCount;

    private String deviceSn;

    private int signType;

    public int getSignType() {
        return signType;
    }

    public void setSignType(int signType) {
        this.signType = signType;
    }

    public NativePaymentData(String packageType, int channelCount, String deviceSn, int signType) {
        this.packageType = packageType;
        this.channelCount = channelCount;
        this.deviceSn = deviceSn;
        this.signType = signType;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public int getChannelCount() {
        return channelCount;
    }

    public void setChannelCount(int channelCount) {
        this.channelCount = channelCount;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }
}
