package com.jovision.netkit.mvp.data.bean;

import java.util.List;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/11/21
 * 描述：
 */
public class PlayBackUrlForLocalBean {



        /**
         * jvmpUrl : jvmp://59.46.11.161:7070/vod/12421SSKNCH2?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjaGFubmVsX2lkIjowLCJkZXZpY2VfaWQiOiIxMjQyMVNTS05DSDIiLCJlbmRfdGltZSI6IjIwMjEwMTI0MTUzNTQ5IiwiZXhwaXJlX3RpbWUiOjE2MTE1MzI3MTcsImxpbmtfa2V5IjoiMTYxMTU2MTMzNzA5OTAyMTkxOHJNM0tWcGJQIiwic3RhcnRfdGltZSI6IjIwMjEwMTI0MTUzNTE0IiwidHlwZSI6InRpbWUifQ.FodJoqRakcZREA3R_4xhdN6-wkndBoui6TkxLA1G6mg
         * url : {"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxMjQyMVNTS05DSDIiLCJleHBpcmVfdGltZSI6MTYxMTUzMjcxNywibGlua19rZXkiOiIxMjQyMVNTS05DSDIxNjExNTYxMzM3MDk4NzY5NzA1Z21mb1lNb04ifQ.bAUCr-HAqEi2sis56-qOTx3dinfgcxnh1X_ngTfKcoI","deviceSn":"12421SSKNCH2","addrs":["p2p://59.46.11.161:7050/index=0/node_type=1/addr_type=2"]}
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
             * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxMjQyMVNTS05DSDIiLCJleHBpcmVfdGltZSI6MTYxMTUzMjcxNywibGlua19rZXkiOiIxMjQyMVNTS05DSDIxNjExNTYxMzM3MDk4NzY5NzA1Z21mb1lNb04ifQ.bAUCr-HAqEi2sis56-qOTx3dinfgcxnh1X_ngTfKcoI
             * deviceSn : 12421SSKNCH2
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
