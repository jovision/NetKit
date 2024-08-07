package com.jovision.netkit.mvp.data.bean.response;


import java.io.Serializable;
import java.util.List;

//获取某个通道的音频能力集，采样率列表取值：6000，8000，11025，16000，22050，32000，44100，48000，64000，88200，96000，192000，位宽列表取值：8，16，32，声道列表取值：1，2
public class OctAudioAbilityGetBean {


    //    {	//获取某个通道的音频能力集，采样率列表取值：6000，8000，11025，16000，22050，32000，44100，48000，64000，88200，96000，192000，位宽列表取值：8，16，32，声道列表取值：1，2
//        "method": "aduio_get_ability",
//            "param": {
//        "channelid": 0
//    },
//        "result": {
//        "encodes": [	//编码列表
//        {
//            "encType": "none,pcm,g711a,g711u,g726,aac,adpcm",	//编码格式
//                "bDefault": true,		//是否默认编码格式
//                "maxsampleRate": 16000,	//最大采样率
//                "minsampleRate": 8000,	//最小采样率
//                "defsampleRate": 8000,	//默认采样率
//                "maxbitWidth": 16,		//最大位宽
//                "minbitWidth": 8,		//最小位宽
//                "defbitWidth": 16,		//默认位宽
//                "maxchannel": 2,		//最大声道数
//                "minchannel": 1,        //最小声道数
//                "defchannel": 1,        //默认声道数
//                "maxbitRate":256,       //最大码率，aac会用到
//                "minbitRate":128,       //最小码率，aac会用到
//                "defbitRate":128,		//默认码率，aac会用到，kbps
//                "defaiGain": 50,			//默认音频输入增益
//                "defaoGain": 50			//默认音频输出增益
//        }
//            ],
//        "baiadjustSupport": false,			//是否支持音频输入校正
//                "baoadjustSupport": false			//是否支持音频输出校正
//    },
//        "error": {
//        "errorcode": -32602,
//                "message": "Invalid Params"
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

    public static class ParamBean implements Serializable {
        private int channelid;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }
    }

    public static class ResultBean implements Serializable{
        private List<EncodesBean> encodes;
        private boolean baiadjustSupport;
        private boolean baoadjustSupport;

        public List<EncodesBean> getEncodes() {
            return encodes;
        }

        public void setEncodes(List<EncodesBean> encodes) {
            this.encodes = encodes;
        }

        public boolean isBaiadjustSupport() {
            return baiadjustSupport;
        }

        public void setBaiadjustSupport(boolean baiadjustSupport) {
            this.baiadjustSupport = baiadjustSupport;
        }

        public boolean isBaoadjustSupport() {
            return baoadjustSupport;
        }

        public void setBaoadjustSupport(boolean baoadjustSupport) {
            this.baoadjustSupport = baoadjustSupport;
        }

        public static class EncodesBean implements Serializable{
            private String encType;
            private boolean bDefault;
            private int maxsampleRate;
            private int minsampleRate;
            private int defsampleRate;
            private int maxbitWidth;
            private int minbitWidth;
            private int defbitWidth;
            private int maxchannel;
            private int minchannel;
            private int defchannel;
            private int maxbitRate;
            private int minbitRate;
            private int defbitRate;
            private int defaiGain;
            private int defaoGain;

            public String getEncType() {
                return encType;
            }

            public void setEncType(String encType) {
                this.encType = encType;
            }

            public boolean isBDefault() {
                return bDefault;
            }

            public void setBDefault(boolean bDefault) {
                this.bDefault = bDefault;
            }

            public int getMaxsampleRate() {
                return maxsampleRate;
            }

            public void setMaxsampleRate(int maxsampleRate) {
                this.maxsampleRate = maxsampleRate;
            }

            public int getMinsampleRate() {
                return minsampleRate;
            }

            public void setMinsampleRate(int minsampleRate) {
                this.minsampleRate = minsampleRate;
            }

            public int getDefsampleRate() {
                return defsampleRate;
            }

            public void setDefsampleRate(int defsampleRate) {
                this.defsampleRate = defsampleRate;
            }

            public int getMaxbitWidth() {
                return maxbitWidth;
            }

            public void setMaxbitWidth(int maxbitWidth) {
                this.maxbitWidth = maxbitWidth;
            }

            public int getMinbitWidth() {
                return minbitWidth;
            }

            public void setMinbitWidth(int minbitWidth) {
                this.minbitWidth = minbitWidth;
            }

            public int getDefbitWidth() {
                return defbitWidth;
            }

            public void setDefbitWidth(int defbitWidth) {
                this.defbitWidth = defbitWidth;
            }

            public int getMaxchannel() {
                return maxchannel;
            }

            public void setMaxchannel(int maxchannel) {
                this.maxchannel = maxchannel;
            }

            public int getMinchannel() {
                return minchannel;
            }

            public void setMinchannel(int minchannel) {
                this.minchannel = minchannel;
            }

            public int getDefchannel() {
                return defchannel;
            }

            public void setDefchannel(int defchannel) {
                this.defchannel = defchannel;
            }

            public int getMaxbitRate() {
                return maxbitRate;
            }

            public void setMaxbitRate(int maxbitRate) {
                this.maxbitRate = maxbitRate;
            }

            public int getMinbitRate() {
                return minbitRate;
            }

            public void setMinbitRate(int minbitRate) {
                this.minbitRate = minbitRate;
            }

            public int getDefbitRate() {
                return defbitRate;
            }

            public void setDefbitRate(int defbitRate) {
                this.defbitRate = defbitRate;
            }

            public int getDefaiGain() {
                return defaiGain;
            }

            public void setDefaiGain(int defaiGain) {
                this.defaiGain = defaiGain;
            }

            public int getDefaoGain() {
                return defaoGain;
            }

            public void setDefaoGain(int defaoGain) {
                this.defaoGain = defaoGain;
            }
        }
    }

    public static class ErrorBean implements Serializable{
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
