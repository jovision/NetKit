package com.jovision.netkit.mvp.data.bean.response;


import java.util.List;

//定时任务获取
public class OctPtzTimeTaskGetBean {
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
        private List<TaskBean> task;

        public List<TaskBean> getTask() {
            return task;
        }

        public void setTask(List<TaskBean> task) {
            this.task = task;
        }

        public static class TaskBean {
            private int taskid;
            private boolean bEnable;
            private int begin_hour;
            private int begin_min;
            private int end_hour;
            private int end_min;
            private int list_id;

            public int getTaskid() {
                return taskid;
            }

            public void setTaskid(int taskid) {
                this.taskid = taskid;
            }

            public boolean isBEnable() {
                return bEnable;
            }

            public void setBEnable(boolean bEnable) {
                this.bEnable = bEnable;
            }

            public int getBegin_hour() {
                return begin_hour;
            }

            public void setBegin_hour(int begin_hour) {
                this.begin_hour = begin_hour;
            }

            public int getBegin_min() {
                return begin_min;
            }

            public void setBegin_min(int begin_min) {
                this.begin_min = begin_min;
            }

            public int getEnd_hour() {
                return end_hour;
            }

            public void setEnd_hour(int end_hour) {
                this.end_hour = end_hour;
            }

            public int getEnd_min() {
                return end_min;
            }

            public void setEnd_min(int end_min) {
                this.end_min = end_min;
            }

            public int getList_id() {
                return list_id;
            }

            public void setList_id(int list_id) {
                this.list_id = list_id;
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


//    {	//定时任务获取
//        "method": "ptz_time_task_get",
//            "param": {
//        "channelid": 0,
//                "taskid": 0	//定时任务编号，从0开始。-1，获取所有
//    },
//        "result":{
//        "task":[
//        {
//            "taskid": 0,		//定时任务编号，从0开始。
//                "bEnable": false,   //是否使能
//                "begin_hour": 12,	//开始小时
//                "begin_min": 20,	//开始分钟
//                "end_hour": 12,		//结束小时
//                "end_min": 30,		//结束分钟
//                "list_id": 0     	//任务id，与ptz_time_task_list_get获取的相对应
//        }
//			]
//    },
//        "error": {}
//    }

}
