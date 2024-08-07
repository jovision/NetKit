package com.jovision.netkit.mvp.data;

public class GetScreenOverTurnBean {
    private boolean overTurn; //翻转 ；true 翻转 false 恢复
    private boolean rotation;   //	镜像； true 镜像 false 恢复

    public boolean isOverTurn() {
        return overTurn;
    }

    public void setOverTurn(boolean overTurn) {
        this.overTurn = overTurn;
    }

    public boolean isRotation() {
        return rotation;
    }

    public void setRotation(boolean rotation) {
        this.rotation = rotation;
    }
}
