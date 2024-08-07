package com.jovision.netkit.mvp.presenter.contract;


import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceProtocolBean;
import com.jovision.netkit.mvp.data.bean.response.ShareDetailBean;
import com.jovision.uikit.BaseView;

import java.util.TreeMap;

import io.reactivex.Observable;

/**
 * @author liteng
 * @date 2022/4/2
 */
public interface CaptureContract {

    interface IModel {

        Observable<BaseBean<EmptyBean>> addDevice(String deviceSn, String validateCode, int ct, String deviceUser, String devicePassword, String accessProtocol);

        Observable<BaseBean<DeviceProtocolBean>> getDeviceProtocol(String deviceSn);

        //扫码登录（V2）
        Observable<BaseBean<EmptyBean>> qrLogin(String qrCode);

        //扫码后确认或取消登录（V2）
        Observable<BaseBean<EmptyBean>> qrLoginConform(String qrCode,boolean confirmed);


        // 查询二维码分享详情
        Observable<BaseBean<ShareDetailBean>> getShareQRCodeDetail(String shareToken);

    }

    interface IView extends BaseView {

        void addDeviceSuccess();

        void addDeviceError(Throwable e);

        void getDeviceProtocolSuccess(DeviceProtocolBean deviceProtocolBean);

        void getDeviceProtocolError(Throwable e);

        void qrLoginSuccess();
        void qrLoginError(Throwable e);

        void qrLoginConformSuccess();
        void qrLoginConformError(Throwable e);

        void getShareQRCodeDetailSuccess(ShareDetailBean responseData);

        void getShareQRCodeDetailError(Throwable e);
    }
}
