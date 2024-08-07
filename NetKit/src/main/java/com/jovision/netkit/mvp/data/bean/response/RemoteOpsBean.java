package com.jovision.netkit.mvp.data.bean.response;


import com.jovision.basekit.utilcode.StringUtils;

import java.io.Serializable;

/**
 * 远程运维数据
 *
 * @author liteng
 * @date 2022/6/17
 */
public class RemoteOpsBean implements Serializable {

    private String operationCode;
    private String expiredTime;

    public String getOperationCode() {
        return StringUtils.null2Length0(operationCode);
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getExpiredTime() {
        return StringUtils.null2Length0(expiredTime);
    }

    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }
}
