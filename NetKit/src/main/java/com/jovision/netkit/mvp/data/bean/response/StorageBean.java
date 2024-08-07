package com.jovision.netkit.mvp.data.bean.response;

public class StorageBean {
    private String diskNum;
    private String diskName;
    private int sizeMB;
    private int usedMB;
    private boolean curDisk;
    private int partitionCount;
    private int curPart;
    private String status;//状态：normal-正常 unformated-未格式化 formating-正在格式化, using-使用中，none-不存在，full-容量满，idle-空闲准备就绪

    public String getDiskNum() {
        return diskNum;
    }

    public void setDiskNum(String diskNum) {
        this.diskNum = diskNum;
    }

    public String getDiskName() {
        return diskName;
    }

    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    public int getSizeMB() {
        return sizeMB;
    }

    public void setSizeMB(int sizeMB) {
        this.sizeMB = sizeMB;
    }

    public int getUsedMB() {
        return usedMB;
    }

    public void setUsedMB(int usedMB) {
        this.usedMB = usedMB;
    }

    public boolean isCurDisk() {
        return curDisk;
    }

    public void setCurDisk(boolean curDisk) {
        this.curDisk = curDisk;
    }

    public int getPartitionCount() {
        return partitionCount;
    }

    public void setPartitionCount(int partitionCount) {
        this.partitionCount = partitionCount;
    }

    public int getCurPart() {
        return curPart;
    }

    public void setCurPart(int curPart) {
        this.curPart = curPart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
