package com.jovision.netkit.mvp.data.bean.response;

public class ChannelBadgesBean {
    private int unreadCount;//	未读报警消息数量，>0代表有未读

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }
}
