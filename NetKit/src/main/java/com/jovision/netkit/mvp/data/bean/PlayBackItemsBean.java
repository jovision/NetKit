package com.jovision.netkit.mvp.data.bean;


/**
 * Created by zhp on 2020/11/17
 */
public class PlayBackItemsBean extends BaseEntity{

    /**
     * fileName : /progs/rec/00/20201113/N01000000.mp4
     * startTime : 20201113000000
     * endTime : 20201113001002
     * recordType : normal
     */

    private boolean is500Item = false;
    private String fileName;
    private String startTime;//20230603035827
    private String endTime;
    private String recordType;

    private String eventAlarmType;// "normal" 正常颜色   "alarm" 报警颜色, 自己定义的字段
    private boolean isDownloaded;

    private int startSeconds;//开始时间
    private int endSeconds;//结束时间

    public boolean isDownloaded() {
        return isDownloaded;
    }

    public void setDownloaded(boolean downloaded) {
        isDownloaded = downloaded;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public int getStartSeconds() {
        return startSeconds;
    }

    public void setStartSeconds(int startSeconds) {
        this.startSeconds = startSeconds;
    }

    public int getEndSeconds() {
        return endSeconds;
    }

    public void setEndSeconds(int endSeconds) {
        this.endSeconds = endSeconds;
    }

    public boolean isIs500Item() {
        return is500Item;
    }

    public void setIs500Item(boolean is500Item) {
        this.is500Item = is500Item;
    }

    public String getEventAlarmType() {
        return eventAlarmType;
    }

    public void setEventAlarmType(String eventAlarmType) {
        this.eventAlarmType = eventAlarmType;
    }
}
