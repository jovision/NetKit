package com.jovision.netkit.mvp.data.bean.response;


import com.jovision.netkit.mvp.data.bean.BaseEntity;

public class ErrorBean extends BaseEntity {
    /**
     * errorcode : -1
     * message : Failed to get timing snap file data!
     */

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
