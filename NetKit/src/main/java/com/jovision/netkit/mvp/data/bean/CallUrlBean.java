package com.jovision.netkit.mvp.data.bean;

import java.util.List;

/**
 * Created by zhp on 2020/11/12
 */
public class CallUrlBean {

    /**
     * url : {"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxMjQyMVNTOEpZQkYiLCJleHBpcmVfdGltZSI6MTYwNTE0MTUyNiwibGlua19rZXkiOiIxMjQyMVNTOEpZQkYxNjA1MTcwMTQ2NjMyMzE4NTY2Z0djU1JKa3IifQ.FVdp-U9s7FypRCZFpUuXZNyaNlsgCHUgz4Sl3lqy8z8","addrs":["p2p://59.46.11.161:7050/index=0/node_type=1/addr_type=2"],"deviceSn":"12421SS8JYBF"}
     * jvmpUrl : jvmp://59.46.11.161:7070/talk/12421SS8JYBF?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjaGFubmVsX2lkIjowLCJkZXZpY2VfaWQiOiIxMjQyMVNTOEpZQkYiLCJleHBpcmVfdGltZSI6MTYwNTE0MTUyNiwibGlua19rZXkiOiIxNjA1MTcwMTQ2NjMyODQ5NTM5MHA1QnR4MUEifQ.K3ZV9ctRlnHOPnd2XBMRUVtXqW8Ik0eGiYzPPNWCUEI
     */

    private UrlBean url;
    private String jvmpUrl;

    public UrlBean getUrl() {
        return url;
    }

    public void setUrl(UrlBean url) {
        this.url = url;
    }

    public String getJvmpUrl() {
        return jvmpUrl;
    }

    public void setJvmpUrl(String jvmpUrl) {
        this.jvmpUrl = jvmpUrl;
    }

    public static class UrlBean {
        /**
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxMjQyMVNTOEpZQkYiLCJleHBpcmVfdGltZSI6MTYwNTE0MTUyNiwibGlua19rZXkiOiIxMjQyMVNTOEpZQkYxNjA1MTcwMTQ2NjMyMzE4NTY2Z0djU1JKa3IifQ.FVdp-U9s7FypRCZFpUuXZNyaNlsgCHUgz4Sl3lqy8z8
         * addrs : ["p2p://59.46.11.161:7050/index=0/node_type=1/addr_type=2"]
         * deviceSn : 12421SS8JYBF
         */

        private String token;
        private String deviceSn;
        private List<String> addrs;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getDeviceSn() {
            return deviceSn;
        }

        public void setDeviceSn(String deviceSn) {
            this.deviceSn = deviceSn;
        }

        public List<String> getAddrs() {
            return addrs;
        }

        public void setAddrs(List<String> addrs) {
            this.addrs = addrs;
        }
    }
}
