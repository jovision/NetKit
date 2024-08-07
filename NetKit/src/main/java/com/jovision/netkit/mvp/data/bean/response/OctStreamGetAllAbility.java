package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

//获取某个或所有通道的所有码流能力集
public class OctStreamGetAllAbility {

    //    {	//获取某个或所有通道的所有码流能力集
//        "method": "stream_get_all_ability",
//            "level":"Operator",
//            "param": {
//        "channelid": 0 //-1: 所有通道  >=0：某个通道
//    },
//        "result": {
//        "all":
//			[
//        {
//            "channelid": 0,				//通道，从0开始
//                "streamid": 0,				//码流，从0开始
//                "resolutions": [
//            {
//                "width": 1280,		//宽
//                    "height": 720,		//高
//                    "bDefault": true,	//是否默认分辨率
//                    "maxKbps": 4096,	//最大码率，单位kbps
//                    "minKbps": 128,		//最小码率，单位kbps
//                    "defKbps": 2048,	//默认码率，单位kbps
//                    "maxFr": 25,		//最大帧率
//                    "minFr": 1,			//最小帧率
//                    "defFr": 25			//默认帧率
//            }
//		            ],
//            "maxQuality": 100,			//图像质量最大值
//                "minQuality": 0,			//图像质量最小值
//                "maxNGOP": 360,				//GOP最大值
//                "minNGOP": 1,				//GOP最小值
//                "bSupportH265": false,  	//是否支持h265编码
//                "bSupportSmartEnc": false,	//是否支持smart编码
//                "bSupportEncrypt": false	//是否支持音视频数据加密
//        }
//            ]
//    },
//        "error": {
//        "errorcode": -32602,
//                "message": "Invalid Params"
//    }
//    }


    private String method;
    private String level;
    private ParamBean param;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
        private List<AllBean> all;

        public List<AllBean> getAll() {
            return all;
        }

        public void setAll(List<AllBean> all) {
            this.all = all;
        }

        public AllBean getALLBeanByStreamId(int streamId){
            AllBean allBean = null;
            if(null != all && all.size() > 0){
                for(int i = 0; i < all.size() ; i++){
                    if(streamId == all.get(i).streamid){
                        allBean = all.get(i);
                        break;
                    }
                }
            }
            return allBean;
        }





        public static class AllBean {
            private int channelid;
            private int streamid;
            private List<ResolutionsBean> resolutions;
            private int maxQuality;
            private int minQuality;
            private int maxNGOP;
            private int minNGOP;
            private boolean bSupportH265;
            private boolean bSupportSmartEnc;
            private boolean bSupportEncrypt;

            public int getChannelid() {
                return channelid;
            }

            public void setChannelid(int channelid) {
                this.channelid = channelid;
            }

            public int getStreamid() {
                return streamid;
            }

            public void setStreamid(int streamid) {
                this.streamid = streamid;
            }

            public List<ResolutionsBean> getResolutions() {
                return resolutions;
            }

            public void setResolutions(List<ResolutionsBean> resolutions) {
                this.resolutions = resolutions;
            }

            public int getMaxQuality() {
                return maxQuality;
            }

            public void setMaxQuality(int maxQuality) {
                this.maxQuality = maxQuality;
            }

            public int getMinQuality() {
                return minQuality;
            }

            public void setMinQuality(int minQuality) {
                this.minQuality = minQuality;
            }

            public int getMaxNGOP() {
                return maxNGOP;
            }

            public void setMaxNGOP(int maxNGOP) {
                this.maxNGOP = maxNGOP;
            }

            public int getMinNGOP() {
                return minNGOP;
            }

            public void setMinNGOP(int minNGOP) {
                this.minNGOP = minNGOP;
            }

            public boolean isBSupportH265() {
                return bSupportH265;
            }

            public void setBSupportH265(boolean bSupportH265) {
                this.bSupportH265 = bSupportH265;
            }

            public boolean isBSupportSmartEnc() {
                return bSupportSmartEnc;
            }

            public void setBSupportSmartEnc(boolean bSupportSmartEnc) {
                this.bSupportSmartEnc = bSupportSmartEnc;
            }

            public boolean isBSupportEncrypt() {
                return bSupportEncrypt;
            }

            public void setBSupportEncrypt(boolean bSupportEncrypt) {
                this.bSupportEncrypt = bSupportEncrypt;
            }

            public static class ResolutionsBean {
                private int width;
                private int height;
                private boolean bDefault;
                private int maxKbps;
                private int minKbps;
                private int defKbps;
                private int maxFr;
                private int minFr;
                private int defFr;

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public boolean isBDefault() {
                    return bDefault;
                }

                public void setBDefault(boolean bDefault) {
                    this.bDefault = bDefault;
                }

                public int getMaxKbps() {
                    return maxKbps;
                }

                public void setMaxKbps(int maxKbps) {
                    this.maxKbps = maxKbps;
                }

                public int getMinKbps() {
                    return minKbps;
                }

                public void setMinKbps(int minKbps) {
                    this.minKbps = minKbps;
                }

                public int getDefKbps() {
                    return defKbps;
                }

                public void setDefKbps(int defKbps) {
                    this.defKbps = defKbps;
                }

                public int getMaxFr() {
                    return maxFr;
                }

                public void setMaxFr(int maxFr) {
                    this.maxFr = maxFr;
                }

                public int getMinFr() {
                    return minFr;
                }

                public void setMinFr(int minFr) {
                    this.minFr = minFr;
                }

                public int getDefFr() {
                    return defFr;
                }

                public void setDefFr(int defFr) {
                    this.defFr = defFr;
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




}
