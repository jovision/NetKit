package com.jovision.netkit.mvp.data.bean.request;

/**
 * 发送验证码网络请求:请求参数
 *
 * @author liteng
 * @date 2020/10/30
 */
public class ACSendVerifyCodeBean {

    private String receiver;
    private String sendBy;
    private String type;
    private String captchaVerification;//图形验证码校验值,V2接口开始使用

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCaptchaVerification() {
        return captchaVerification;
    }

    public void setCaptchaVerification(String captchaVerification) {
        this.captchaVerification = captchaVerification;
    }
}
