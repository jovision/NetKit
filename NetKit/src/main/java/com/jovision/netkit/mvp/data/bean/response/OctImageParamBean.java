package com.jovision.netkit.mvp.data.bean.response;

//获取图像参数
public class OctImageParamBean {

    //    {	//获取图像参数
//        "method": "image_get_param",
//            "comments": "The value of contrast, brightness, saturation and sharpen ranges from 0 to 255.",
//            "param": {
//        "channelid":0			//通道号，从0开始。
//    },
//        "result": {
//        "contrast": 50,			//对比度，范围0～255
//                "brightness": 50,		//亮度，范围0～255
//                "saturation": 50,		//饱和度，范围0～255
//                "sharpen": 50,			//锐度，范围0～255
//                "fluency": 3,           //流畅度， 范围0~6
//                "definition": 3,        //清晰度， 范围0~6
//                "noise": 3,             //降噪强度， 范围0~6
//                "smear": 3,             //拖影抑制， 范围0~6
//                "exposureMode": 0,		//0:自动曝光 1:强光抑制 2:背光补偿
//                "exposureMax": 3,       //3,6,12,25,50,100,250,500,750,1000,2000,4000,10000,100000
//                "exposureMin": 100000,
//                "antiflick": 0,			//工频抗闪 0:关闭 1：50HZ 2：60HZ
//                "scene": "indoor,outdoor,default,soft",
//                "daynightMode": "auto,alwaysDay,alwaysNight,timer",
//                "dayStart": {
//            "hour": 0,
//                    "minute": 0
//        },
//        "dayEnd": {
//            "hour": 0,
//                    "minute": 0
//        },
//        "light": 4, //光照强度(即对应界面上的日夜切换时刻)，范围：0~10,默认值4
//                "rotate": 0, //0: 无旋转 1：90度 2：180度 3：270度
//                "bEnableAWB": true,	//自动白平衡
//                "bEnableMI": true,	//镜像
//                "bEnableST": true,	//翻转
//                "bEnableNoC": false, //黑白模式
//                "bEnableWDynamic": false,	//宽动态
//                "bAutoLowFrameEn": false,	//夜视自动降帧
//                "bNightOptimization": false, //夜视优化
//                "bDefogging": false, //去雾
//                "bStarlight": false, //星光级
//                "bAutogain": false, //自动增益
//                "bBLC": false, //逆光补偿
//                "bDistortionCorrection": false, //畸变校正
//                "bDigitalstabilize": false //数字防抖
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to get image parameters!"
//    }
//    }

    private String method;
    private String comments;
    private ParamBean param;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public static class ParamBean {
        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean {
        private int contrast;
        private int brightness;
        private int saturation;
        private int sharpen;
        private int fluency;
        private int definition;
        private int noise;
        private int smear;
        private int exposureMode;
        private int exposureMax;
        private int exposureMin;
        private int antiflick;
        private String scene;
        private String daynightMode;
        private DayStartBean dayStart;
        private DayEndBean dayEnd;
        private int light;
        private int rotate;
        private boolean bEnableAWB;
        private boolean bEnableMI;
        private boolean bEnableST;
        private boolean bEnableNoC;
        private boolean bEnableWDynamic;
        private boolean bAutoLowFrameEn;
        private boolean bNightOptimization;
        private boolean bDefogging;
        private boolean bStarlight;
        private boolean bAutogain;
        private boolean bBLC;
        private boolean bDistortionCorrection;
        private boolean bDigitalstabilize;

        public int getContrast() {
            return contrast;
        }

        public void setContrast(int contrast) {
            this.contrast = contrast;
        }

        public int getBrightness() {
            return brightness;
        }

        public void setBrightness(int brightness) {
            this.brightness = brightness;
        }

        public int getSaturation() {
            return saturation;
        }

        public void setSaturation(int saturation) {
            this.saturation = saturation;
        }

        public int getSharpen() {
            return sharpen;
        }

        public void setSharpen(int sharpen) {
            this.sharpen = sharpen;
        }

        public int getFluency() {
            return fluency;
        }

        public void setFluency(int fluency) {
            this.fluency = fluency;
        }

        public int getDefinition() {
            return definition;
        }

        public void setDefinition(int definition) {
            this.definition = definition;
        }

        public int getNoise() {
            return noise;
        }

        public void setNoise(int noise) {
            this.noise = noise;
        }

        public int getSmear() {
            return smear;
        }

        public void setSmear(int smear) {
            this.smear = smear;
        }

        public int getExposureMode() {
            return exposureMode;
        }

        public void setExposureMode(int exposureMode) {
            this.exposureMode = exposureMode;
        }

        public int getExposureMax() {
            return exposureMax;
        }

        public void setExposureMax(int exposureMax) {
            this.exposureMax = exposureMax;
        }

        public int getExposureMin() {
            return exposureMin;
        }

        public void setExposureMin(int exposureMin) {
            this.exposureMin = exposureMin;
        }

        public int getAntiflick() {
            return antiflick;
        }

        public void setAntiflick(int antiflick) {
            this.antiflick = antiflick;
        }

        public String getScene() {
            return scene;
        }

        public void setScene(String scene) {
            this.scene = scene;
        }

        public String getDaynightMode() {
            return daynightMode;
        }

        public void setDaynightMode(String daynightMode) {
            this.daynightMode = daynightMode;
        }

        public DayStartBean getDayStart() {
            return dayStart;
        }

        public void setDayStart(DayStartBean dayStart) {
            this.dayStart = dayStart;
        }

        public DayEndBean getDayEnd() {
            return dayEnd;
        }

        public void setDayEnd(DayEndBean dayEnd) {
            this.dayEnd = dayEnd;
        }

        public int getLight() {
            return light;
        }

        public void setLight(int light) {
            this.light = light;
        }

        public int getRotate() {
            return rotate;
        }

        public void setRotate(int rotate) {
            this.rotate = rotate;
        }

        public boolean isBEnableAWB() {
            return bEnableAWB;
        }

        public void setBEnableAWB(boolean bEnableAWB) {
            this.bEnableAWB = bEnableAWB;
        }

        public boolean isBEnableMI() {
            return bEnableMI;
        }

        public void setBEnableMI(boolean bEnableMI) {
            this.bEnableMI = bEnableMI;
        }

        public boolean isBEnableST() {
            return bEnableST;
        }

        public void setBEnableST(boolean bEnableST) {
            this.bEnableST = bEnableST;
        }

        public boolean isBEnableNoC() {
            return bEnableNoC;
        }

        public void setBEnableNoC(boolean bEnableNoC) {
            this.bEnableNoC = bEnableNoC;
        }

        public boolean isBEnableWDynamic() {
            return bEnableWDynamic;
        }

        public void setBEnableWDynamic(boolean bEnableWDynamic) {
            this.bEnableWDynamic = bEnableWDynamic;
        }

        public boolean isBAutoLowFrameEn() {
            return bAutoLowFrameEn;
        }

        public void setBAutoLowFrameEn(boolean bAutoLowFrameEn) {
            this.bAutoLowFrameEn = bAutoLowFrameEn;
        }

        public boolean isBNightOptimization() {
            return bNightOptimization;
        }

        public void setBNightOptimization(boolean bNightOptimization) {
            this.bNightOptimization = bNightOptimization;
        }

        public boolean isBDefogging() {
            return bDefogging;
        }

        public void setBDefogging(boolean bDefogging) {
            this.bDefogging = bDefogging;
        }

        public boolean isBStarlight() {
            return bStarlight;
        }

        public void setBStarlight(boolean bStarlight) {
            this.bStarlight = bStarlight;
        }

        public boolean isBAutogain() {
            return bAutogain;
        }

        public void setBAutogain(boolean bAutogain) {
            this.bAutogain = bAutogain;
        }

        public boolean isBBLC() {
            return bBLC;
        }

        public void setBBLC(boolean bBLC) {
            this.bBLC = bBLC;
        }

        public boolean isBDistortionCorrection() {
            return bDistortionCorrection;
        }

        public void setBDistortionCorrection(boolean bDistortionCorrection) {
            this.bDistortionCorrection = bDistortionCorrection;
        }

        public boolean isBDigitalstabilize() {
            return bDigitalstabilize;
        }

        public void setBDigitalstabilize(boolean bDigitalstabilize) {
            this.bDigitalstabilize = bDigitalstabilize;
        }

        public static class DayStartBean {
            private int hour;
            private int minute;

            public int getHour() {
                return hour;
            }

            public void setHour(int hour) {
                this.hour = hour;
            }

            public int getMinute() {
                return minute;
            }

            public void setMinute(int minute) {
                this.minute = minute;
            }
        }

        public static class DayEndBean {
            private int hour;
            private int minute;

            public int getHour() {
                return hour;
            }

            public void setHour(int hour) {
                this.hour = hour;
            }

            public int getMinute() {
                return minute;
            }

            public void setMinute(int minute) {
                this.minute = minute;
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




}
