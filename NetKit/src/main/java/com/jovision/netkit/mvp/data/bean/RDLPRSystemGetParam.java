package com.jovision.netkit.mvp.data.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//车牌识别 req_data:
public class RDLPRSystemGetParam implements Serializable {

    //    {
//        "package":"LPRSystem",
//            "method": "get_param",
//            "param": {
//    },
//        "result": {
//        "enable": false,	//算法开关
//                "plate_width": 70,       // 车牌识别大小, 0-100，以界面绘制的宽pw与显示的分辨率w的百分比比值, pw / w * 100，注意转换
//                "confidence": 50,   // 置信度 0-100
//                "det_mode":"track,filter",	// 检测模式：track 跟踪检测， filter 过滤检测
//                "OSD":{
//            "enable":true,          // OSD叠加
//                    //plate_number: 车牌号, plate_type:车牌类型, vehicle_type:车辆类型, vehicle_color:车辆颜色, vehicle_orientation:车辆朝向
//                    "content":["plate_number", "plate_type", "vehicle_type", "vehicle_color", "vehicle_orientation"],
//            "position":{
//                "x": 0,		//0-65535，坐标以65535为最大参考值，注意转换
//                        "y": 0		//0-65535，坐标以65535为最大参考值，注意转换
//            },
//            "color":"white,yellow,green,blue"      // OSD颜色 white 白色, yellow 黄色, green 绿色, blue 蓝色
//        },
//        "display_region": false,	// 显示检测区域
//                "max_region_cnt": 1,			//最大区域个数
//                "everyregion_max_point_cnt": 10,	//每个区域最大点个数
//                "regions":
//        [
//        {
//            "points": [
//            {
//                "x": 0,		//0-65535，坐标以65535为最大参考值，注意转换
//                    "y": 0		//0-65535，坐标以65535为最大参考值，注意转换
//            }
//                ]
//        }
//        ]
//    }
//    }


//    {"package":"LPRSystem","method":"get_param","result":{"enable":1,"plate_width":0,"confidence":50,"det_mode":"filter","OSD":{"enable":1,"content":["plate_type","vehicle_type","vehicle_color","vehicle_orientation"],"position":{"x":0,"y":0},"color":"blue"},"display_region":1,"regions":[{"points":[]}]},"error":{"errorcode":0}}

    @SerializedName("package")
    private String packageX;
    private String method;
    private ParamBean param;
    private ResultBean result;

    public String getPackageX() {
        return packageX;
    }

    public void setPackageX(String packageX) {
        this.packageX = packageX;
    }

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

    public static class ParamBean implements Serializable {
    }

    public static class ResultBean implements Serializable {

        private boolean enable;
        private int plate_width;
        private int confidence;
        private String det_mode;
        private OSDBean OSD;
        private boolean display_region;
        private int max_region_cnt;
        private int everyregion_max_point_cnt;
        private int maxRectW = 65535;
        private int maxRectH = 65535;
        private List<RegionsBean> regions;

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public int getPlate_width() {
            return plate_width;
        }

        public void setPlate_width(int plate_width) {
            this.plate_width = plate_width;
        }

        public int getConfidence() {
            return confidence;
        }

        public void setConfidence(int confidence) {
            this.confidence = confidence;
        }

        public String getDet_mode() {
            return det_mode;
        }

        public void setDet_mode(String det_mode) {
            this.det_mode = det_mode;
        }

        public OSDBean getOSD() {
            return OSD;
        }

        public void setOSD(OSDBean OSD) {
            this.OSD = OSD;
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

        public static class OSDBean implements Serializable {
            private boolean enable;
            private List<String> content;
            private PositionBean position;
            private String color;

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public List<String> getContent() {
                return content;
            }

            public void setContent(List<String> content) {
                this.content = content;
            }

            public PositionBean getPosition() {
                return position;
            }

            public void setPosition(PositionBean position) {
                this.position = position;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public static class PositionBean implements Serializable {
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

                public PositionBean (int x,int y){
                    this.x = x;
                    this.y = y;
                }
            }
        }

        public static class RegionsBean implements Serializable {
            private List<PointsBean> points;

            public List<PointsBean> getPoints() {
                return points;
            }

            public void setPoints(List<PointsBean> points) {
                this.points = points;
            }

            public static class PointsBean implements Serializable {
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

}
