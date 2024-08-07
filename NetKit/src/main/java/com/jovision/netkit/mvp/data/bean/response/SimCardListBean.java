package com.jovision.netkit.mvp.data.bean.response;

import java.io.Serializable;
import java.util.List;

//获取4G卡列表
public class SimCardListBean implements Serializable {

    private String method;
    private String level;
    private ParamBean param;
    private ResultBean result;
    private ErrorBean error;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ParamBean getParam() {
        return param;
    }

    public void setParam(ParamBean param) {
        this.param = param;
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

    public static class ParamBean implements Serializable {
    }

    public static class ResultBean implements Serializable {
        private int count;
        private List<SimCardBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<SimCardBean> getList() {
            return list;
        }

        public void setList(List<SimCardBean> list) {
            this.list = list;
        }
    }

    public static class SimCardBean implements Serializable {
        private int cardSlotId;
        private String iccid;
        private int quality;
        private String carrier;
        private boolean bUsing;

        public int getCardSlotId() {
            return cardSlotId;
        }

        public void setCardSlotId(int cardSlotId) {
            this.cardSlotId = cardSlotId;
        }

        public String getIccid() {
            return iccid;
        }

        public void setIccid(String iccid) {
            this.iccid = iccid;
        }

        public int getQuality() {
            return quality;
        }

        public void setQuality(int quality) {
            this.quality = quality;
        }

        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        public boolean isbUsing() {
            return bUsing;
        }

        public void setbUsing(boolean bUsing) {
            this.bUsing = bUsing;
        }
    }

    public static class ErrorBean implements Serializable {
        private int errorcode;

        public int getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(int errorcode) {
            this.errorcode = errorcode;
        }
    }

}
