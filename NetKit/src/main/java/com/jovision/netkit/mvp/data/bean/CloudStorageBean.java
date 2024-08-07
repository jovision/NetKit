package com.jovision.netkit.mvp.data.bean;


import com.jovision.basekit.StringUtil;

/**
 * Created by zhp on 2020/12/7
 */
public class CloudStorageBean extends BaseEntity {


    /**
     * id : 1
     * storageId : 89d822eb224a4626a07091c8515b3a12
     * storageType : 1
     * storageName : 30天动检包年套餐
     * storageDays : 30
     * expireDays : 365
     * storageDesc : 30天动检包年套餐
     * expireType : 60
     * price : 1
     */

    private String id;
    private String storageId;
    private String storageType;//套餐类型 DYNAMIC：动检 FULL：全量
    private String storageName;
    private int storageDays;
    private int expireDays;
    private String storageDesc;
    private int expireType;//存储时长类型 0：自定义 10：按周 20：半月 30：一个月 40：按季度 50：半年 60：按年
    private String price;//销售价格 单位：分  服务存放的是int类型
    private String markPrice;//标示价格 单位：分  服务存放的是int类型
    private int status;//是否启用 1：启用，2：停用
    private int defaultFlag;//套餐标记 0-普通套餐 1-默认套餐
    private int signStatus;//是否签约自动续费 0-否 1-是
    private String favorablePrice;//签约自动续费首月优惠价格 单位：分  服务存放的是int类型
    private String signDesc;//签约描述
    private boolean isCheck;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }



    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public int getStorageDays() {
        return storageDays;
    }

    public void setStorageDays(int storageDays) {
        this.storageDays = storageDays;
    }

    public int getExpireDays() {
        return expireDays;
    }

    public void setExpireDays(int expireDays) {
        this.expireDays = expireDays;
    }

    public String getStorageDesc() {
        return storageDesc;
    }

    public void setStorageDesc(String storageDesc) {
        this.storageDesc = storageDesc;
    }

    public int getExpireType() {
        return expireType;
    }

    public void setExpireType(int expireType) {
        this.expireType = expireType;
    }

    public String getPrice() {
        return price;
    }

    public String getPriceDecimal() {
        return StringUtil.getDecimalPrice(price);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public String getMarkPriceDecimal() {
        return StringUtil.getDecimalPrice(markPrice);
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(int defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public int getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(int signStatus) {
        this.signStatus = signStatus;
    }

    public String getFavorablePrice() {
        return favorablePrice;
    }

    public String getFavorablePriceDecimal() {
        return StringUtil.getDecimalPrice(favorablePrice);
    }

    public void setFavorablePrice(String favorablePrice) {
        this.favorablePrice = favorablePrice;
    }

    public String getSignDesc() {
        return signDesc;
    }

    public void setSignDesc(String signDesc) {
        this.signDesc = signDesc;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }
}
