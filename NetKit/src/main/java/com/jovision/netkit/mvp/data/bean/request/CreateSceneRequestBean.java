package com.jovision.netkit.mvp.data.bean.request;


import java.util.List;

public class CreateSceneRequestBean {
    private String sceneName;
    private List<CreateSceneChannelRequestBean> devices;

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public List<CreateSceneChannelRequestBean> getDevices() {
        return devices;
    }

    public void setDevices(List<CreateSceneChannelRequestBean> devices) {
        this.devices = devices;
    }
}
