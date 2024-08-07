package com.jovision.netkit.mvp.data.bean.response;

/**
 * 图片回放查询图片列表对象
 */
public class SnapFileListBean {
    /**
     * method : snap_file_list_get
     * result : {"total_cnt":1000,"snap_list":[{"name":"T01072123.jpg","path":"/progs/rec/00/20190808/T01072123.jpg","file_size":4096,"time":{"year":2019,"month":9,"day":7,"hour":18,"min":47,"sec":10},"snap_type":84}]}
     * error : {"errorcode":-1,"message":"Failed to get timing snap file!"}
     */

    private String method;
    private ResultBeanX result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ResultBeanX getResult() {
        return result;
    }

    public void setResult(ResultBeanX result) {
        this.result = result;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }


//    {	//获取定时抓拍图片列表
//        "method": "snap_file_list_get",
//            "param": {
//        "channelid": 0,		//通道号，从0开始。-1表示所有
//                "start_time":{					//开始时间
//            "year": 2019,
//                    "month": 8,
//                    "day": 7,
//                    "hour": 18,				//预留，目前时分秒未处理
//                    "min": 47,
//                    "sec": 10
//        },
//        "end_time":{					//结束时间
//            "year": 2019,
//                    "month": 9,
//                    "day": 7,
//                    "hour": 18,				//预留，目前时分秒未处理
//                    "min": 47,
//                    "sec": 10
//        },
//        "page":0,			//页码，从0开始
//                "page_size":500		//每页多少条数据，设备有最大值，超过最大值会按照最大值给结果
//    },
//        "result": {
//        "total_cnt":1000,	//检索时间内一共有多少条数据
//                "snap_list": [
//        {
//            "name": "T01072123.jpg",	//抓拍文件名称，与录像名称含义一致，依次为抓拍类型，通道号，时间
//                "path": "/progs/rec/00/20190808/T01072123.jpg",		//带文件名称的路径
//                "file_size": 4096,			//文件大小
//                "time":{					//抓拍时间
//            "year": 2019,
//                    "month": 9,
//                    "day": 7,
//                    "hour": 18,
//                    "min": 47,
//                    "sec": 10
//        },
//            "snap_type": 84				//抓拍类型
//        }
//			]
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to get timing snap file!"
//    }
//    }






}
