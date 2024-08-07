package com.jovision.netkit.mvp.data.bean.response;

public class FeedbackListItemBean {
    private int id;
    private String type;    //意见反馈类型 枚举: SUGGESTION :新功能建议,EXPERIENCE：体验问题,EXCEPTION：功能异常,OTHER：其他问题
    private String problem;//问题描述
    private String addTime; //反馈时间 格式yyyy-MM-dd HH:mm:ss
    private String answerTime;//答复时间 格式yyyy-MM-dd HH:mm:ss
    private int answerStatus;   //处理状态 0:未答复;1:已答复
    private String contact;//联系电话
    private int readStatus;//已读状态：0：未读1：已读
    private String answerContent;//答复内容

    private String twoTypeId;//二级分类ID
    private String twoTypeName;//二级分类名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }

    public int getAnswerStatus() {
        return answerStatus;
    }

    public void setAnswerStatus(int answerStatus) {
        this.answerStatus = answerStatus;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getTwoTypeId() {
        return twoTypeId;
    }

    public void setTwoTypeId(String twoTypeId) {
        this.twoTypeId = twoTypeId;
    }

    public String getTwotypeName() {
        return twoTypeName;
    }

    public void setTwotypeName(String twotypeName) {
        this.twoTypeName = twotypeName;
    }
}
