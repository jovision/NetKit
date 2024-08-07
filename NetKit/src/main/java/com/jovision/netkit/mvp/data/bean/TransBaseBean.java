package com.jovision.netkit.mvp.data.bean;

public class TransBaseBean<T> extends BaseEntity {
    private String method;
    private String request_id;
    private T result;
    private TransErrorBean error;
    private int sentcnt;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public TransErrorBean getError() {
        return error;
    }

    public void setError(TransErrorBean error) {
        this.error = error;
    }

    public int getSentcnt() {
        return sentcnt;
    }

    public void setSentcnt(int sentcnt) {
        this.sentcnt = sentcnt;
    }
}
