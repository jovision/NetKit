package com.jovision.netkit.mvp.data.bean.request;

/**
 * 未登录时查询openID是否绑定用户:请求参数
 *
 * @author juyang
 * @date 2020/12/05
 */
public class ACGetOpenIDBindUserBean {


    private String socialType;
    private String openID;

    public String getSocialType() {
        return socialType;
    }

    public void setSocialType(String socialType) {
        this.socialType = socialType;
    }

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }
}
