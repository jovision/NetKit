package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2022/6/20
 */
public interface RemoteOpsAcceptContract {

    interface IModel {

        // 接受远程运维申请
        Observable<BaseBean<EmptyBean>> acceptRemoteOpsDev(String operationCode);

    }

    interface IView extends BaseView {

        void acceptRemoteOpsDevSuccess();

        void acceptRemoteOpsDevError(Throwable t);
    }
}
