package com.jovision.netkit.mvp.data.bean;

/**
 * Created by zhp on 2020/12/7
 */
public class ScenesParmaBean extends BaseEntity {
    public static final String ADD = "ADD";
    public static final String REMOVE = "REMOVE";

    private String sceneId;
    private String action;//枚举值：ADD 添加，REMOVE 移除

    public ScenesParmaBean(String sceneId, String action) {
        this.sceneId = sceneId;
        this.action = action;
    }

}
