package com.jovision.netkit.mvp.data.bean.response;

public class AddShareBean {
    private String shareNumber;
    private Permission permission;

    public String getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(String shareNumber) {
        this.shareNumber = shareNumber;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "AddShareBean{" +
                "shareNumber='" + shareNumber + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
