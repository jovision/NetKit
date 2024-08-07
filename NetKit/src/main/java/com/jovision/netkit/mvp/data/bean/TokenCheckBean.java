package com.jovision.netkit.mvp.data.bean;


import com.jovision.basekit.LogUtil;
import com.jovision.netkit.mvp.net.rto_exception.BaseException;

/**
 * Created by zhp on 2020/11/3
 */
public class TokenCheckBean {

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    public boolean isTokenOverdue() {
////        if(BaseException.ERROR_TOKEN_OVER.equals(code)){
//
//
//        if(BaseException.ERROR_TOKEN.equals(code)){//猜测这里应该是想对比token overdue的code
//            return true;
//        }
//        return false;
//    }

    public boolean isUnAuthorized() {

        if(BaseException.UNAUTHORIZED.equals(code)
                || BaseException.ACCESS_TOKEN_INVALID.equals(code)
                || BaseException.ACCESS_TOKEN_OVERDUE.equals(code)
                || BaseException.ERROR_TOKEN.equals(code)){
            LogUtil.e("Auth","code="+code+";isUnAuthorized=true");
            return true;
        }
        LogUtil.e("Auth","code="+code+";isUnAuthorized=false");

        return false;
    }

//    public boolean isPtzUnAuthorized() {
//        if(BaseException.PTZ_CONTROL_TOKEN_ERROR.equals(code)
//                || BaseException.PTZ_MOVE_START_ERROR.equals(code)){
//            LogUtil.e(HttpModule.TAG,"code="+code+";isPtzUnAuthorized=true");
//            return true;
//        }
//        LogUtil.e(HttpModule.TAG,"code="+code+";isPtzUnAuthorized=false");
//        return false;
//    }

}
