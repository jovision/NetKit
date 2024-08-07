package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

//获取巡航
public class OctPtzPatrolsGetBean {
    private ResultBean result;
    private ErrorBean error;

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

    public static class ResultBean {
        private List<PatrolsListBean> patrolsList;

        public List<PatrolsListBean> getPatrolsList() {
            return patrolsList;
        }

        public void setPatrolsList(List<PatrolsListBean> patrolsList) {
            this.patrolsList = patrolsList;
        }

        public static class PatrolsListBean {
            private int patrolid;
            private boolean bStart;
            private int speed;
            private List<PresetBean> preset;

            public int getPatrolid() {
                return patrolid;
            }

            public void setPatrolid(int patrolid) {
                this.patrolid = patrolid;
            }

            public boolean isBStart() {
                return bStart;
            }

            public void setBStart(boolean bStart) {
                this.bStart = bStart;
            }

            public int getSpeed() {
                return speed;
            }

            public void setSpeed(int speed) {
                this.speed = speed;
            }

            public List<PresetBean> getPreset() {
                return preset;
            }

            public void setPreset(List<PresetBean> preset) {
                this.preset = preset;
            }

            public static class PresetBean {
                private int presetno;
                private String name;
                private int staySeconds;

                public int getPresetno() {
                    return presetno;
                }

                public void setPresetno(int presetno) {
                    this.presetno = presetno;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getStaySeconds() {
                    return staySeconds;
                }

                public void setStaySeconds(int staySeconds) {
                    this.staySeconds = staySeconds;
                }
            }
        }
    }

    public static class ErrorBean {
        private int errorcode;
        private String message;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

//    {	//获取巡航
//        "method": "ptz_patrols_get",
//            "param": {
//        "channelid": 0,
//                "patrolid": 0 //从0开始, -1：获取全部巡航的信息
//    },
//        "result": {
//        "patrolsList": [
//        {
//            "patrolid": 0,
//                "bStart": true,		//是否正在巡航
//                "speed": 0,	//0：全速 1：1/2倍速 2：1/4倍速 3：1/8倍速 4：1/16倍速 5：1/32倍速
//                "preset":[
//            {
//                "presetno": 1,  //预置位id
//                    "name": "preset1", //预置位名称
//                    "staySeconds": 10  //预置位停留时间
//            }
//					 ]
//        }
//            ]
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "No exist!"
//    }
//    }





}
