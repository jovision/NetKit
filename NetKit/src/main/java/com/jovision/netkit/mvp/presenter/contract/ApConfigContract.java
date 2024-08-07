package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.GetUserResponseDataBean;
import com.jovision.netkit.mvp.data.bean.response.ErrorBean2;
import com.jovision.netkit.mvp.data.bean.response.OctAccountModifyUserBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * 云视通2.0协议Ap配网功能
 */
public interface ApConfigContract {

    interface IApConfigModel {
        Observable<BaseBean<ErrorBean2>> octApConfig(String deviceSn, String devUser, String devPwd, String wifiName, String wifiPwd);
        Observable<BaseBean<GetUserResponseDataBean>> octAccountGetUser(String pwd);
        Observable<BaseBean<OctAccountModifyUserBean>> octAccountModifyUser(String deviceSn, int channelId, String devUser, String devPwd, String newDevUser, String newDevPwd);

    }

    interface View extends BaseView {
        void octApConfigSuccess(ErrorBean2 errorBean2);
        void octApConfigError(Throwable e);

        void octAccountGetUserSuccess(GetUserResponseDataBean getUserResponseDataBean);
        void octAccountGetUserError(Throwable e);

        void octAccountModifyUserSuccess(OctAccountModifyUserBean octAccountModifyUserBean);
        void octAccountModifyUserFailed(Throwable e);
    }
}
