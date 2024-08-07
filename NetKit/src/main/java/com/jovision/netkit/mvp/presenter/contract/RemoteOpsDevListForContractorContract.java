package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.WaitRemoteOpsDeviceResponseBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2022/6/20
 */
public interface RemoteOpsDevListForContractorContract {
    interface IModel {

        // 获取待运维设备列表
        Observable<BaseBean<WaitRemoteOpsDeviceResponseBean>> getRemoteOpsDevListForContractor();

    }

    interface IView extends BaseView {

        void getRemoteOpsDevListForContractorSuccess(WaitRemoteOpsDeviceResponseBean responseBean);

        void getRemoteOpsDevListForContractorError(Throwable t);

    }
}
