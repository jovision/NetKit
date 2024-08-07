package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceProtocolBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.LanSearchDeviceContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * 局域网:开始搜索设备页对应Presenter
 *
 * @author liteng
 * @date 2022/4/12
 */
public class LanSearchDevicePresenter
        extends BasePresenter<LanSearchDeviceContract.IModel, LanSearchDeviceContract.IView> {

    @Inject
    public LanSearchDevicePresenter(LanSearchDeviceContract.IModel model, LanSearchDeviceContract.IView view) {
        super(model, view);
    }

    /**
     * 绑定(添加)设备
     *
     * @param deviceSn
     * @param validateCode
     * @param ct
     * @param deviceUser
     * @param devicePassword
     * @param accessProtocol
     */
    public void addDevice(String deviceSn, String validateCode, int ct,
                          String deviceUser, String devicePassword, String accessProtocol) {

        mModel.addDevice(deviceSn, validateCode, ct, deviceUser, devicePassword, accessProtocol)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.addDeviceSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.addDeviceError(e);
                        }
                    }
                });
    }

    /**
     * 批量查询设备接入类型
     *
     * @param deviceSns
     */
    public void getBatchDeviceProtocol(String[] deviceSns) {
        mModel.getBatchDeviceProtocol(deviceSns)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<List<DeviceProtocolBean>>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull List<DeviceProtocolBean> deviceProtocolBeanList) {
                        if (hasView()) {
                            mView.getBatchDeviceProtocolSuccess(deviceProtocolBeanList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getBatchDeviceProtocolError(e);
                        }
                    }
                });
    }

}
