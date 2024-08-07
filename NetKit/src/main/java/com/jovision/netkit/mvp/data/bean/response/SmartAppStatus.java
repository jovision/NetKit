package com.jovision.netkit.mvp.data.bean.response;

import java.util.List;

/**
 * @ProjectName: SAAS
 * @Package: com.jovision.saas.data.bean.response
 * @ClassName: SmartAppBean
 * @Description: java类作用描述
 * @CreateDate: 2024/3/20 14:36
 * @Version: 1.0
 */
public class SmartAppStatus {

    private List<SmartAppStatusBean> items;

    public List<SmartAppStatusBean> getItems() {
        return items;
    }

    public void setItems(List<SmartAppStatusBean> items) {
        this.items = items;
    }

    public static class SmartAppStatusBean {
        //套餐类型
        private String packageType;
        //套餐状态0-未开通 1-已开通 2-已过期
        private int status;

        //开关状态 0-关闭 1开启
        private int switchStatus;

        public String getPackageType() {
            return packageType;
        }

        public void setPackageType(String packageType) {
            this.packageType = packageType;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getSwitchStatus() {
            return switchStatus;
        }

        public void setSwitchStatus(int switchStatus) {
            this.switchStatus = switchStatus;
        }
    }
}
