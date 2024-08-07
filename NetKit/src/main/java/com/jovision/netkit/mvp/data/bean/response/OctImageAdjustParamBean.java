package com.jovision.netkit.mvp.data.bean.response;

//获取图像调节参数配置
public class OctImageAdjustParamBean {

//    {	//获取图像调节参数配置
//        "method": "image_get_adjust_param",
//            "param": {
//        "channelid":0			//通道号，从0开始。
//    },
//        "result": {
//        "contrast": 50,             //对比度，范围0-255
//                "brightness": 50,  		//亮度，范围0-255
//                "saturation": 50, //饱和度，范围0-255
//            "sharpen": 50,        //锐度，范围0-255
//                    "bEnableMI": true,    //镜像
//                    "bEnableST": true,    //翻转
//                    "rotate": 0,          //0：无旋转 1：90度 2：180度 3：270度
//                    "style": 0,          //0：标准 1：通透 2：柔和
//                    "bEnableSmartSensor": true,    //只能光敏开关
//        },
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to get image adjust parameters!"
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
        private boolean bEnableMI;
        private boolean bEnableST;
        private int rotate;
        private int style;
        private boolean bEnableSmartSensor;

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

        public boolean isbEnableMI() {
            return bEnableMI;
        }

        public void setbEnableMI(boolean bEnableMI) {
            this.bEnableMI = bEnableMI;
        }

        public boolean isbEnableST() {
            return bEnableST;
        }

        public void setbEnableST(boolean bEnableST) {
            this.bEnableST = bEnableST;
        }

        public int getRotate() {
            return rotate;
        }

        public void setRotate(int rotate) {
            this.rotate = rotate;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }

        public boolean isbEnableSmartSensor() {
            return bEnableSmartSensor;
        }

        public void setbEnableSmartSensor(boolean bEnableSmartSensor) {
            this.bEnableSmartSensor = bEnableSmartSensor;
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
