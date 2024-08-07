package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

//定时任务列表获取
public class OctPtzTimeTaskListGetBean {
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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


//    {	//定时任务列表获取，主要获取可设置的定时任务ID及对应名称
//        "method": "ptz_time_task_list_get",
//            "param": {
//        "channelid": 0
//    },
//        "result":{
//        "list":[
//        {
//            "id": 0,	 //ID号，从0开始。
//                "name": "巡航线-1,巡航线-2,扫描,轨迹-1,轨迹-2,轨迹-3,轨迹-4,守望"
//        }
//			]
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "No exist!"
//    }
//    }


}
