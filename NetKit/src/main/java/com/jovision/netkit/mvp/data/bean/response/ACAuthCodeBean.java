package com.jovision.netkit.mvp.data.bean.response;

/**
 * 修改手机号授权码网络请求:返回值
 *
 * @author liteng
 * @date 2020/10/30
 */
public class ACAuthCodeBean {

    private String verifyValue;

    public String getVerifyValue() {
        return verifyValue;
    }

    public void setVerifyValue(String verifyValue) {
        this.verifyValue = verifyValue;
    }
}
