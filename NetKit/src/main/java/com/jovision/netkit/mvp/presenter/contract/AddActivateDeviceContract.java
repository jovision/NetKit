package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.uikit.BaseView;

import androidx.annotation.NonNull;
import io.reactivex.Observable;


/**
 * 添加/激活设备页对应Contract
 *
 * @author liteng
 * @date 2022/4/12
 */
public interface AddActivateDeviceContract {

    interface IModel {

        // 绑定(添加)设备
        Observable<BaseBean<EmptyBean>> addDevice(String deviceSn, String validateCode, int ct,
                                                  String deviceUser, String devicePassword,
                                                  String accessProtocol);

        // 修改云视通设备信息
        Observable<BaseBean<EmptyBean>> editDeviceYst(@NonNull String deviceSn,
                                                      String deviceName,
                                                      String deviceUser,
                                                      @NonNull String newDevPwd);
    }

    interface IView extends BaseView {

        void addDeviceSuccess();

        void addDeviceError(Throwable t);

        void editDeviceYstSuccess();

        void editDeviceYstError(Throwable e);
    }
}
