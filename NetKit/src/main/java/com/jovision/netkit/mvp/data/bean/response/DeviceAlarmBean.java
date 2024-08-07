package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/11/26
 * 描述：
 */
public class DeviceAlarmBean implements Serializable {

    /*移动侦测和人形检测*/

    /**
     * bEnable : true
     * bEnableSMD : false
     * bAlarming : false
     * bEnableRecord : true
     * sensitivity : 90
     * delay : 10
     * videoChannel : 0
     * bSnapshot : false
     * nPreset : 0
     * bBuzzing : true
     * bOutClient : false
     * bOutEmail : false
     * bSendToAlmServer : false
     * bAlarmSoundEnable : false
     * WhiteLight : {"bEnable":false,"Strength":0}
     * bUseGrids : false
     * maxRect : 4
     * maxRectW : 1920
     * maxRectH : 1080
     * rects : [{"x":78,"y":300,"w":700,"h":500}]
     * grids : {"cntRow":0,"cntCol":0,"strid":0}
     * task : {"bsos":false,"bAllTime":true,"maxTime":1,"time":[{"week":"EveryDay","begin_hour":0,"begin_min":0,"begin_sec":0,"end_hour":23,"end_min":59,"end_sec":59}]}
     */

    private List<DetNameBean> detNameList;//检测名称列表
    private List<String> detTypeList;// App没有使用过：支持的检测类型：object：物体检测 body：人形检测 vehicle：车辆检测;
    private List<String> detType;// 设备当前的检测类型：检测类型：object：物体检测 body：人形检测 vehicle：车辆检测

    public List<DetNameBean> getDetNameList() {
        return detNameList;
    }

    public void setDetNameList(List<DetNameBean> detNameList) {
        this.detNameList = detNameList;
    }

    public List<String> getDetTypeList() {
        return detTypeList;
    }

    public void setDetTypeList(List<String> detTypeList) {
        this.detTypeList = detTypeList;
    }

    public List<String> getDetType() {
        return detType;
    }

    public void setDetType(List<String> detType) {
        this.detType = detType;
    }

    public boolean isbMarkObject() {
        return bMarkObject;
    }

    public void setbMarkObject(boolean bMarkObject) {
        this.bMarkObject = bMarkObject;
    }

    public boolean isbReportObject() {
        return bReportObject;
    }

    public void setbReportObject(boolean bReportObject) {
        this.bReportObject = bReportObject;
    }

    public boolean isbPtzAutoTraceObject() {
        return bPtzAutoTraceObject;
    }

    public void setbPtzAutoTraceObject(boolean bPtzAutoTraceObject) {
        this.bPtzAutoTraceObject = bPtzAutoTraceObject;
    }

    public int getPtzTraceSec() {
        return ptzTraceSec;
    }

    public void setPtzTraceSec(int ptzTraceSec) {
        this.ptzTraceSec = ptzTraceSec;
    }

    public boolean isbGunDomeTrace() {
        return bGunDomeTrace;
    }

    public void setbGunDomeTrace(boolean bGunDomeTrace) {
        this.bGunDomeTrace = bGunDomeTrace;
    }

    public int getGunDomeTraceSec() {
        return gunDomeTraceSec;
    }

    public void setGunDomeTraceSec(int gunDomeTraceSec) {
        this.gunDomeTraceSec = gunDomeTraceSec;
    }


    public static class DetNameBean implements Serializable {

        private String type;//"object","body","vehicle"
        private String name;//中文名称：object：物体检测 body：人形检测 vehicle：车辆检测

        private boolean isSelected;//App自己加的，是否选中的状态，选中就是打开

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }
    }


    private boolean bEnable;
    private boolean bEnableSMD;
    private boolean bAlarming;
    private boolean bEnableRecord;
    private int sensitivity;
    private int delay;
    private int videoChannel;
    private boolean bSnapshot;
    private int nPreset;
    private boolean bBuzzing;
    private boolean bOutClient;
    private boolean bOutEmail;
    private boolean bSendToAlmServer;
    private boolean bAlarmSoundEnable;//报警声音
    private boolean bMarkObject = false;			//标记检测目标,检测目标叠加的开关
    private boolean bReportObject = false;		//上报检测目标
    private boolean bPtzAutoTraceObject = false;		//云台追踪目标
    private int ptzTraceSec = 300;				//云台跟踪目标跟踪时间


    private boolean bGunDomeTrace = false;		//枪球跟踪
    private int gunDomeTraceSec = 300;				//枪球跟踪时间


    private WhiteLightBean WhiteLight;
    private AlarmLightBean AlarmLight;
    private boolean bUseGrids;
    private int maxRect;
    private int maxRectW;
    private int maxRectH;
    private GridsBean grids;
    private TaskBean task;
    private List<RectsBean> rects;
    private int alarm_link_id;//报警联动计划id
    private int alarm_defence_plan_id;//布防时间计划id




    public AlarmLightBean getAlarmLight() {
        return AlarmLight;
    }

    public void setAlarmLight(AlarmLightBean alarmLight) {
        AlarmLight = alarmLight;
    }

    public boolean isBEnable() {
        return bEnable;
    }

    public void setBEnable(boolean bEnable) {
        this.bEnable = bEnable;
    }

    public boolean isBEnableSMD() {
        return bEnableSMD;
    }

    public void setBEnableSMD(boolean bEnableSMD) {
        this.bEnableSMD = bEnableSMD;
    }

    public boolean isBAlarming() {
        return bAlarming;
    }

    public void setBAlarming(boolean bAlarming) {
        this.bAlarming = bAlarming;
    }

    public boolean isBEnableRecord() {
        return bEnableRecord;
    }

    public void setBEnableRecord(boolean bEnableRecord) {
        this.bEnableRecord = bEnableRecord;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getVideoChannel() {
        return videoChannel;
    }

    public void setVideoChannel(int videoChannel) {
        this.videoChannel = videoChannel;
    }

    public boolean isBSnapshot() {
        return bSnapshot;
    }

    public void setBSnapshot(boolean bSnapshot) {
        this.bSnapshot = bSnapshot;
    }

    public int getNPreset() {
        return nPreset;
    }

    public void setNPreset(int nPreset) {
        this.nPreset = nPreset;
    }

    public boolean isBBuzzing() {
        return bBuzzing;
    }

    public void setBBuzzing(boolean bBuzzing) {
        this.bBuzzing = bBuzzing;
    }

    public boolean isBOutClient() {
        return bOutClient;
    }

    public void setBOutClient(boolean bOutClient) {
        this.bOutClient = bOutClient;
    }

    public boolean isBOutEmail() {
        return bOutEmail;
    }

    public void setBOutEmail(boolean bOutEmail) {
        this.bOutEmail = bOutEmail;
    }

    public boolean isBSendToAlmServer() {
        return bSendToAlmServer;
    }

    public void setBSendToAlmServer(boolean bSendToAlmServer) {
        this.bSendToAlmServer = bSendToAlmServer;
    }

    public boolean isBAlarmSoundEnable() {
        return bAlarmSoundEnable;
    }

    public void setBAlarmSoundEnable(boolean bAlarmSoundEnable) {
        this.bAlarmSoundEnable = bAlarmSoundEnable;
    }

    public WhiteLightBean getWhiteLight() {
        return WhiteLight;
    }

    public void setWhiteLight(WhiteLightBean WhiteLight) {
        this.WhiteLight = WhiteLight;
    }

    public boolean isBUseGrids() {
        return bUseGrids;
    }

    public void setBUseGrids(boolean bUseGrids) {
        this.bUseGrids = bUseGrids;
    }

    public int getMaxRect() {
        return maxRect;
    }

    public void setMaxRect(int maxRect) {
        this.maxRect = maxRect;
    }

    public int getMaxRectW() {
        return maxRectW;
    }

    public void setMaxRectW(int maxRectW) {
        this.maxRectW = maxRectW;
    }

    public int getMaxRectH() {
        return maxRectH;
    }

    public void setMaxRectH(int maxRectH) {
        this.maxRectH = maxRectH;
    }

    public GridsBean getGrids() {
        return grids;
    }

    public void setGrids(GridsBean grids) {
        this.grids = grids;
    }

    public TaskBean getTask() {
        return task;
    }

    public void setTask(TaskBean task) {
        this.task = task;
    }

    public List<RectsBean> getRects() {
        return rects;
    }

    public void setRects(List<RectsBean> rects) {
        this.rects = rects;
    }

    public int getAlarm_link_id() {
        return alarm_link_id;
    }

    public void setAlarm_link_id(int alarm_link_id) {
        this.alarm_link_id = alarm_link_id;
    }

    public int getAlarm_defence_plan_id() {
        return alarm_defence_plan_id;
    }

    public void setAlarm_defence_plan_id(int alarm_defence_plan_id) {
        this.alarm_defence_plan_id = alarm_defence_plan_id;
    }

    public static class WhiteLightBean implements Serializable {
        /**
         * bEnable : false
         * Strength : 0
         */

        private boolean bEnable;
        private int Strength;

        public boolean isBEnable() {
            return bEnable;
        }

        public void setBEnable(boolean bEnable) {
            this.bEnable = bEnable;
        }

        public int getStrength() {
            return Strength;
        }

        public void setStrength(int Strength) {
            this.Strength = Strength;
        }
    }

    public static class AlarmLightBean implements Serializable {

        private boolean bEnable;
        private int Strength;

        public boolean isBEnable() {
            return bEnable;
        }

        public void setBEnable(boolean bEnable) {
            this.bEnable = bEnable;
        }

        public int getStrength() {
            return Strength;
        }

        public void setStrength(int Strength) {
            this.Strength = Strength;
        }

    }


    public static class GridsBean implements Serializable {
        /**
         * cntRow : 0
         * cntCol : 0
         * strid : 0
         */

        private int cntRow;
        private int cntCol;
        private int strid;

        public int getCntRow() {
            return cntRow;
        }

        public void setCntRow(int cntRow) {
            this.cntRow = cntRow;
        }

        public int getCntCol() {
            return cntCol;
        }

        public void setCntCol(int cntCol) {
            this.cntCol = cntCol;
        }

        public int getStrid() {
            return strid;
        }

        public void setStrid(int strid) {
            this.strid = strid;
        }
    }

    public static class TaskBean implements Serializable {
        /**
         * bsos : false
         * bAllTime : true
         * maxTime : 1
         * time : [{"week":"EveryDay","begin_hour":0,"begin_min":0,"begin_sec":0,"end_hour":23,"end_min":59,"end_sec":59}]
         */

        private boolean bsos;
        private boolean bAllTime;
        private int maxTime;
        private List<TimeBean> time;

        public boolean isBsos() {
            return bsos;
        }

        public void setBsos(boolean bsos) {
            this.bsos = bsos;
        }

        public boolean isBAllTime() {
            return bAllTime;
        }

        public void setBAllTime(boolean bAllTime) {
            this.bAllTime = bAllTime;
        }

        public int getMaxTime() {
            return maxTime;
        }

        public void setMaxTime(int maxTime) {
            this.maxTime = maxTime;
        }

        public List<TimeBean> getTime() {
            return time;
        }

        public void setTime(List<TimeBean> time) {
            this.time = time;
        }

        public static class TimeBean implements Serializable {
            /**
             * week : EveryDay
             * begin_hour : 0
             * begin_min : 0
             * begin_sec : 0
             * end_hour : 23
             * end_min : 59
             * end_sec : 59
             */

            private String week;
            private int begin_hour;
            private int begin_min;
            private int begin_sec;
            private int end_hour;
            private int end_min;
            private int end_sec;

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public int getBegin_hour() {
                return begin_hour;
            }

            public void setBegin_hour(int begin_hour) {
                this.begin_hour = begin_hour;
            }

            public int getBegin_min() {
                return begin_min;
            }

            public void setBegin_min(int begin_min) {
                this.begin_min = begin_min;
            }

            public int getBegin_sec() {
                return begin_sec;
            }

            public void setBegin_sec(int begin_sec) {
                this.begin_sec = begin_sec;
            }

            public int getEnd_hour() {
                return end_hour;
            }

            public void setEnd_hour(int end_hour) {
                this.end_hour = end_hour;
            }

            public int getEnd_min() {
                return end_min;
            }

            public void setEnd_min(int end_min) {
                this.end_min = end_min;
            }

            public int getEnd_sec() {
                return end_sec;
            }

            public void setEnd_sec(int end_sec) {
                this.end_sec = end_sec;
            }

            @Override
            public String toString() {
                return "TimeBean{" +
                        "week='" + week + '\'' +
                        ", begin_hour=" + begin_hour +
                        ", begin_min=" + begin_min +
                        ", begin_sec=" + begin_sec +
                        ", end_hour=" + end_hour +
                        ", end_min=" + end_min +
                        ", end_sec=" + end_sec +
                        '}';
            }
        }
    }

    public static class RectsBean implements Serializable {
        /**
         * x : 78
         * y : 300
         * w : 700
         * h : 500
         */

        private int x;
        private int y;
        private int w;
        private int h;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }
    }

}
