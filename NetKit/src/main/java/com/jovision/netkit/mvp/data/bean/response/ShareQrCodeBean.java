package com.jovision.netkit.mvp.data.bean.response;


import com.jovision.basekit.utilcode.StringUtils;

/**
 * 共享设备二维码数据
 *
 * @author liteng
 * @date 2022/4/2
 */
public class ShareQrCodeBean {

    /**
     * 分享token
     */
    private String shareToken;
    /**
     * 分享的截止时间
     */
    private String expireTime;

    public String getShareToken() {
        return StringUtils.null2Length0(shareToken);
    }

    public void setShareToken(String shareToken) {
        this.shareToken = shareToken;
    }

    public String getExpireTime() {
        return StringUtils.null2Length0(expireTime);
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }
}
