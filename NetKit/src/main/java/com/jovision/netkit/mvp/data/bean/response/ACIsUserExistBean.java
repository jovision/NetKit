package com.jovision.netkit.mvp.data.bean.response;

/**
 * 用户是否存在网络请求:返回值
 *
 * @author liteng
 * @date 2020/10/30
 */
public class ACIsUserExistBean {

    /**
     * exist : false
     */

    private boolean exist;

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
