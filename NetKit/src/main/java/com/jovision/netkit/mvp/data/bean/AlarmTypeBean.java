package com.jovision.netkit.mvp.data.bean;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/12/10
 * 描述：
 */
public class AlarmTypeBean {

   /* 1-设备异常报警、2-移动侦测报警、3-人形检测报警、4-周界入侵报警、5-镜头遮挡报警*/
    private String typeName;
    private String type;
    private boolean selected;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AlarmTypeBean(String typeName, String type,boolean selected) {
        this.typeName = typeName;
        this.type = type;
        this.selected=selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
