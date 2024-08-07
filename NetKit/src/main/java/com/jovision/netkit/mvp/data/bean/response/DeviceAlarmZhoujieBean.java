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
public class DeviceAlarmZhoujieBean implements Serializable {
    /*周界入侵*/
    /**
     * bEnable : false
     * nSen : 90
     * nThreshold : 40
     * nStayTime : 0
     * bDrawFrame : false
     * bFlushFrame : true
     * bMarkObject : true
     * bMarkAll : false
     * maxRectW : 1920
     * maxRectH : 1080
     * maxRegion : 2
     * task : {"bsos":false,"bAllTime":true,"maxTime":1,"time":[{"week":"EveryDay","begin_hour":0,"begin_min":0,"begin_sec":0,"end_hour":23,"end_min":59,"end_sec":59}]}
     * bOutClient : true
     * bOutEmail : true
     * bEnableRecord : true
     * bAlarmSoundEnable : false
     * WhiteLight : {"bEnable":false,"Strength":0}
     */

    private boolean bEnable;
    private int nSen;
    private int nThreshold;
    private int nStayTime;
    private boolean bDrawFrame;
    private boolean bFlushFrame;
    private boolean bMarkObject;
    private boolean bMarkAll;
    private int maxRectW;
    private int maxRectH;
    private int maxRegion;
    private TaskBean task;
    private boolean bOutClient;
    private boolean bOutEmail;
    private boolean bEnableRecord;
    private boolean bAlarmSoundEnable;
    private WhiteLightBean WhiteLight;
    private AlarmLightBean AlarmLight;
    private List<StRegionBean> stRegion;
    private List<AlarmoutBean> alarmout;
    private int alarm_link_id;//报警联动计划id
    private int alarm_defence_plan_id;//布防时间计划id

    private boolean bGunDomeTrace = false;		//枪球跟踪
    private int gunDomeTraceSec = 300;				//枪球跟踪时间


    public List<AlarmoutBean> getAlarmout() {
        return alarmout;
    }

    public void setAlarmout(List<AlarmoutBean> alarmout) {
        this.alarmout = alarmout;
    }

    public boolean isBEnable() {
        return bEnable;
    }

    public void setBEnable(boolean bEnable) {
        this.bEnable = bEnable;
    }

    public int getNSen() {
        return nSen;
    }

    public void setNSen(int nSen) {
        this.nSen = nSen;
    }

    public int getNThreshold() {
        return nThreshold;
    }

    public void setNThreshold(int nThreshold) {
        this.nThreshold = nThreshold;
    }

    public int getNStayTime() {
        return nStayTime;
    }

    public void setNStayTime(int nStayTime) {
        this.nStayTime = nStayTime;
    }

    public boolean isBDrawFrame() {
        return bDrawFrame;
    }

    public void setBDrawFrame(boolean bDrawFrame) {
        this.bDrawFrame = bDrawFrame;
    }

    public boolean isBFlushFrame() {
        return bFlushFrame;
    }

    public void setBFlushFrame(boolean bFlushFrame) {
        this.bFlushFrame = bFlushFrame;
    }

    public boolean isBMarkObject() {
        return bMarkObject;
    }

    public void setBMarkObject(boolean bMarkObject) {
        this.bMarkObject = bMarkObject;
    }

    public boolean isBMarkAll() {
        return bMarkAll;
    }

    public void setBMarkAll(boolean bMarkAll) {
        this.bMarkAll = bMarkAll;
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

    public int getMaxRegion() {
        return maxRegion;
    }

    public void setMaxRegion(int maxRegion) {
        this.maxRegion = maxRegion;
    }

    public TaskBean getTask() {
        return task;
    }

    public void setTask(TaskBean task) {
        this.task = task;
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

    public boolean isBEnableRecord() {
        return bEnableRecord;
    }

    public void setBEnableRecord(boolean bEnableRecord) {
        this.bEnableRecord = bEnableRecord;
    }

    public boolean isBAlarmSoundEnable() {
        return bAlarmSoundEnable;
    }

    public void setBAlarmSoundEnable(boolean bAlarmSoundEnable) {
        this.bAlarmSoundEnable = bAlarmSoundEnable;
    }

    public AlarmLightBean getAlarmLight() {
        return AlarmLight;
    }

    public void setAlarmLight(AlarmLightBean alarmLight) {
        AlarmLight = alarmLight;
    }

    public WhiteLightBean getWhiteLight() {
        return WhiteLight;
    }

    public void setWhiteLight(WhiteLightBean WhiteLight) {
        this.WhiteLight = WhiteLight;
    }

    public List<StRegionBean> getStRegion() {
        return stRegion;
    }

    public void setStRegion(List<StRegionBean> stRegion) {
        this.stRegion = stRegion;
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


    public static class StRegionBean implements Serializable {
        /**
         * type : 0
         * stPoints : [{"x":0,"y":0}]
         * nIvpCheckMode : 0
         */

        private int type;//0: 区域 1：绊线
        private int nIvpCheckMode;
        private List<StPointsBean> stPoints;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getNIvpCheckMode() {
            return nIvpCheckMode;
        }

        public void setNIvpCheckMode(int nIvpCheckMode) {
            this.nIvpCheckMode = nIvpCheckMode;
        }

        public List<StPointsBean> getStPoints() {
            return stPoints;
        }

        public void setStPoints(List<StPointsBean> stPoints) {
            this.stPoints = stPoints;
        }

        public static class StPointsBean implements Serializable {
            /**
             * x : 0
             * y : 0
             */

            private int x;
            private int y;

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
        }
    }
    public static class AlarmoutBean implements Serializable {
        /**
         * almout_id : 0
         * type : unknown,door,pir,smoke,gas,curtain
         * bNormallyClosed : false
         */

        private int almout_id;
        private String type;
        private boolean bNormallyClosed;

        public int getAlmout_id() {
            return almout_id;
        }

        public void setAlmout_id(int almout_id) {
            this.almout_id = almout_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isBNormallyClosed() {
            return bNormallyClosed;
        }

        public void setBNormallyClosed(boolean bNormallyClosed) {
            this.bNormallyClosed = bNormallyClosed;
        }
    }


}
