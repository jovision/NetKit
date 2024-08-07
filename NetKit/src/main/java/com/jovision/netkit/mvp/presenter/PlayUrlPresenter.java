package com.jovision.netkit.mvp.presenter;

import com.jovision.basekit.JsonUtils;
import com.jovision.netkit.mvp.data.bean.CallUrlBean;
import com.jovision.netkit.mvp.data.bean.response.PetNewDeviceBean;
import com.jovision.netkit.mvp.data.http.ConnectUrlBean;
import com.jovision.netkit.mvp.data.http.PlayUrlBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.PlayUrlContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2017/7/19.
 */

public class PlayUrlPresenter extends BasePresenter<PlayUrlContract.IPlayUrlModel, PlayUrlContract.View> {

    @Inject
    public PlayUrlPresenter(PlayUrlContract.IPlayUrlModel iPlayUrlModel, PlayUrlContract.View view) {
        super(iPlayUrlModel, view);
    }

    /**
     * 公有云协议. 获取播放地址. 显示展示加载动画
     *
     * @param deviceSn
     * @param channelId
     * @param streamId
     */
    public void getPlayUrl(String deviceSn, int channelId, int streamId) {
        getPlayUrl(deviceSn, channelId, streamId, false);
    }

    /**
     * 公有云协议. 获取播放地址.
     *
     * @param deviceSn
     * @param channelId
     * @param streamId
     * @param isNotShowProgress 是否隐藏加载动画. true: 隐藏加载动画; false: 显示加载动画
     */
    public void getPlayUrl(String deviceSn, int channelId, int streamId, boolean isNotShowProgress) {
        mModel.getPlayUrl(deviceSn, channelId, streamId)
                .compose(RxHttpReponseCompat.<List<PlayUrlBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<PlayUrlBean>>(mContext, mView, isNotShowProgress) {
                    @Override
                    public void onNext(List<PlayUrlBean> playUrlBeans) {
                        if (hasView()) {

                            PlayUrlBean playUrlBean = playUrlBeans.get(0);
                            mView.getPlayUrlSuccess(playUrlBean);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getPlayUrlFailed(e);
                        }
                    }
                });
    }


    public void getCallUrl(String deviceSn, int channelId) {
        mModel.getCallUrl(deviceSn, channelId).compose(RxHttpReponseCompat.<CallUrlBean>compatResult())
                .subscribe(new ProgressSubcriber<CallUrlBean>(mContext, mView) {
                    @Override
                    public void onNext(CallUrlBean callUrlBean) {
                        if (hasView()) {
                            mView.getCallUrlSuccess(JsonUtils.toJson(callUrlBean));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getCallUrlFailed(e);
                        }
                    }
                });
    }

    /**
     * 云视通2.0协议. 获取播放地址. 显示展示加载动画
     *
     * @param deviceSn
     * @param channelId
     * @param deviceIp
     * @param devicePort
     */
    public void getYstPlayUrl(String deviceSn, int channelId, String deviceIp, int devicePort) {
        getYstPlayUrl(deviceSn, channelId, deviceIp, devicePort, false);
    }

    /**
     * 云视通2.0协议. 获取播放地址.
     *
     * @param deviceSn
     * @param channelId
     * @param deviceIp
     * @param devicePort
     * @param isNotShowProgress 是否隐藏加载动画. true: 隐藏加载动画; false: 显示加载动画
     */
    public void getYstPlayUrl(String deviceSn, int channelId, String deviceIp, int devicePort,
                              boolean isNotShowProgress) {
        mModel.getYstPlayUrl(deviceSn, channelId, deviceIp, devicePort)
                .compose(RxHttpReponseCompat.<List<ConnectUrlBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<ConnectUrlBean>>(mContext, mView, isNotShowProgress) {
                    @Override
                    public void onNext(List<ConnectUrlBean> playUrlBeans) {
                        if (hasView()) {
                            mView.getYstPlayUrlSuccess(playUrlBeans);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getYstPlayUrlFailed(e);
                        }
                    }
                });
    }


    /**
     * 查询套餐是否赠送
     *
     * @param deviceSn
     */
    public void getSmartAbilityIsPetNewDevice(String deviceSn) {
        mModel.getSmartAbilityIsPetNewDevice(deviceSn)
                .compose(RxHttpReponseCompat.<PetNewDeviceBean>compatResult())
                .subscribe(new ProgressSubcriber<PetNewDeviceBean>(mContext, mView, false) {
                    @Override
                    public void onNext(PetNewDeviceBean petNewDeviceBean) {
                        if (hasView()) {
                            mView.getSmartAbilityIsPetNewDeviceSuccess(petNewDeviceBean);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getSmartAbilityIsPetNewDeviceFailed(e);
                        }
                    }
                });
    }

//
//    public void getParamLPRSystem(String deviceSn, int channelId) {
//        mModel.getParamLPRSystem(deviceSn, channelId)
//                .compose(RxHttpReponseCompat.<RDLPRSystemGetParam>compatResult())
//                .subscribe(new ProgressSubcriber<RDLPRSystemGetParam>(mContext, mView, false) {
//                    @Override
//                    public void onNext(RDLPRSystemGetParam rdlprSystemGetParam) {
//                        if (hasView()) {
//                            mView.getParamLPRSystemSuccess(rdlprSystemGetParam);
//                        }
//                    }
//
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        if (hasView()) {
//                            mView.getParamLPRSystemFailed(e);
//                        }
//                    }
//                });
//    }
//
//    public void setParamLPRSystem(String deviceSn, int channelId, RDLPRSystemSetParam rdlprSystemSetParam) {
//        mModel.setParamLPRSystem(deviceSn, channelId,rdlprSystemSetParam)
//                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
//                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
//                    @Override
//                    public void onNext(EmptyBean emptyBean) {
//                        if (hasView()) {
//                            mView.setParamLPRSystemSuccess(emptyBean);
//                        }
//                    }
//
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        if (hasView()) {
//                            mView.setParamLPRSystemFailed(e);
//                        }
//                    }
//                });
//    }


}
