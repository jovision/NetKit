package com.jovision.netkit.mvp.data.bean;

import java.util.List;

//枪球的报警返回对象
public class PlayBackUrlForGunBallLocalBean {



    /**
     * jvmpUrl : jvmp://59.46.11.161:7070/vod/12421SSKNCH2?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjaGFubmVsX2lkIjowLCJkZXZpY2VfaWQiOiIxMjQyMVNTS05DSDIiLCJlbmRfdGltZSI6IjIwMjEwMTI0MTUzNTQ5IiwiZXhwaXJlX3RpbWUiOjE2MTE1MzI3MTcsImxpbmtfa2V5IjoiMTYxMTU2MTMzNzA5OTAyMTkxOHJNM0tWcGJQIiwic3RhcnRfdGltZSI6IjIwMjEwMTI0MTUzNTE0IiwidHlwZSI6InRpbWUifQ.FodJoqRakcZREA3R_4xhdN6-wkndBoui6TkxLA1G6mg
     * url : {"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxMjQyMVNTS05DSDIiLCJleHBpcmVfdGltZSI6MTYxMTUzMjcxNywibGlua19rZXkiOiIxMjQyMVNTS05DSDIxNjExNTYxMzM3MDk4NzY5NzA1Z21mb1lNb04ifQ.bAUCr-HAqEi2sis56-qOTx3dinfgcxnh1X_ngTfKcoI","deviceSn":"12421SSKNCH2","addrs":["p2p://59.46.11.161:7050/index=0/node_type=1/addr_type=2"]}
     */


    private DomeUrl domeUrl;//球机
    private BulletUrl bulletUrl;//枪机

    public DomeUrl getDomeUrl() {
        return domeUrl;
    }

    public void setDomeUrl(DomeUrl domeUrl) {
        this.domeUrl = domeUrl;
    }

    public BulletUrl getBulletUrl() {
        return bulletUrl;
    }

    public void setBulletUrl(BulletUrl bulletUrl) {
        this.bulletUrl = bulletUrl;
    }

    //枪机
    public class BulletUrl{
        private String jvmpUrl;
        private int channelId;
        private PlayBackUrlForLocalBean.UrlBean url;

        public String getJvmpUrl() {
            return jvmpUrl;
        }

        public void setJvmpUrl(String jvmpUrl) {
            this.jvmpUrl = jvmpUrl;
        }

        public PlayBackUrlForLocalBean.UrlBean getUrl() {
            return url;
        }

        public void setUrl(PlayBackUrlForLocalBean.UrlBean url) {
            this.url = url;
        }


        public int getChannelId() {
            return channelId;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }

    }


    //球机
    public class DomeUrl{
        private String jvmpUrl;
        private int channelId;
        private PlayBackUrlForLocalBean.UrlBean url;

        public String getJvmpUrl() {
            return jvmpUrl;
        }

        public void setJvmpUrl(String jvmpUrl) {
            this.jvmpUrl = jvmpUrl;
        }

        public PlayBackUrlForLocalBean.UrlBean getUrl() {
            return url;
        }

        public void setUrl(PlayBackUrlForLocalBean.UrlBean url) {
            this.url = url;
        }


        public int getChannelId() {
            return channelId;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }
    }




    public class UrlBean {
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
