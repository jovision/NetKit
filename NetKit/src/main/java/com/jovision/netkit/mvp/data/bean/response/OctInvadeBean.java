package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

/**
 * CloudSEE 2.0 绊线/区域入侵报警
 */
public class OctInvadeBean implements Serializable {


    /**
     * method : ivp_rl_get_param
     * user : {"name":"admin","digest":"4acd64d6e06f0fabe0e4011cd85ae43b"}
     * result : {"bEnable":false,"nSen":0,"nThreshold":0,"nStayTime":0,"bDrawFrame":false,"bFlushFrame":false,"bMarkObject":false,"bMarkAll":false,"maxRectW":1000,"maxRectH":1000,"maxRegion":4,"stRegion":[{"type":0,"stPoints":[{"x":0,"y":0}],"nIvpCheckMode":0}],"task":{"bsos":false,"bAllTime":true,"maxTime":8,"time":[{"week":"Mon,Tues,Wed,Thur,Fri,Sat,Sun,EveryDay","begin_hour":12,"begin_min":20,"begin_sec":30,"end_hour":12,"end_min":30,"end_sec":40}]},"bOutClient":false,"bOutEmail":false,"bEnableRecord":false,"bAlarmSoundEnable":false,"WhiteLight":{"bEnable":false,"Strength":0},"alarmout":[{"almout_id":0,"type":"unknown,door,pir,smoke,gas,curtain","bNormallyClosed":false}]}
     * error : {"errorcode":-1}
     */

    private String method;
    private UserBean user;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }

    public static class UserBean implements Serializable {
        /**
         * name : admin
         * digest : 4acd64d6e06f0fabe0e4011cd85ae43b
         */

        private String name;
        private String digest;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }
    }

    public static class ResultBean implements Serializable {
        /**
         * bEnable : false
         * nSen : 0
         * nThreshold : 0
         * nStayTime : 0
         * bDrawFrame : false
         * bFlushFrame : false
         * bMarkObject : false
         * bMarkAll : false
         * maxRectW : 1000
         * maxRectH : 1000
         * maxRegion : 4
         * stRegion : [{"type":0,"stPoints":[{"x":0,"y":0}],"nIvpCheckMode":0}]
         * task : {"bsos":false,"bAllTime":true,"maxTime":8,"time":[{"week":"Mon,Tues,Wed,Thur,Fri,Sat,Sun,EveryDay","begin_hour":12,"begin_min":20,"begin_sec":30,"end_hour":12,"end_min":30,"end_sec":40}]}
         * bOutClient : false
         * bOutEmail : false
         * bEnableRecord : false
         * bAlarmSoundEnable : false
         * WhiteLight : {"bEnable":false,"Strength":0}
         * alarmout : [{"almout_id":0,"type":"unknown,door,pir,smoke,gas,curtain","bNormallyClosed":false}]
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
        private OctAlarmTask task;
        private boolean bOutClient;
        private boolean bOutEmail;
        private boolean bEnableRecord;
        private boolean bAlarmSoundEnable;
        private WhiteLightBean WhiteLight;
        private List<StRegionBean> stRegion;
        private List<AlarmoutBean> alarmout;
        private int alarm_link_id;//报警联动计划id
        private int alarm_defence_plan_id;//布防时间计划id


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

        public OctAlarmTask getTask() {
            return task;
        }

        public void setTask(OctAlarmTask task) {
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

        public List<AlarmoutBean> getAlarmout() {
            return alarmout;
        }

        public void setAlarmout(List<AlarmoutBean> alarmout) {
            this.alarmout = alarmout;
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

        public static class StRegionBean implements Serializable {
            /**
             * type : 0
             * stPoints : [{"x":0,"y":0}]
             * nIvpCheckMode : 0
             */

            private int type;
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

    public static class ErrorBean implements Serializable {
        /**
         * errorcode : -1
         */

        private int errorcode;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }
    }

    @Override
    public String toString() {
        return "OctInvade{" +
                "method='" + method + '\'' +
                ", user=" + user +
                ", result=" + result +
                ", error=" + error +
                '}';
    }
}
