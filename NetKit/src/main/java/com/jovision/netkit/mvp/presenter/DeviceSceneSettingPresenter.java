package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.DeviceSceneBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.ScenesParmaBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.DeviceSceneSettingContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class DeviceSceneSettingPresenter extends BasePresenter<DeviceSceneSettingContract.IDeviceSceneSettingModel, DeviceSceneSettingContract.View> {

    @Inject
    public DeviceSceneSettingPresenter(DeviceSceneSettingContract.IDeviceSceneSettingModel iDeviceSceneSettingModel, DeviceSceneSettingContract.View view) {
        super(iDeviceSceneSettingModel, view);
    }


    public void getDeviceScene(String deviceSn, int channelId) {
        mModel.getDeviceScene(deviceSn, channelId).compose(RxHttpReponseCompat.<List<DeviceSceneBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<DeviceSceneBean>>(mContext, mView) {
                    @Override
                    public void onNext(List<DeviceSceneBean> deviceSceneBeans) {
                        if (hasView()) {
                            mView.getDeviceSceneSuccess(deviceSceneBeans);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getDeviceSceneError(e);
                        }
                    }
                });
    }

    public void changeScene(List<DeviceSceneBean> data, String deviceSn, int channelId) {
        ArrayList<ScenesParmaBean> scenesParmaBeans = new ArrayList<>();
        for (DeviceSceneBean deviceSceneBean : data) {

            String action = "";
            if(1 == deviceSceneBean.getBelongStatusInt()){
                action = ScenesParmaBean.ADD;
            } else {
                action = ScenesParmaBean.REMOVE;
            }

            ScenesParmaBean scenesParmaBean = new ScenesParmaBean(deviceSceneBean.getSceneId(), action);
            scenesParmaBeans.add(scenesParmaBean);
        }
        mModel.changeScene(scenesParmaBeans, deviceSn, channelId).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.changeSceneSuccess();
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.changeSceneError(e);
                        }
                    }
                });
    }

}
