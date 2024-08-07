package com.jovision.netkit.mvp.data.bean.response;

/**
 * 未读状态
 *
 * @author liteng
 * @date 2022/9/23
 */
public class UnreadCountBean {

    /**
     * 0：无串货举报未读消息1：有串货举报未读消息
     */
    private int crossReadStatus;
    /**
     * 0：无工程商未读消息1：有工程商未读消息
     */
    private int enterpriseReadStatus;
    /**
     * 0：无反馈未读消息1：有反馈未读消息
     */
    private int feedbackReadStatus;

    public int getCrossReadStatus() {
        return crossReadStatus;
    }

    public void setCrossReadStatus(int crossReadStatus) {
        this.crossReadStatus = crossReadStatus;
    }

    public int getEnterpriseReadStatus() {
        return enterpriseReadStatus;
    }

    public void setEnterpriseReadStatus(int enterpriseReadStatus) {
        this.enterpriseReadStatus = enterpriseReadStatus;
    }

    public int getFeedbackReadStatus() {
        return feedbackReadStatus;
    }

    public void setFeedbackReadStatus(int feedbackReadStatus) {
        this.feedbackReadStatus = feedbackReadStatus;
    }
}
