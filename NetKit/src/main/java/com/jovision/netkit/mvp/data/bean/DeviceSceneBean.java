package com.jovision.netkit.mvp.data.bean;

/**
 * Created by zhp on 2020/12/7
 */
public class DeviceSceneBean {


    /**
     * sceneId : 24fe68dacccc4d2892115e604f2d865d
     * sceneName : 房间
     * sort : 1
     * belongStatus : 1
     */

    public static final String BELONG = "BELONG";
    public static final String NOT_BELONG = "NOT_BELONG";

    private String sceneId;
    private String sceneName;
    private int sort;
    private String belongStatus;//	NOT_BELONG不属于该场景 BELONG属于该场景

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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getBelongStatus() {
        return belongStatus;
    }
    public int getBelongStatusInt() {
        if (belongStatus.equals(BELONG)){
            return 1;
        }
        return 0;
    }

    public void setBelongStatus(String belongStatus) {
        this.belongStatus = belongStatus;
    }
    public void setBelongStatusInt(int belongStatus) {
        this.belongStatus = belongStatus == 1? BELONG:NOT_BELONG;
    }
}
