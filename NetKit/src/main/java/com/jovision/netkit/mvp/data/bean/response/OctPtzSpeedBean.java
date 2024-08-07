package com.jovision.netkit.mvp.data.bean.response;

public class OctPtzSpeedBean {

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

    public class ResultBean{

        private int movespeed;

        public int getMovespeed() {
            return movespeed;
        }

        public void setMovespeed(int movespeed) {
            this.movespeed = movespeed;
        }

    }


}
