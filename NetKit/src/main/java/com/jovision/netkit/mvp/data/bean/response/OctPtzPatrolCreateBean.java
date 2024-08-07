package com.jovision.netkit.mvp.data.bean.response;

//创建巡航
public class OctPtzPatrolCreateBean {

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

        private int patrolid;

        public int getPatrolid() {
            return patrolid;
        }

        public void setPatrolid(int patrolid) {
            this.patrolid = patrolid;
        }
    }
}
