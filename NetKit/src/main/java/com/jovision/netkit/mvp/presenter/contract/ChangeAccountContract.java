package com.jovision.netkit.mvp.presenter.contract;


import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

public interface ChangeAccountContract {

    interface IChangeAccountModel {
        Observable<BaseBean<EmptyBean>> changeAccount(String switchType);
    }

    interface View extends BaseView {
        void changeAccountSuccess(EmptyBean data);
        void changeAccountError(Throwable e);
    }

}
