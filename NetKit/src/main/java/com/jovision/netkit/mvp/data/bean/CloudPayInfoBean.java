package com.jovision.netkit.mvp.data.bean;

/**
 * Created by zhp on 2020/12/7
 */
public class CloudPayInfoBean {

    /**
     * prepayInfo : alipay_sdk=alipay-sdk-java-4.10.192.ALL&app_id=2021002115604763&biz_content=%7B%22body%22%3A%2230%E5%A4%A9%E5%8A%A8%E6%A3%80%E5%8C%85%E5%B9%B4%E5%A5%97%E9%A4%90%22%2C%22out_trade_no%22%3A%22123843552655446016%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%BC%80%E9%80%9A%E4%BA%91%E5%AD%98%E5%82%A8%E5%A5%97%E9%A4%90%22%2C%22timeout_express%22%3A%223d%22%2C%22total_amount%22%3A%220.01%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F59.46.11.161%3A9999%2Fv1%2Fpayment%2Falipay%2Fnotify&sign=dGGZ1jEAz%2F7VD2xnbjT5iPZxVPGLokdU1KtwNNjXmWsZZuKYRSNJMEC5jLWsm6BG3GnEp6jzu9K6kSyhy27fZ%2F2WVp7pJHHXTIZ%2FTmxmJcjMS8Y9cAhSKeiXqNumJKRXYR8LrsKLJqkhLIYI483wWoKq96UGdL6isRlmMk4c0frVHWUV%2FOKCHM79io%2FCxQiXHulPms02pH327q2h%2FOb3Htra8XSz%2BEcPiGQOVjqohMXyLbj57QxWlja1cd3DeCtGiixxWwa%2FtG9aXyk%2BikhSzvHcX3l26EqeuM7KeOY2P9c%2BjZVRLF0gadOOoGMBf79AvHwSlNkma6I8oVAwjyPuiA%3D%3D&sign_type=RSA2&timestamp=2020-12-07+17%3A50%3A03&version=1.0
     * orderNumber : 123843552655446016
     */

    private String paymentType;//支付类型，WXPAY:微信支付,ALIPAY：支付宝支付  默认为：ALIPAY
    private String prepayInfo;//ALIPAY：支付宝支付 订单信息，WXPAY:微信支付 prepayId
    private long orderNumber;
    private String mchId;//WXPAY:微信支付 商户号 ID
    private String timestamp;//WXPAY:微信支付 时间戳
    private String nonceStr;//WXPAY:微信支付
    private String sign;//WXPAY:微信支付 签名

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPrepayInfo() {
        return prepayInfo;
    }

    public void setPrepayInfo(String prepayInfo) {
        this.prepayInfo = prepayInfo;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
