package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.Permission;
import com.jovision.netkit.mvp.data.bean.response.ShareQrCodeBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * 共享设备二维码页对应Contract
 *
 * @author liteng
 * @date 2022/4/2
 */
public interface ShareQRCodeContract {

    interface IModel {

        // 创建共享设备二维码
        Observable<BaseBean<ShareQrCodeBean>> createQRCode(String deviceSn, Permission permission);
    }

    interface IView extends BaseView {

        void createQRCodeSuccess(ShareQrCodeBean responseData);

        void createQRCodeError(Throwable e);
    }
}
