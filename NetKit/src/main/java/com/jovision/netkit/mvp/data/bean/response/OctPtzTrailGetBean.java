package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

//获取轨迹
public class OctPtzTrailGetBean {
    private ResultBean result;
    private ErrorBean error;

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

    public static class ResultBean {
        private List<TrailListBean> trailList;

        public List<TrailListBean> getTrailList() {
            return trailList;
        }

        public void setTrailList(List<TrailListBean> trailList) {
            this.trailList = trailList;
        }

        public static class TrailListBean {
            private int trailid;
            private boolean bStart;
            private int node_cnt;

            public int getTrailid() {
                return trailid;
            }

            public void setTrailid(int trailid) {
                this.trailid = trailid;
            }

            public boolean isBStart() {
                return bStart;
            }

            public void setBStart(boolean bStart) {
                this.bStart = bStart;
            }

            public int getNode_cnt() {
                return node_cnt;
            }

            public void setNode_cnt(int node_cnt) {
                this.node_cnt = node_cnt;
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
//    {	//获取轨迹
//        "method": "ptz_trail_get",
//            "param": {
//        "channelid": 0,
//                "trailid": 0 //从0开始, -1：获取全部轨迹的信息
//    },
//        "result": {
//        "trailList": [
//        {
//            "trailid": 0,
//                "bStart": true,		//是否执行当前轨迹
//                "node_cnt": 0	//当前轨迹内录制节点数量
//        }
//            ]
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "No exist!"
//    }
//    }



}
