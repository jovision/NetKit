package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;

/**
 * 云视通2.0移动追踪报警bean类
 */
public class OctMotionTrackBean implements Serializable {

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
         * digest : b6338504bf53ed7b18af6cf45546f345
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
        private boolean track_enable;
        private int track_sens;
        private int track_sec;
        private boolean btrack_record;
        private boolean smd_enable;//是否使能人形跟踪


        public int getTrack_sec() {
            return track_sec;
        }

        public void setTrack_sec(int track_sec) {
            this.track_sec = track_sec;
        }

        public boolean isBtrack_record() {
            return btrack_record;
        }

        public void setBtrack_record(boolean btrack_record) {
            this.btrack_record = btrack_record;
        }

        public int getTrack_sens() {
            return track_sens;
        }

        public void setTrack_sens(int track_sens) {
            this.track_sens = track_sens;
        }

        public boolean isTrack_enable() {
            return track_enable;
        }

        public void setTrack_enable(boolean track_enable) {
            this.track_enable = track_enable;
        }

        public boolean isSmd_enable() {
            return smd_enable;
        }

        public void setSmd_enable(boolean smd_enable) {
            this.smd_enable = smd_enable;
        }
    }

    public static class ErrorBean implements Serializable {
        /**
         * errorcode : 0
         */

        private int errorcode;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }
    }
}
