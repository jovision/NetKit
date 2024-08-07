package com.jovision.netkit.mvp.data.bean.response;

public class OctBaseResponseBean {
    private String method;
    private int sentcnt;
    private UserBean user;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getSentcnt() {
        return sentcnt;
    }

    public void setSentcnt(int sentcnt) {
        this.sentcnt = sentcnt;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }

    public static class UserBean {
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


//    {
//        "method":"ptz_preset_set", "sentcnt":1, "user":{
//        "name":"admin", "digest":"9749b64361b2661c4df27ff883c22037"
//    },"error":{
//        "errorcode":0
//    }
//    }



}
