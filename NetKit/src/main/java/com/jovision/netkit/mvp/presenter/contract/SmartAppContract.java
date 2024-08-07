package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.PackageExpireBean;
import com.jovision.netkit.mvp.data.bean.response.PkgGiftRemindBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAppBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAppStatus;
import com.jovision.netkit.mvp.data.bean.response.SmartAppStatusBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface SmartAppContract {

    interface ISmartAppModel {
        Observable<BaseBean<List<SmartAppBean>>> getSmartApp(String model, String type, String firmVer);

        Observable<BaseBean<List<SmartAppStatusBean>>> getSmartAppStatus(String deviceSn, int channelId, String[] algorithmSign);

        Observable<BaseBean<PkgGiftRemindBean>> getGiftReminds(String deviceSn, int channelId, String[] pkgTypes);

        Observable<BaseBean<SmartAppStatus>> getSmartStatus(String deviceSn, int channelId, String[] pkgTypes);

        Observable<BaseBean<PackageExpireBean>> packageBind(String deviceId, String extend);
    }

    interface View extends BaseView {

        void getSmartAppSuccess(List<SmartAppBean> list);
        void getSmartAppFailed(Throwable t);

        void getSmartAppStatusSuccess(List<SmartAppStatusBean> list);
        void getSmartAppStatusFailed(Throwable t);

        void getGiftRemindSucess(PkgGiftRemindBean bean);

        void getGiftRemindFailed(Throwable t);

        void getSmartStatusSuccess(SmartAppStatus items);
        void getSmartStatusFailed(Throwable t);

        void getPackageBindSuccess(PackageExpireBean bean);
        void getPackageBindFailed(Throwable t);
    }

}
