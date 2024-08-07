package com.jovision.netkit.mvp.data.bean.request;

import java.util.List;

public class UpdateSceneRequestBean {
    private String sceneId;
    private String sceneName;
    List<CreateSceneChannelRequestBean> devices;

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

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

    @Override
    public String toString() {
        return "UpdateSceneRequestBean{" +
                "sceneId='" + sceneId + '\'' +
                ", sceneName='" + sceneName + '\'' +
                ", devices=" + devices +
                '}';
    }
}
