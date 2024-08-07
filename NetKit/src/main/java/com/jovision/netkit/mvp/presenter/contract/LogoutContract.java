package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

public interface LogoutContract {
    interface ILogoutModel{
        Observable<BaseBean<EmptyBean>> ACLogout();

        Observable<BaseBean<EmptyBean>> stopPushMsg();


    }
    interface View extends BaseView {
        void ACLogoutSuccess();
        void ACLogoutError();

        void stopPushMsgSuccess();
        void stopPushMsgError();
    }
}
