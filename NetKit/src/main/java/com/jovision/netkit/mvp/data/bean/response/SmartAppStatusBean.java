package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

/**
 * @ProjectName: SAAS
 * @Package: com.jovision.saas.data.bean.response
 * @ClassName: SmartAppStatusBean
 * @Description: java类作用描述
 * @CreateDate: 2024/3/20 17:39
 * @Version: 1.0
 */
public class SmartAppStatusBean implements Serializable {

    public SmartAppStatusBean() {
    }

    public SmartAppStatusBean(String algorithmSign, String algorithmName, int algorithmStatus) {
        this.algorithmSign = algorithmSign;
        this.algorithmName = algorithmName;
        this.algorithmStatus = algorithmStatus;
    }

    //算法标识
    private String algorithmSign;
    //算法名称
    private String algorithmName;
    //算法版本
    private String algorithmVersion;
    //算法状态 0未运行，1运行中，2待授权，3加载中，4已到期
    private int algorithmStatus;

    //截止时间，年月日 格式20240203
    private String algorithmExpiration;

    public String getAlgorithmSign() {
        return algorithmSign;
    }

    public void setAlgorithmSign(String algorithmSign) {
        this.algorithmSign = algorithmSign;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmVersion() {
        return algorithmVersion;
    }

    public void setAlgorithmVersion(String algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

    public int getAlgorithmStatus() {
        return algorithmStatus;
    }

    public void setAlgorithmStatus(int algorithmStatus) {
        this.algorithmStatus = algorithmStatus;
    }

    public String getAlgorithmExpiration() {
        return algorithmExpiration;
    }

    public void setAlgorithmExpiration(String algorithmExpiration) {
        this.algorithmExpiration = algorithmExpiration;
    }
}
