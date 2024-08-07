package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.DeviceConnectNetBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.UpdateSceneRequestBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceProtocolBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.AddDeviceContract;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by ZHP on 2017/7/19.
 */

public class AddDevicePresenter extends BasePresenter<AddDeviceContract.IAddDeviceModel, AddDeviceContract.View> {

    @Inject
    public AddDevicePresenter(AddDeviceContract.IAddDeviceModel iAddDeviceModel, AddDeviceContract.View view) {
        super(iAddDeviceModel, view);
    }


    public void addDevice(String deviceSn, String validateCode,int ct,String deviceUser,String devicePassword,String accessProtocol) {
        mModel.addDevice(deviceSn, validateCode,ct,deviceUser,devicePassword,accessProtocol).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.addDeviceSuccess();
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();

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



    //获取设备协议等信息
    public void getDeviceProtocol(String deviceSn,int type) {//1：轮训查询 0：其他查询
        mModel.getDeviceProtocol(deviceSn,type).compose(RxHttpReponseCompat.<DeviceProtocolBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceProtocolBean>(mContext, mView) {
                    @Override
                    public void onNext(DeviceProtocolBean deviceProtocolBean) {
                        if (hasView()) {
                            mView.getDeviceProtocolSuccess(deviceProtocolBean);
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);

                        if (hasView()) {
                            mView.getDeviceProtocolError(e);
                        }
//                        if (e instanceof ApiException) {
//                            ApiException a = (ApiException) e;
//                            if (hasView()) {
//                                mView.getDeviceProtocolError(a.getCode());
//                            }
//                        }
                    }
                });
    }




    public void updateScene(UpdateSceneRequestBean updateSceneRequestBean){
        mModel.updateScene(updateSceneRequestBean).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.updateSceneSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.updateSceneError(e);
                        }
                    }
                });
    }


    /**
     * 获取设备当前的WIFI信息-jy
     * @param body
     */
    public void getDeviceWifiInfo(String deviceSn, int channelId, HashMap<String, Object> body){
        mModel.getDeviceWifiInfo(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<DeviceConnectNetBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull DeviceConnectNetBean deviceConnectNetBean) {
                        if (hasView()){
                            mView.getDeviceWifiInfoSuccess(deviceConnectNetBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getDeviceWifiInfoError(e);
                        }
                    }
                });
    }


}
