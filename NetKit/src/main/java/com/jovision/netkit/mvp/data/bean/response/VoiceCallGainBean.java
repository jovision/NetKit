package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

//对讲增益对象
public class VoiceCallGainBean {
    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private ResultBean result;

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public static class ResultBean {
            private List<ChatinfoBean> chatinfo;

            public List<ChatinfoBean> getChatinfo() {
                return chatinfo;
            }

            public void setChatinfo(List<ChatinfoBean> chatinfo) {
                this.chatinfo = chatinfo;
            }

            public static class ChatinfoBean {
                private List<CallGainBean> callGain;
                private String mobileType;

                public List<CallGainBean> getCallGain() {
                    return callGain;
                }

                public void setCallGain(List<CallGainBean> callGain) {
                    this.callGain = callGain;
                }

                public String getMobileType() {
                    return mobileType;
                }

                public void setMobileType(String mobileType) {
                    this.mobileType = mobileType;
                }

                public static class CallGainBean {
                    private String deviceType;
                    private boolean enable;
                    private double appGain;

                    public String getDeviceType() {
                        return deviceType;
                    }

                    public void setDeviceType(String deviceType) {
                        this.deviceType = deviceType;
                    }

                    public boolean isEnable() {
                        return enable;
                    }

                    public void setEnable(boolean enable) {
                        this.enable = enable;
                    }

                    public double getAppGain() {
                        return appGain;
                    }

                    public void setAppGain(double appGain) {
                        this.appGain = appGain;
                    }
                }
            }
        }
    }


//    {"code":1000,"msg":"OK","data":{"result":{"chatinfo":[{"callGain":[{"deviceType":"JVS-T-X43S-4GZ(2.7-13.5mm),R1","enable":true,"appGain":4.0}],"mobileType":"xiaomi"},{"callGain":[{"deviceType":"JVS-T-X43S-4GZ(2.7-13.5mm),R1","enable":true,"appGain":4.0}],"mobileType":"vivo"},{"callGain":[{"deviceType":"JVS-T-X43S-4GZ(2.7-13.5mm),R1","enable":true,"appGain":4.0}],"mobileType":"oppo"}]}}}



}
