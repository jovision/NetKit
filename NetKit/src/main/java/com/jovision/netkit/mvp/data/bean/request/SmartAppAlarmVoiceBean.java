package com.jovision.netkit.mvp.data.bean.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @ProjectName: SAAS
 * @Package: com.jovision.saas.data.bean.request
 * @ClassName: SmartAppAlarmVoiceBean
 * @Description: java类作用描述
 * @CreateDate: 2024/6/9 16:36
 * @Version: 1.0
 */
public class SmartAppAlarmVoiceBean {

    @SerializedName("package")
    private String packageX;
    private String method;
    private Param param;

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

    public Param getParam() {
        return param;
    }

    public void setParam(Param param) {
        this.param = param;
    }

    public static class Param implements Serializable {
        private String linkage;
        private  String alarm_type;
        private String sound_file;

//        private boolean enable;


        public String getLinkage() {
            return linkage;
        }

        public void setLinkage(String linkage) {
            this.linkage = linkage;
        }

        public String getAlarm_type() {
            return alarm_type;
        }

        public void setAlarm_type(String alarm_type) {
            this.alarm_type = alarm_type;
        }

        public String getSound_file() {
            return sound_file;
        }

        public void setSound_file(String sound_file) {
            this.sound_file = sound_file;
        }
    }
}
