package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

/**
 * 获取用户信息网络请求:返回值
 *
 * @author juyang
 * @date 2021/08/02
 */
public class ACUserInfoBean implements Serializable {

    public static final String YES = "YES";
    public static final String NO = "NO";
    private String realmID;
    private String userID;
    private String account;
    private String phone;
    private String mail;
    private String pwdSet;//用户是否已设置密码，枚举值，YES-是，NO-否
    private String nickname;
    private String icon;
    private String isSwitchEngineer;
    private String isEngineer;
    private boolean wxBind;
    private boolean qqBind;
    private boolean iosBind;

    public String getPwdSet() {
        return pwdSet;
    }

    public void setPwdSet(String pwdSet) {
        this.pwdSet = pwdSet;
    }

    public String getRealmID() {
        return realmID;
    }

    public void setRealmID(String realmID) {
        this.realmID = realmID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIsSwitchEngineer() {
        return isSwitchEngineer;
    }

    public void setIsSwitchEngineer(String isSwitchEngineer) {
        this.isSwitchEngineer = isSwitchEngineer;
    }

    public String getIsEngineer() {
        return isEngineer;
    }

    public void setIsEngineer(String isEngineer) {
        this.isEngineer = isEngineer;
    }

    public boolean isWxBind() {
        return wxBind;
    }

    public void setWxBind(boolean wxBind) {
        this.wxBind = wxBind;
    }

    public boolean isQqBind() {
        return qqBind;
    }

    public void setQqBind(boolean qqBind) {
        this.qqBind = qqBind;
    }

    public boolean isIosBind() {
        return iosBind;
    }

    public void setIosBind(boolean iosBind) {
        this.iosBind = iosBind;
    }
}
