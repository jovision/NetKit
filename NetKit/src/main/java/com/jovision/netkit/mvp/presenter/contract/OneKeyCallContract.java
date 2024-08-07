package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface OneKeyCallContract {

    interface IOneKeyCallModel {
        //一键呼叫，接听，挂断，拒接
        Observable<BaseBean<EmptyBean>> oneKeyCallPublic(String deviceSn, int channelId, String status);
    }

    interface View extends BaseView {
        void oneKeyCallPublicSuccess(EmptyBean emptyBean);
        void oneKeyCallPublicFailed(Throwable t);
    }
}
