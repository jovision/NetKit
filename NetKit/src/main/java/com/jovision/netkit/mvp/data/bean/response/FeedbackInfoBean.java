package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

public class FeedbackInfoBean {
    private int id;
    private String type; //意见反馈类型 枚举: SUGGESTION :新功能建议,EXPERIENCE：体验问题,EXCEPTION：功能异常,OTHER：其他问题
    private String problem;//建议描述
    private List<String> pictures;//反馈图片
    private String addTime; //反馈时间 格式yyyy-MM-dd HH:mm:ss
    private String answerTime;//答复时间 格式yyyy-MM-dd HH:mm:ss
    private int answerStatus;//处理状态 0:未答复;1:已答复
    private String contact; //联系电话
    private String answerContent;//答复详情

    private String consoleTypeId;//	控制台修改二级问题类型ID
    private String consoleTypeName;//	控制台修改二级问题类型名称
    private List<RemoteOpsDeviceBean> deviceInfo;//	问题设备列表
    private String frequency;//出现频次 always：一直出现 often：频繁出现 whiles：偶尔出现
    private String twoTypeId;//	二级问题类型ID
    private String twoTypeName;//	二级问题类型名称

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

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
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

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getConsoleTypeId() {
        return consoleTypeId;
    }

    public void setConsoleTypeId(String consoleTypeId) {
        this.consoleTypeId = consoleTypeId;
    }

    public String getConsoleTypeName() {
        return consoleTypeName;
    }

    public void setConsoleTypeName(String consoleTypeName) {
        this.consoleTypeName = consoleTypeName;
    }

    public List<RemoteOpsDeviceBean> getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(List<RemoteOpsDeviceBean> deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getTwoTypeId() {
        return twoTypeId;
    }

    public void setTwoTypeId(String twoTypeId) {
        this.twoTypeId = twoTypeId;
    }

    public String getTwoTypeName() {
        return twoTypeName;
    }

    public void setTwoTypeName(String twoTypeName) {
        this.twoTypeName = twoTypeName;
    }
}
