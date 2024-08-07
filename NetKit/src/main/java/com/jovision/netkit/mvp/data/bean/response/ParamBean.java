package com.jovision.netkit.mvp.data.bean.response;

public class ParamBean {
    /**
     * diskNum : 0
     * diskName : /dev/sda
     * partionNum : 0
     */

    private int diskNum;
    private String diskName;
    private int partionNum;

    public int getDiskNum() {
        return diskNum;
    }

    public void setDiskNum(int diskNum) {
        this.diskNum = diskNum;
    }

    public String getDiskName() {
        return diskName;
    }

    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    public int getPartionNum() {
        return partionNum;
    }

    public void setPartionNum(int partionNum) {
        this.partionNum = partionNum;
    }
}
