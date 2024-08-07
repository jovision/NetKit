package com.jovision.netkit.mvp.data.bean;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2021/5/20
 * 描述：
 */
public class ShareDevicePermission {

    private int pic;
    private String  permission;//此处为权限现实列表
    private String  des;
    private boolean isVisible;

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
