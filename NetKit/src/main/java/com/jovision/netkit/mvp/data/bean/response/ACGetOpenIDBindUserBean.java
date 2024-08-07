package com.jovision.netkit.mvp.data.bean.response;


/**
 * 未登录时查询openID是否绑定用户:返回值
 *
 * @author juyang
 * @date 2020/12/05
 */
public class ACGetOpenIDBindUserBean {

    private boolean exist;

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
    //    private int isBind;
//    private String account;
//
//    public int getIsBind() {
//        return isBind;
//    }
//
//    public void setIsBind(int isBind) {
//        this.isBind = isBind;
//    }
//
//    public String getAccount() {
//        return account;
//    }
//
//    public void setAccount(String account) {
//        this.account = account;
//    }
}
