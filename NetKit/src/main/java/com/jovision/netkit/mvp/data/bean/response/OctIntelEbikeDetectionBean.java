package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

/**
 * 2.0电瓶车检测参数获取
 */
public class OctIntelEbikeDetectionBean implements Serializable {

    //    {	//电瓶车检测参数获取
//        "method": "intelligence_ebike_detection_get_param",
//            "param": {
//        "channelid": 0
//    },
//        "result": {
//        "enable": false,	//算法开关
//                "sensitivity":60,	//灵敏度，0-100
//                "alarm_defence_plan_id":1,	//布防时间计划id，-1表示未关联
//                "alarm_link_id":1,			//报警联动id，-1表示未关联
//                "display_region": false,	//显示检测区域和目标区域
//                "max_region_cnt": 4,			//最大区域个数
//                "everyregion_max_point_cnt": 4,	//每个区域最大点个数
//                "regions":
//			[
//        {
//            "points": [
//            {
//                "x": 0,		//0-65535，坐标以65535为最大参考值，注意转换
//                    "y": 0		//0-65535，坐标以65535为最大参考值，注意转换
//            }
//					]
//        }
//			]
//    },
//        "error": {
//        "errorcode": 0
//    }
//    }


    private String method;
    private ParamBean param;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ParamBean getParam() {
        return param;
    }

    public void setParam(ParamBean param) {
        this.param = param;
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

    public static class ParamBean implements Serializable{
        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean implements Serializable{
        private boolean enable;
        private int sensitivity;
        private int alarm_link_id;//报警联动计划id
        private int alarm_defence_plan_id;//布防时间计划id
        private boolean display_region;
        private int max_region_cnt;
        private int everyregion_max_point_cnt;
        private List<RegionsBean> regions;


        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public int getSensitivity() {
            return sensitivity;
        }

        public void setSensitivity(int sensitivity) {
            this.sensitivity = sensitivity;
        }

        public int getAlarm_defence_plan_id() {
            return alarm_defence_plan_id;
        }

        public void setAlarm_defence_plan_id(int alarm_defence_plan_id) {
            this.alarm_defence_plan_id = alarm_defence_plan_id;
        }

        public int getAlarm_link_id() {
            return alarm_link_id;
        }

        public void setAlarm_link_id(int alarm_link_id) {
            this.alarm_link_id = alarm_link_id;
        }

        public boolean isDisplay_region() {
            return display_region;
        }

        public void setDisplay_region(boolean display_region) {
            this.display_region = display_region;
        }

        public int getMax_region_cnt() {
            return max_region_cnt;
        }

        public void setMax_region_cnt(int max_region_cnt) {
            this.max_region_cnt = max_region_cnt;
        }

        public int getEveryregion_max_point_cnt() {
            return everyregion_max_point_cnt;
        }

        public void setEveryregion_max_point_cnt(int everyregion_max_point_cnt) {
            this.everyregion_max_point_cnt = everyregion_max_point_cnt;
        }

        public List<RegionsBean> getRegions() {
            return regions;
        }

        public void setRegions(List<RegionsBean> regions) {
            this.regions = regions;
        }

        public static class RegionsBean implements Serializable{
            private List<PointsBean> points;

            public List<PointsBean> getPoints() {
                return points;
            }

            public void setPoints(List<PointsBean> points) {
                this.points = points;
            }

            public static class PointsBean implements Serializable{
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
    }

    public static class ErrorBean implements Serializable{
        private int errorcode;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }
    }




}
