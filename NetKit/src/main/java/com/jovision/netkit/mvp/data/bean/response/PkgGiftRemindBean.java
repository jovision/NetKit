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
public class PkgGiftRemindBean {
    private List<GiftRemindBean> items;

    public List<GiftRemindBean> getItems() {
        return items;
    }

    public void setItems(List<GiftRemindBean> items) {
        this.items = items;
    }

    public static class GiftRemindBean {
        //套餐类型
        private String packageType;
        //提醒状态0-无提醒 1-有提醒
        private int status;

        private String url;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
