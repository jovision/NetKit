package com.jovision.netkit.mvp.data.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhp on 2020/11/17
 */
public class GridItem implements Serializable {

    //路径
//    private String path;
    private List<String> paths;
    //时间
    private String time;
    private int section;
    //视频时长
    private String date;
    private GunBallFileInfo info;

    public GridItem(List<String> paths, String time) {
        super();
        this.paths = paths;
        this.time = time;
    }

    public GridItem(List<String> paths, String time, long modifyTime) {
        super();
        this.paths = paths;
        this.time = time;
        this.modifyTime = modifyTime;
    }

//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    private long modifyTime;

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public GunBallFileInfo getInfo() {
        return info;
    }

    public void setInfo(GunBallFileInfo info) {
        this.info = info;
    }

    /**
     * 枪球文件信息
     * 2023-06-01-15-20-08_GunBall_Gun_12221S8CVAGP_0.jpg
     */
    public static class GunBallFileInfo  implements Serializable{
        private String time;    //时间
        private String type;    //类型 Gun Ball
        private String devid;   //设备id
        private String channelid;

        public GunBallFileInfo() {
        }

        public GunBallFileInfo(String time, String type, String devid) {
            this.time = time;
            this.type = type;
            this.devid = devid;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDevid() {
            return devid;
        }

        public void setDevid(String devid) {
            this.devid = devid;
        }

        public String getChannelid() {
            return channelid;
        }

        public void setChannelid(String channelid) {
            this.channelid = channelid;
        }
    }
}
