package com.jovision.netkit.mvp.data.bean;


/**
 * Created by zhp on 2020/11/3
 */
public class TokenLifeBean {

    private String code;
    private String msg;
    private LoginResponseBean data;

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

    public LoginResponseBean getData() {
        return data;
    }

    public void setData(LoginResponseBean data) {
        this.data = data;
    }

//    public boolean isTokenOverdue() {
//        if(BaseException.ERROR_TOKEN_OVER.equals(code)){
//            return true;
//        }
//        return false;
//    }
}
