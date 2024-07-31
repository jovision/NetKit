package com.jovision.netkit.mvp.net.rto_exception;

/**
 * Created by ZHP on 2017/6/26.
 */

public class ApiException extends BaseException {


    private Object errorData;

    public ApiException(String code, String displayMessage) {
        super(code, displayMessage);
    }

    public ApiException(String code, String displayMessage,Object errorData) {
        super(code, displayMessage);
        this.errorData = errorData;
    }

    public Object getErrorData() {
        return errorData;
    }

    public void setErrorData(Object errorData) {
        this.errorData = errorData;
    }
}
