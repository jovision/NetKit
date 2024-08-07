package com.jovision.netkit.mvp.data.bean.response;

public class ShareUserInfoBean {
    private String nickname;
    private String account;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    @Override
    public String toString() {
        return "SharedUserInfoBean{" +
                ", nickName='" + nickname + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
