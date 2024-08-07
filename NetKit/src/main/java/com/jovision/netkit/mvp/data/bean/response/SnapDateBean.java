package com.jovision.netkit.mvp.data.bean.response;

/**
 * 有图片回放的日期
 */
public class SnapDateBean {
    /**
     * method : snap_file_data_list_get
     * result : {"data_list":[{"year":2019,"month":9,"day":7}]}
     * error : {"errorcode":-1,"message":"Failed to get timing snap file data!"}
     */

    private String method;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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


//    {	//获取定时抓拍有图片的日期
//        "method": "snap_file_data_list_get",
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
//        }
//    },
//        "result": {
//        "data_list": [
//        {
//            "year": 2019,
//                "month": 9,
//                "day": 7
//        }
//			]
//    },
//        "error": {
//        "errorcode": -1,
//                "message": "Failed to get timing snap file data!"
//    }
//    }












}
