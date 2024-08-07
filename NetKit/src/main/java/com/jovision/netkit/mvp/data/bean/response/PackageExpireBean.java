package com.jovision.netkit.mvp.data.bean.response;

/**
 * @ProjectName: SAAS
 * @Package: com.jovision.saas.data.bean.response
 * @ClassName: PackageExpireBean
 * @Description: java类作用描述
 * @CreateDate: 2024/5/20 09:34
 * @Version: 1.0
 */
public class PackageExpireBean {
    private String packageId;

    private int expireDays;

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public int getExpireDays() {
        return expireDays;
    }

    public void setExpireDays(int expireDays) {
        this.expireDays = expireDays;
    }
}
