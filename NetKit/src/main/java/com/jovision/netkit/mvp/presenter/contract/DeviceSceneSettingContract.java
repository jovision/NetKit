package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceSceneBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.ScenesParmaBean;
import com.jovision.uikit.BaseView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface DeviceSceneSettingContract {

    interface IDeviceSceneSettingModel {

        Observable<BaseBean<List<DeviceSceneBean>>> getDeviceScene(String deviceSn, int channelId);

        Observable<BaseBean<EmptyBean>> changeScene(ArrayList<ScenesParmaBean> scenes, String deviceSn, int channelId);

    }

    interface View extends BaseView {
        void getDeviceSceneSuccess(List<DeviceSceneBean> deviceSceneBeans);

        void getDeviceSceneError(Throwable t);

        void changeSceneSuccess();

        void changeSceneError(Throwable t);
    }

}
