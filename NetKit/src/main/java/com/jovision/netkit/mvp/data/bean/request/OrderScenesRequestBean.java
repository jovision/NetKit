package com.jovision.netkit.mvp.data.bean.request;

import java.util.List;

public class OrderScenesRequestBean {

    private List<OrderSceneRequestBean> scenes;

    public List<OrderSceneRequestBean> getScenes() {
        return scenes;
    }

    public void setScenes(List<OrderSceneRequestBean> scenes) {
        this.scenes = scenes;
    }
}
