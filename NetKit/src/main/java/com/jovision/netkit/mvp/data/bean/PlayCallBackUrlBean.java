package com.jovision.netkit.mvp.data.bean;

import java.util.List;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/11/12
 * 描述：
 */
public class PlayCallBackUrlBean {

    /**
     * jvmpUrl : jvmp://59.46.11.161:7070/vod/12421SSB6N87?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjaGFubmVsX2lkIjowLCJkZXZpY2VfaWQiOiIxMjQyMVNTQjZOODciLCJlbmRfdGltZSI6IjIwMjAxMTExMjM1OTU5IiwiZXhwaXJlX3RpbWUiOjE2MDUxNDA2OTAsImxpbmtfa2V5IjoiMTYwNTE2OTMxMDI2NDgxODEyNzF0YWFidmtKIiwic3RhcnRfdGltZSI6IjIwMjAxMTExMDAwMDAwIiwidHlwZSI6InRpbWUifQ.qKMPWumdoia8jU6zsFqvmMdwCC9AIii_IeZb4qc4yeg
     * url : {"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxMjQyMVNTQjZOODciLCJleHBpcmVfdGltZSI6MTYwNTE0MDY5MCwibGlua19rZXkiOiIxMjQyMVNTQjZOODcxNjA1MTY5MzEwMjY0NTQzMjUzS283aWJqWjQifQ.pmv8sOeeMNVSyia-Ux2nMiKbrXakB2EzeQG-HkZ8Os0","deviceSn":"12421SSB6N87","addrs":["p2p://59.46.11.161:7050/index=0/node_type=1/addr_type=2"]}
     */

    private String jvmpUrl;
    private UrlBean url;

    public String getJvmpUrl() {
        return jvmpUrl;
    }

    public void setJvmpUrl(String jvmpUrl) {
        this.jvmpUrl = jvmpUrl;
    }

    public UrlBean getUrl() {
        return url;
    }

    public void setUrl(UrlBean url) {
        this.url = url;
    }

    public static class UrlBean {
        /**
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxMjQyMVNTQjZOODciLCJleHBpcmVfdGltZSI6MTYwNTE0MDY5MCwibGlua19rZXkiOiIxMjQyMVNTQjZOODcxNjA1MTY5MzEwMjY0NTQzMjUzS283aWJqWjQifQ.pmv8sOeeMNVSyia-Ux2nMiKbrXakB2EzeQG-HkZ8Os0
         * deviceSn : 12421SSB6N87
         * addrs : ["p2p://59.46.11.161:7050/index=0/node_type=1/addr_type=2"]
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
