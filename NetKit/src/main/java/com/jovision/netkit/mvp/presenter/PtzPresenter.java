package com.jovision.netkit.mvp.presenter;


import android.content.Intent;

import com.alibaba.fastjson.JSONArray;
import com.jovision.basekit.JsonUtils;
import com.jovision.basekit.LogUtil;
import com.jovision.netkit.mvp.data.GetScreenOverTurnBean;
import com.jovision.netkit.mvp.data.bean.CallUrlBean;
import com.jovision.netkit.mvp.data.bean.ControlTokenBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.RDLPRSystemGetParam;
import com.jovision.netkit.mvp.data.bean.response.AlarmLinkIdBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmStatusBean;
import com.jovision.netkit.mvp.data.bean.response.EnableBean;
import com.jovision.netkit.mvp.data.bean.response.ErrorBean;
import com.jovision.netkit.mvp.data.bean.response.GtrackGetCalibrationBean;
import com.jovision.netkit.mvp.data.bean.response.IntelligenceAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.IntelligenceWaveHandCallParam;
import com.jovision.netkit.mvp.data.bean.response.OctAccountModifyUserBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmLinkDefenceBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmLinkGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctChannelAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevGetVC;
import com.jovision.netkit.mvp.data.bean.response.OctDevInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAbilityGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAdjustParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageDncutParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzGuardGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPatrolCreateBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPatrolGetNodesBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPatrolsGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzPresetsGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzSpeedBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzTimeTaskGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzTimeTaskListGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctPtzTrailGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctSDCardFormatProBean;
import com.jovision.netkit.mvp.data.bean.response.OctSDCardInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctStreamGetParams;
import com.jovision.netkit.mvp.data.bean.response.ShareToMeBean;
import com.jovision.netkit.mvp.data.bean.response.SimCardListBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAbilityDetailBean;
import com.jovision.netkit.mvp.data.bean.response.SnapDateBean;
import com.jovision.netkit.mvp.data.bean.response.SnapFileListBean;
import com.jovision.netkit.mvp.data.bean.response.StorageBean;
import com.jovision.netkit.mvp.data.http.ConnectUrlBean;
import com.jovision.netkit.mvp.data.http.PlayUrlBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.PtzContract;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by ZHP on 2017/7/19.
 */

public class PtzPresenter extends BasePresenter<PtzContract.IPtzModel, PtzContract.View> {

    private static final String TAG = "PtzPresenter";

    @Inject
    public PtzPresenter(PtzContract.IPtzModel iPtzModel, PtzContract.View view) {
        super(iPtzModel, view);
    }



    /**
     * 标定相关接口-1 获取标定状态
     * @param deviceSn
     * @param channelId
     * @param body
     */
    public void getGtrackCalibration(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.getGtrackCalibration(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<GtrackGetCalibrationBean.ResultBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull GtrackGetCalibrationBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.getGtrackCalibrationSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getGtrackCalibrationFailed(e);
                        }
                    }
                });
    }


    /**
     * 标定相关接口-2 开始标定
     * @param deviceSn
     * @param channelId
     * @param body
     */
    public void setGtrackCalibration(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setGtrackCalibration(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setGtrackCalibrationSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setGtrackCalibrationFailed(e);
                        }
                    }
                });
    }


    /**
     * 标定相关接口-3 设置枪球联动标定位置
     * @param deviceSn
     * @param channelId
     * @param body
     */
    public void addGtrackMarkPoint(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.addGtrackMarkPoint(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.addGtrackMarkPointSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.addGtrackMarkPointFailed(e);
                        }
                    }
                });
    }


    /**
     * 标定相关接口-4 设置守望点(设为跟踪初始位置)
     * @param deviceSn
     * @param channelId
     */
    public void setGtrackGuard(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setGtrackGuard(deviceSn, channelId,body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setGtrackGuardSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setGtrackGuardFailed(e);
                        }
                    }
                });
    }







    /**
     * 标定相关接口-5 手动定位
     * @param deviceSn
     * @param channelId
     * @param body
     */
    public void manualGtrackPosition(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.manualGtrackPosition(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.manualGtrackPositionSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.manualGtrackPositionFailed(e);
                        }
                    }
                });
    }

    /**
     * 标定相关接口-6 清空标定点
     * @param deviceSn
     * @param channelId
     * @param body
     */
    public void clearGtrackPoint(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.clearGtrackPoint(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
//                            mView.clearGtrackPointSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
//                            mView.clearGtrackPointFailed(e);
                        }
                    }
                });
    }

    // 设备主动呼叫命令配置, 呼叫状态 answer 接听  refuse 拒接  hangup 挂断
    public void oneKeyCallPublic(String deviceSn, int channelId,String status) {
        mModel.oneKeyCallPublic(deviceSn, channelId,status).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.oneKeyCallPublicSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.oneKeyCallPublicFailed(e);
                        }
                    }

                });
    }


    public void getCallUrl(String deviceSn, int channelId) {
        mModel.getCallUrl(deviceSn, channelId).compose(RxHttpReponseCompat.<CallUrlBean>compatResult())
                .subscribe(new ProgressSubcriber<CallUrlBean>(mContext, mView,true) {
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

    public void getMultiPlayUrl(String deviceSn, ArrayList<Integer> channelList, int streamId) {
        mModel.getMultiPlayUrl(deviceSn, channelList, streamId).compose(RxHttpReponseCompat.<List<PlayUrlBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<PlayUrlBean>>(mContext, mView) {
                    @Override
                    public void onNext(List<PlayUrlBean> playUrlBeans) {
                        if (hasView()) {
                            mView.getMultiPlayUrlSuccess(playUrlBeans);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getMultiPlayUrlFailed(e);
                        }
                    }
                });
    }


    public void getPlayUrl(String deviceSn, int channelId, int streamId) {
        mModel.getPlayUrl(deviceSn, channelId, streamId).compose(RxHttpReponseCompat.<List<PlayUrlBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<PlayUrlBean>>(mContext, mView) {
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

    public void getOneKeyCallPlayUrl(String deviceSn, int channelId, int streamId) {
        mModel.getOneKeyCallPlayUrl(deviceSn, channelId, streamId).compose(RxHttpReponseCompat.<List<PlayUrlBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<PlayUrlBean>>(mContext, mView) {
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




    public void getYstPlayUrl(String deviceSn, int channelId, String deviceIp, int devicePort) {
        mModel.getYstPlayUrl(deviceSn, channelId, deviceIp, devicePort).compose(RxHttpReponseCompat.<List<ConnectUrlBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<ConnectUrlBean>>(mContext, mView) {
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
     * 获取公有云设备当前的信息-jy
     *
     * @param body
     */
    public void getPublicDeviceInfo(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.getPublicDeviceInfo(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctDevInfoBean.ResultBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull OctDevInfoBean.ResultBean octDevInfoBean) {
                        if (hasView()) {
                            mView.getPublicDeviceInfoSuccess(octDevInfoBean, deviceSn, channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getPublicDeviceInfoError(e, deviceSn, channelId);
                        }
                    }
                });
    }


    /**
     * 获取公有云设备通道的能力-jy
     *
     * @param body
     */
    public void getChannelsFeatures(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.getChannelsFeatures(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctChannelAbilityBean.ResultBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull OctChannelAbilityBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.getChannelsFeaturesSuccess(resultBean, deviceSn, channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getChannelsFeaturesError(e, deviceSn, channelId);
                        }
                    }
                });
    }


    /**
     * 50 云视通2.0NVR获取通道能力
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetChannelsFeatures(String deviceSn, int channelId, String devUser, String devPwd,boolean isAp) {
        mModel.octGetChannelsFeatures(deviceSn, channelId, devUser, devPwd,isAp).compose(RxHttpReponseCompat.<OctChannelAbilityBean>compatResult())
                .subscribe(new ProgressSubcriber<OctChannelAbilityBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctChannelAbilityBean octChannelAbilityBean) {
                        if (hasView()) {
                            mView.octGetChannelsFeaturesSuccess(octChannelAbilityBean, deviceSn, channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetChannelsFeaturesFailed(e, deviceSn, channelId);
                        }
                    }
                });
    }


    public void getControlToken(String deviceSn, int channelId) {
        LogUtil.v("publicPtzToken", "getControlToken-e");
        mModel.getControlToken(deviceSn, channelId).compose(RxHttpReponseCompat.<ControlTokenBean>compatResult())
                .subscribe(new ProgressSubcriber<ControlTokenBean>(mContext, mView, true) {
                    @Override
                    public void onNext(ControlTokenBean controlTokenBean) {
                        if (hasView()) {

                            if (null != controlTokenBean) {
                                LogUtil.v("publicPtzToken", "getControlTokenSuccess,controlTokenBean=" + controlTokenBean.getControlToken());
                            } else {
                                LogUtil.v("publicPtzToken", "getControlTokenSuccess,controlTokenBean=null");
                            }
                            mView.getControlTokenSuccess(controlTokenBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            LogUtil.v("publicPtzToken", "getControlTokenFailed");
                            mView.getControlTokenFailed(e);

                        }
                    }


                });
    }

    public void releaseControlToken(String deviceSn, int channelId) {
        LogUtil.e("publicPtzToken", "releaseControlToken-e");
        mModel.releaseControlToken(deviceSn, channelId).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            LogUtil.e("publicPtzToken", "releaseControlTokenSuccess");
                            mView.releaseControlTokenSuccess();

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            LogUtil.e("publicPtzToken", "releaseControlTokenFailed");
                            mView.releaseControlTokenFailed();

                        }
                    }
                });
    }

    //1.云台控制-云台速度获取-公有云协议
    public void ptzMoveStatGet(String deviceSn, int channelId, String controlToken) {
        mModel.ptzMoveStatGet(deviceSn, channelId, controlToken).compose(RxHttpReponseCompat.<OctPtzSpeedBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzSpeedBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctPtzSpeedBean.ResultBean octPtzSpeedBean) {
                        if (hasView()) {
                            mView.ptzMoveStatGetSuccess(octPtzSpeedBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzMoveStatGetFailed(e);
                        }
                    }
                });
    }

    //2.云台控制-控制移动-公有云协议（包含放大，缩小）
    public void ptzControl(String deviceSn, int channelId, String controlToken, int panLeft, int tiltUp, int zoomIn) {
        mModel.ptzControl(deviceSn, channelId, controlToken, panLeft, tiltUp, zoomIn).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.ptzControlSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzControlFailed(e);
                        }
                    }
                });
    }

    //3.云台控制-停止移动-公有云协议
    public void ptzControlStop(String deviceSn, int channelId, String controlToken) {
        mModel.ptzControlStop(deviceSn, channelId, controlToken).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.ptzControlStopSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }

    //4.云台控制-聚焦和光圈-公有云协议
    public void ptzFiStart(String deviceSn, int channelId, int focusFar, int irisOpen, String controlToken) {
        mModel.ptzFiStart(deviceSn, channelId, focusFar, irisOpen, controlToken).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }

    //5.云台控制-停止聚焦和光圈-公有云协议
    public void ptzFiStop(String deviceSn, int channelId, String controlToken) {
        mModel.ptzFiStop(deviceSn, channelId, controlToken).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }


    //6.云台控制-云台自动旋转-公有云协议
    public void ptzAuto(String deviceSn, int channelId, int speed, String controlToken) {
        mModel.ptzAuto(deviceSn, channelId, speed, controlToken).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.ptzAutoSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzAutoFailed(e);
                        }
                    }
                });
    }

    //7.云台控制-获取云台能力--公有云协议
    public void ptzAbilityGet(String deviceSn, int channelId, String controlToken) {
        mModel.ptzAbilityGet(deviceSn, channelId, controlToken).compose(RxHttpReponseCompat.<OctPtzAbilityBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzAbilityBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctPtzAbilityBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.ptzAbilityGetSuccess(resultBean,deviceSn,channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzAbilityGetFailed(e);
                        }
                    }
                });
    }



    //7.1云台控制-获取云台能力--公有云协议，透传命令，不需要带token
    public void ptzAbilityGetNoToken(String deviceSn, int channelId) {
        mModel.ptzAbilityGetNoToken(deviceSn, channelId).compose(RxHttpReponseCompat.<OctPtzAbilityBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzAbilityBean.ResultBean>(mContext, mView, false) {
                    @Override
                    public void onNext(OctPtzAbilityBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.ptzAbilityGetSuccess(resultBean,deviceSn,channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzAbilityGetFailed(e);
                        }
                    }
                });
    }


    //8.云台控制-获取预置点-公有云协议
    public void ptzPresetsGet(String deviceSn, int channelId, String controlToken) {
        mModel.ptzPresetsGet(deviceSn, channelId, controlToken).compose(RxHttpReponseCompat.<OctPtzPresetsGetBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzPresetsGetBean.ResultBean>(mContext, mView, false) {
                    @Override
                    public void onNext(OctPtzPresetsGetBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.ptzPresetsGetSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPresetsGetFailed(e);
                        }
                    }
                });
    }


    //9.云台控制-设置预置点-公有云协议
    public void ptzPresetSet(String deviceSn, int channelId, int presetNo, String name, String controlToken) {
        mModel.ptzPresetSet(deviceSn, channelId, presetNo, name, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, true) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzPresetSetSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPresetSetFailed(e);
                        }
                    }
                });
    }


    //10.云台控制-调用预置点-公有云协议
    public void ptzPresetLocate(String deviceSn, int channelId, int presetNo, int moveSpeed, String controlToken) {
        mModel.ptzPresetLocate(deviceSn, channelId, presetNo, moveSpeed, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzPresetLocateSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPresetLocateFailed(e);
                        }
                    }
                });
    }


    //11.云台控制-删除预置点-公有云协议
    public void ptzPresetDelete(String deviceSn, int channelId, int presetNo, String controlToken) {
        mModel.ptzPresetDelete(deviceSn, channelId, presetNo, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzPresetDeleteSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPresetDeleteFailed(e);
                        }
                    }
                });
    }

    //12.云台控制-获取巡航-公有云协议
    public void ptzPatrolsGet(String deviceSn, int channelId, int patrolId, String controlToken) {
        mModel.ptzPatrolsGet(deviceSn, channelId, patrolId, controlToken).compose(RxHttpReponseCompat.<OctPtzPatrolsGetBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzPatrolsGetBean.ResultBean>(mContext, mView, false) {
                    @Override
                    public void onNext(OctPtzPatrolsGetBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.ptzPatrolsGetSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPatrolsGetFailed(e);
                        }
                    }
                });
    }


    //13.云台控制-创建巡航-公有云协议
    public void ptzPatrolCreate(String deviceSn, int channelId, String controlToken) {
        mModel.ptzPatrolCreate(deviceSn, channelId, controlToken).compose(RxHttpReponseCompat.<OctPtzPatrolCreateBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzPatrolCreateBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctPtzPatrolCreateBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.ptzPatrolCreateSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPatrolCreateFailed(e);
                        }
                    }
                });
    }


    //14.云台控制-删除巡航-公有云协议
    public void ptzPatrolDelete(String deviceSn, int channelId, int patrolId, String controlToken) {
        mModel.ptzPatrolDelete(deviceSn, channelId, patrolId, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, true) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzPatrolDeleteSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPatrolDeleteFailed(e);
                        }
                    }
                });
    }


    //15.云台控制-调用巡航-公有云协议
    public void ptzPatrolLocate(String deviceSn, int channelId, int patrolId, int speed, String controlToken) {
        mModel.ptzPatrolLocate(deviceSn, channelId, patrolId, speed, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzPatrolLocateSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPatrolLocateFailed(e);
                        }
                    }
                });
    }

    //16.云台控制-停止巡航-公有云协议
    public void ptzPatrolStop(String deviceSn, int channelId, int patrolId, String controlToken) {
        mModel.ptzPatrolStop(deviceSn, channelId, patrolId, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, true) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzPatrolStopSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPatrolStopFailed(e);
                        }
                    }
                });
    }

    //17.云台控制-获取巡航节点-公有云协议
    public void ptzPatrolGetNodes(String deviceSn, int channelId, int patrolId, String controlToken) {
        mModel.ptzPatrolGetNodes(deviceSn, channelId, patrolId, controlToken).compose(RxHttpReponseCompat.<OctPtzPatrolGetNodesBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzPatrolGetNodesBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctPtzPatrolGetNodesBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.ptzPatrolGetNodesSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPatrolGetNodesFailed(e);
                        }
                    }
                });
    }

    //18.云台控制-添加巡航节点-公有云协议
    public void ptzPatrolAddNode(String deviceSn, int channelId, int patrolId, int presetNo, int staySeconds, String controlToken) {
        mModel.ptzPatrolAddNode(deviceSn, channelId, patrolId, presetNo, staySeconds, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, true) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzPatrolAddNodeSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPatrolAddNodeFailed(e);
                        }
                    }
                });
    }

    //19.云台控制-删除巡航节点-公有云协议
    public void ptzPatrolDelNode(String deviceSn, int channelId, int patrolId, int presetIndex, String controlToken) {
        mModel.ptzPatrolDelNode(deviceSn, channelId, patrolId, presetIndex, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzPatrolDelNodeSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPatrolDelNodeFailed(e);
                        }
                    }
                });
    }

    //20.云台控制-设置巡航速度-公有云协议
    public void ptzPatrolSetSpeed(String deviceSn, int channelId, int patrolId, int speed, String controlToken) {
        mModel.ptzPatrolSetSpeed(deviceSn, channelId, patrolId, speed, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzPatrolSetSpeedSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPatrolSetSpeedFailed(e);
                        }
                    }
                });
    }

    //21.云台控制-设置巡航时间-公有云协议
    public void ptzPatrolSetStaySeconds(String deviceSn, int channelId, int patrolId, int staySeconds, String controlToken) {
        mModel.ptzPatrolSetStaySeconds(deviceSn, channelId, patrolId, staySeconds, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, true) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzPatrolSetStaySecondsSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzPatrolSetStaySecondsFailed(e);
                        }
                    }
                });
    }


    //22.云台控制-开始或者完成轨迹录制-公有云
    public void ptzTrailRec(String deviceSn, int channelId, int trailId, boolean bStart, String controlToken) {
        mModel.ptzTrailRec(deviceSn, channelId, trailId, bStart, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, true) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzTrailRecSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzTrailRecFailed(e);
                        }
                    }
                });
    }


    //23.云台控制-启动或者停止轨迹-公有云
    public void ptzTrailAction(String deviceSn, int channelId, int trailId, boolean bStart, String controlToken) {
        mModel.ptzTrailAction(deviceSn, channelId, trailId, bStart, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, true) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzTrailActionSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzTrailActionFailed(e);
                        }
                    }
                });
    }

    //24.云台控制-获取轨迹-公有云
    public void ptzTrailGet(String deviceSn, int channelId, int trailId, String controlToken) {
        mModel.ptzTrailGet(deviceSn, channelId, trailId, controlToken).compose(RxHttpReponseCompat.<OctPtzTrailGetBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzTrailGetBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctPtzTrailGetBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.ptzTrailGetSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzTrailGetFailed(e);
                        }
                    }
                });
    }


    //25.云台控制-获取守望-公有云
    public void ptzGuardGet(String deviceSn, int channelId, String controlToken) {
        mModel.ptzGuardGet(deviceSn, channelId, controlToken)
                .compose(RxHttpReponseCompat.<OctPtzGuardGetBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzGuardGetBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctPtzGuardGetBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.ptzGuardGetSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzGuardGetFailed(e);
                        }
                    }
                });
    }

    //26.云台控制-设置守望-公有云协议
    public void ptzGuardSet(String deviceSn, int channelId, int preset, int staySeconds, String controlToken) {
        mModel.ptzGuardSet(deviceSn, channelId, preset, staySeconds, controlToken)
                .compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzGuardSetSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzGuardSetFailed(e);
                        }
                    }
                });
    }

    //27.云台控制-启动或者停止守望-公有云协议
    public void ptzGuardAction(String deviceSn, int channelId, boolean bStart, String controlToken) {
        mModel.ptzGuardAction(deviceSn, channelId, bStart, controlToken)
                .compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzGuardActionSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzGuardActionFailed(e);
                        }
                    }
                });
    }


    //28.云台控制-暂停或者复位守望-公有云协议
    public void ptzGuardPause(String deviceSn, int channelId, boolean bPause, String controlToken) {
        mModel.ptzGuardPause(deviceSn, channelId, bPause, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, true) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzGuardPauseSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzGuardPauseFailed(e);
                        }
                    }
                });
    }

    //29.云台控制-获取定时任务列表-公有云协议
    public void ptzTimeTaskListGet(String deviceSn, int channelId, String controlToken) {
        mModel.ptzTimeTaskListGet(deviceSn, channelId, controlToken).compose(RxHttpReponseCompat.<OctPtzTimeTaskListGetBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzTimeTaskListGetBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctPtzTimeTaskListGetBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.ptzTimeTaskListGetSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzTimeTaskListGetFailed(e);
                        }
                    }
                });
    }

    //30.云台控制-获取定时任务-公有云协议
    public void ptzTimeTaskGet(String deviceSn, int channelId, int taskId, String controlToken) {
        mModel.ptzTimeTaskGet(deviceSn, channelId, taskId, controlToken).compose(RxHttpReponseCompat.<OctPtzTimeTaskGetBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzTimeTaskGetBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctPtzTimeTaskGetBean.ResultBean resultBean) {
                        if (hasView()) {
                            mView.ptzTimeTaskGetSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzTimeTaskGetFailed(e);
                        }
                    }
                });
    }

    //31.云台控制-设置定时任务-公有云协议
    public void ptzTimeTaskSet(String deviceSn, int channelId, JSONArray taskArray, String controlToken) {
        mModel.ptzTimeTaskSet(deviceSn, channelId, taskArray, controlToken).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzTimeTaskSetSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzTimeTaskSetFailed(e);
                        }
                    }
                });
    }


    //32.云台校准-公有云协议
    public void ptzCalibrate(String deviceSn, int channelId) {
        mModel.ptzCalibrate(deviceSn, channelId).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.ptzCalibrateSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzCalibrateFailed(e);
                        }
                    }
                });
    }

    //33.获取图像能力-公有云协议
    public void getImageAbility(String deviceSn, int channelId) {
        mModel.getImageAbility(deviceSn, channelId).compose(RxHttpReponseCompat.<OctImageAbilityGetBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctImageAbilityGetBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctImageAbilityGetBean.ResultBean resultBean) {
                        if (hasView()) {
                            OctImageAbilityGetBean octImageAbilityGetBean = new OctImageAbilityGetBean();
                            octImageAbilityGetBean.setResult(resultBean);

                            OctImageAbilityGetBean.ParamBean paramBean = new OctImageAbilityGetBean.ParamBean();
                            paramBean.setChannelid(channelId);
                            octImageAbilityGetBean.setParam(paramBean);

                            mView.octGetImageAbilitySuccess(octImageAbilityGetBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetImageAbilityFailed(e);
                        }
                    }
                });
    }

    //34.获取日夜切换设置-公有云协议
    public void getImageDncutParam(String deviceSn, int channelId){
        mModel.getImageDncutParam(deviceSn, channelId).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctImageDncutParamBean.ResultBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull OctImageDncutParamBean.ResultBean octImageDncutParamBean) {
                        if (hasView()){
                            mView.getImageDncutParamSuccess(octImageDncutParamBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getImageDncutParamFailed(e);
                        }
                    }
                });
    }

    //35.设置日夜切换-公有云协议
    public void setImageDncutParam(String deviceSn, int channelId, OctImageDncutParamBean.ResultBean resultBean) {
        mModel.setImageDncutParam(deviceSn, channelId, resultBean).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setImageDncutParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setImageDncutParamFailed(e);
                        }
                    }
                });
    }

    //36.获取报警联动总布防状态-公有云协议
    public void getAlarmLinkDefenceParam(String deviceSn, int channelId){
        mModel.getAlarmLinkDefenceParam(deviceSn, channelId).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctAlarmLinkDefenceBean.ResultBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull OctAlarmLinkDefenceBean.ResultBean bean) {
                        if (hasView()){
                            mView.getAlarmLinkDefenceParamSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getAlarmLinkDefenceParamFailed(e);
                        }
                    }
                });
    }

    //37.设置报警联动总布防状态-公有云协议
    public void setAlarmLinkDefenceParam(String deviceSn, int channelId, OctAlarmLinkDefenceBean.ResultBean resultBean) {
        mModel.setAlarmLinkDefenceParam(deviceSn, channelId, resultBean).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setAlarmLinkDefenceParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setAlarmLinkDefenceParamFailed(e);
                        }
                    }
                });
    }

    //38.设置驱离-公有云协议
    public void setAlarmLinkTrigger(String deviceSn, int channelId, String status, boolean isNotShowProgress) {
        mModel.setAlarmLinkTrigger(deviceSn, channelId, status).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, isNotShowProgress) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setAlarmLinkTriggerSuccess(status);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setAlarmLinkTriggerFailed(status, e);
                        }
                    }
                });
    }

    //39.获取码流参数-公有云协议
    public void getStreamParam(String deviceSn, int channelId){
        mModel.getStreamParam(deviceSn, channelId).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctStreamGetParams.ResultBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull OctStreamGetParams.ResultBean bean) {
                        if (hasView()){
                            mView.getStreamParamSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getStreamParamFailed(e);
                        }
                    }
                });
    }

    //40.设置码流参数-公有云协议
    public void setStreamParam(String deviceSn, int channelId, OctStreamGetParams.ResultBean resultBean) {
        mModel.setStreamParam(deviceSn, channelId, resultBean).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setStreamParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setStreamParamFailed(e);
                        }
                    }
                });
    }

    //41.获取智能能力集-公有云协议
    public void getIntelligenceAbility(String deviceSn, int channelId) {
        mModel.getIntelligenceAbility(deviceSn, channelId).compose(RxHttpReponseCompat.<IntelligenceAbilityBean>compatResult())
                .subscribe(new ProgressSubcriber<IntelligenceAbilityBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull IntelligenceAbilityBean bean) {
                        if (hasView()) {
                            mView.getIntelligenceAbilitySuccess(deviceSn, channelId, bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getIntelligenceAbilityError(e);
                        }
                    }
                });
    }

    //42.挥手呼叫参数获取接口-公有云协议
    public void getWaveHandCallParam(String deviceSn, int channelId) {
        mModel.getWaveHandCallParam(deviceSn, channelId).compose(RxHttpReponseCompat.<IntelligenceWaveHandCallParam.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<IntelligenceWaveHandCallParam.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull IntelligenceWaveHandCallParam.ResultBean bean) {
                        if (hasView()) {
                            mView.getWaveHandCallParamSuccess(deviceSn, channelId, bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getWaveHandCallParamError(deviceSn, channelId, e);
                        }
                    }
                });
    }

    //43.哭声宠物开启状态获取接口
    public void getCryPetDetail(String deviceSn, int channelId) {
        mModel.getCryPetDetail(deviceSn, channelId).compose(RxHttpReponseCompat.<SmartAbilityDetailBean>compatResult())
                .subscribe(new ProgressSubcriber<SmartAbilityDetailBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull SmartAbilityDetailBean bean) {
                        if (hasView()) {
                            mView.getCryPetDetailSuccess(deviceSn, channelId, bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getCryPetDetailError(deviceSn, channelId, e);
                        }
                    }
                });
    }



    public void getStorage(String deviceSn) {
        mModel.getStorage(deviceSn).compose(RxHttpReponseCompat.<List<StorageBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<StorageBean>>(mContext, mView,true) {
                    @Override
                    public void onNext(@NonNull List<StorageBean> storageBeans) {
                        if (hasView()) {
                            mView.getStorageSuccess(storageBeans);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getStorageError(e);
                        }
                    }
                });
    }




    public void formatSDCard(String deviceSn, int diskNum, String diskName, int curPart) {
        mModel.formatSDCard(deviceSn, diskNum, diskName, curPart).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.formatSDCardSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.formatSDCardError(e);
                        }
                    }
                });
    }


    public void getAlarmLinkId(String deviceSn, int channelId, String module) {
        mModel.getAlarmLinkId(deviceSn, channelId, module).compose(RxHttpReponseCompat.<AlarmLinkIdBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<AlarmLinkIdBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull AlarmLinkIdBean.ResultBean bean) {
                        if (hasView()) {
                            mView.getAlarmLinkIdSuccess(deviceSn, channelId, bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getAlarmLinkIdFailed(deviceSn, channelId, e);
                        }
                    }
                });
    }

    public void getAlarmLink(String deviceSn, int channelId, int alarmLinkId) {

        mModel.getAlarmLink(deviceSn, channelId, alarmLinkId).compose(RxHttpReponseCompat.<OctAlarmLinkGetBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAlarmLinkGetBean.ResultBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull OctAlarmLinkGetBean.ResultBean resultBean) {
                        if (hasView()) {
                            resultBean.setChannelid(channelId);
                            resultBean.setLink_id(alarmLinkId);
                            mView.getAlarmLinkSuccess(deviceSn, channelId, resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getAlarmLinkFailed(deviceSn, channelId, e);
                        }
                    }
                });
    }




    //1.云台控制-云台速度获取-云视通2.0
    public void ptzOctMoveStatGet(String deviceSn, int channelId, String devUser, String devPwd) {
        LogUtil.v(TAG,"1-ptzOctMoveStatGet,deviceSn="+deviceSn+";channelId="+channelId);
        mModel.ptzOctMoveStatGet(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctPtzSpeedBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzSpeedBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctPtzSpeedBean octPtzSpeedBean) {
                        if (hasView()) {
                            mView.ptzOctMoveStatGetSuccess(octPtzSpeedBean);
                            LogUtil.v(TAG,"1-ptzOctMoveStatGetSuccess");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            LogUtil.v(TAG,"1-ptzOctMoveStatGetFailed");
                            mView.ptzOctMoveStatGetFailed(e);
                        }
                    }
                });
    }

    //2.云台控制-控制移动-云视通2.0（包含放大，缩小）
    public void ptzOctControl(int playerId,String deviceSn, int channelId, String controlToken, String devUser, String devPwd, int panLeft, int tiltUp, int zoomIn, boolean isAp) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtil.v(TAG,"2-ptzOctControlStart,deviceSn="+deviceSn+";channelId="+channelId+";panLeft="+panLeft+";tiltUp="+tiltUp+";zoomIn="+zoomIn);
        mModel.ptzOctControl(playerId,deviceSn, channelId, controlToken, devUser, devPwd, panLeft, tiltUp, zoomIn, isAp).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            LogUtil.v(TAG,"2-ptzOctControlSuccess");
                            mView.ptzOctControlSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            LogUtil.v(TAG,"2-ptzOctControlFailed");
                            mView.ptzOctControlFailed(e);
                        }
                    }
                });
    }

    //3.云台控制-停止移动-云视通2.0
    public void ptzOctControlStop(int playerId,String deviceSn, int channelId, String controlToken, String devUser, String devPwd, boolean isAp) {
        LogUtil.v(TAG,"3-ptzOctControlStop,deviceSn="+deviceSn+";channelId="+channelId);
        mModel.ptzOctControlStop(playerId,deviceSn, channelId, controlToken, devUser, devPwd, isAp).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            LogUtil.v(TAG,"3-ptzOctControlStopSuccess");
                            mView.ptzOctControlStopSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.v(TAG,"3-ptzOctControlFailed");
                        super.onError(e);
                    }
                });
    }

    //4.云台控制-聚焦和光圈-云视通2.0
    public void ptzOctFiStart(int playerId,String deviceSn, int channelId, String devUser, String devPwd, int focusFar, int irisOpen, boolean isAp) {
        LogUtil.v(TAG,"4-ptzOctFiStart,deviceSn="+deviceSn+";channelId="+channelId+";focusFar="+focusFar+";irisOpen="+irisOpen);
        mModel.ptzOctFiStart(playerId,deviceSn, channelId, devUser, devPwd, focusFar, irisOpen, isAp).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            LogUtil.v(TAG,"4-ptzOctFiStartSuccess");
                            mView.ptzOctFiStartSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            LogUtil.v(TAG,"4-ptzOctFiStartFailed");
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctFiStartFailed(e);
                        }
                    }
                });
    }

    //5.云台控制-停止聚焦和光圈-云视通2.0
    public void ptzOctFiStop(int playerId,String deviceSn, int channelId, String devUser, String devPwd, boolean isAp) {
        LogUtil.v(TAG,"5-ptzOctFiStop,deviceSn="+deviceSn+";channelId="+channelId);
        mModel.ptzOctFiStop(playerId,deviceSn, channelId, devUser, devPwd, isAp).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            LogUtil.v(TAG,"5-ptzOctFiStopSuccess");
                            mView.ptzOctFiStopSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            LogUtil.v(TAG,"5-ptzOctFiStopFailed");
                            mView.ptzOctFiStopFailed(e);
                        }
                    }
                });
    }


    //6.云台控制-云台自动旋转-云视通2.0
    public void ptzOctAuto(int playerId,String deviceSn, int channelId, String devUser, String devPwd, int speed, boolean isAp) {
        mModel.ptzOctAuto(playerId,deviceSn, channelId, devUser, devPwd, speed, isAp).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.ptzOctAutoSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctAutoFailed(e);
                        }
                    }
                });
    }


    //7.云台控制-获取云台能力-云视通2.0
    public void ptzOctAbilityGet(String deviceSn, int channelId, String devUser, String devPwd,boolean isAp) {
        mModel.ptzOctAbilityGet(deviceSn, channelId, devUser, devPwd,isAp).compose(RxHttpReponseCompat.<OctPtzAbilityBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzAbilityBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull OctPtzAbilityBean octPtzAbilityBean) {
                        if (hasView()) {
                            mView.ptzOctAbilityGetSuccess(octPtzAbilityBean,deviceSn,channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctAbilityGetFailed(e);
                        }
                    }
                });
    }


    //8.云台控制-获取预置点-云视通2.0
    public void ptzOctPresetsGet(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.ptzOctPresetsGet(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctPtzPresetsGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzPresetsGetBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull OctPtzPresetsGetBean octPtzPresetsGetBean) {
                        if (hasView()) {
                            mView.ptzOctPresetsGetSuccess(octPtzPresetsGetBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzOctPresetsGetFailed(e);
                        }
                    }
                });
    }

    //9.云台控制-设置预置点-云视通2.0
    public void ptzOctPresetSet(String deviceSn, int channelId, String devUser, String devPwd, int presetNo, String name) {
        mModel.ptzOctPresetSet(deviceSn, channelId, devUser, devPwd, presetNo, name).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctPresetSetSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPresetSetFailed(e);
                        }
                    }
                });
    }

    //10.云台控制-调用预置点-云视通2.0
    public void ptzOctPresetLocate(String deviceSn, int channelId, String devUser, String devPwd, int presetNo, int moveSpeed) {
        mModel.ptzOctPresetLocate(deviceSn, channelId, devUser, devPwd, presetNo, moveSpeed).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctPresetLocateSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPresetLocateFailed(e);
                        }
                    }
                });
    }


    //11.云台控制-删除预置点-云视通2.0
    public void ptzOctPresetDelete(String deviceSn, int channelId, String devUser, String devPwd, int presetNo) {
        mModel.ptzOctPresetDelete(deviceSn, channelId, devUser, devPwd, presetNo).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctPresetDeleteSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPresetDeleteFailed(e);
                        }
                    }
                });
    }


    //12.云台控制-获取巡航-云视通2.0
    public void ptzOctPatrolsGet(String deviceSn, int channelId, String devUser, String devPwd, int patrolId) {
        mModel.ptzOctPatrolsGet(deviceSn, channelId, devUser, devPwd, patrolId).compose(RxHttpReponseCompat.<OctPtzPatrolsGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzPatrolsGetBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull OctPtzPatrolsGetBean octPtzPatrolsGetBean) {
                        if (hasView()) {
                            mView.ptzOctPatrolsGetSuccess(octPtzPatrolsGetBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPatrolsGetFailed(e);
                        }
                    }
                });
    }

    //13.云台控制-创建巡航-云视通2.0
    public void ptzOctPatrolCreate(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.ptzOctPatrolCreate(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctPtzPatrolCreateBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzPatrolCreateBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull OctPtzPatrolCreateBean octPtzPatrolCreateBean) {
                        if (hasView()) {
                            mView.ptzOctPatrolCreateSuccess(octPtzPatrolCreateBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPatrolCreateFailed(e);
                        }
                    }
                });
    }


    //14.云台控制-删除巡航-云视通2.0
    public void ptzOctPatrolDelete(String deviceSn, int channelId, String devUser, String devPwd, int patrolId) {
        mModel.ptzOctPatrolDelete(deviceSn, channelId, devUser, devPwd, patrolId).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctPatrolDeleteSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPatrolDeleteFailed(e);
                        }
                    }
                });
    }

    //15.云台控制-调用巡航-云视通2.0
    public void ptzOctPatrolLocate(String deviceSn, int channelId, String devUser, String devPwd, int patrolId, int speed) {
        mModel.ptzOctPatrolLocate(deviceSn, channelId, devUser, devPwd, patrolId, speed).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctPatrolLocateSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPatrolLocateFailed(e);
                        }
                    }
                });
    }

    //16.云台控制-停止巡航-云视通2.0
    public void ptzOctPatrolStop(String deviceSn, int channelId, String devUser, String devPwd, int patrolId) {
        mModel.ptzOctPatrolStop(deviceSn, channelId, devUser, devPwd, patrolId).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctPatrolStopSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPatrolStopFailed(e);
                        }
                    }
                });
    }

    //17.云台控制-获取巡航节点-云视通2.0
    public void ptzOctPatrolGetNodes(String deviceSn, int channelId, String devUser, String devPwd, int patrolId) {
        mModel.ptzOctPatrolGetNodes(deviceSn, channelId, devUser, devPwd, patrolId).compose(RxHttpReponseCompat.<OctPtzPatrolGetNodesBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzPatrolGetNodesBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull OctPtzPatrolGetNodesBean octPtzPatrolGetNodesBean) {
                        if (hasView()) {
                            mView.ptzOctPatrolGetNodesSuccess(octPtzPatrolGetNodesBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPatrolGetNodesFailed(e);
                        }
                    }
                });
    }

    //18.云台控制-添加巡航节点-云视通2.0
    public void ptzOctPatrolAddNode(String deviceSn, int channelId, String devUser, String devPwd, int patrolId, int presetNo, int staySeconds) {
        mModel.ptzOctPatrolAddNode(deviceSn, channelId, devUser, devPwd, patrolId, presetNo, staySeconds).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctPatrolAddNodeSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPatrolAddNodeFailed(e);
                        }
                    }
                });
    }

    //19.云台控制-删除巡航节点-云视通2.0
    public void ptzOctPatrolDelNode(String deviceSn, int channelId, String devUser, String devPwd, int patrolId, int presetIndex) {
        mModel.ptzOctPatrolDelNode(deviceSn, channelId, devUser, devPwd, patrolId, presetIndex).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctPatrolDelNodeSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPatrolDelNodeFailed(e);
                        }
                    }
                });
    }

    //20.云台控制-设置巡航速度-云视通2.0
    public void ptzOctPatrolSetSpeed(String deviceSn, int channelId, String devUser, String devPwd, int patrolId, int speed) {
        mModel.ptzOctPatrolSetSpeed(deviceSn, channelId, devUser, devPwd, patrolId, speed).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctPatrolSetSpeedSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPatrolSetSpeedFailed(e);
                        }
                    }
                });
    }

    //21.云台控制-设置巡航时间-云视通2.0
    public void ptzOctPatrolSetStaySeconds(String deviceSn, int channelId, String devUser, String devPwd, int patrolId, int staySeconds) {
        mModel.ptzOctPatrolSetStaySeconds(deviceSn, channelId, devUser, devPwd, patrolId, staySeconds).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctPatrolSetStaySecondsSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPatrolSetStaySecondsFailed(e);
                        }
                    }
                });
    }

    //22.云台控制-开始或者完成轨迹录制-云视通2.0
    public void ptzOctTrailRec(String deviceSn, int channelId, String devUser, String devPwd, int trailId, boolean bStart) {
        mModel.ptzOctTrailRec(deviceSn, channelId, devUser, devPwd, trailId, bStart).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctPatrolSetStaySecondsSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctPatrolSetStaySecondsFailed(e);
                        }
                    }
                });
    }

    //23.云台控制-启动或者停止轨迹-云视通2.0
    public void ptzOctTrailAction(String deviceSn, int channelId, String devUser, String devPwd, int trailId, boolean bStart) {
        mModel.ptzOctTrailAction(deviceSn, channelId, devUser, devPwd, trailId, bStart).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctTrailActionSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctTrailActionFailed(e);
                        }
                    }
                });
    }

    //24.云台控制-获取轨迹-云视通2.0
    public void ptzOctTrailGet(String deviceSn, int channelId, String devUser, String devPwd, int trailId) {
        mModel.ptzOctTrailGet(deviceSn, channelId, devUser, devPwd, trailId).compose(RxHttpReponseCompat.<OctPtzTrailGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzTrailGetBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull OctPtzTrailGetBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctTrailGetSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctTrailGetFailed(e);
                        }
                    }
                });
    }

    //25.云台控制-获取守望-云视通2.0
    public void ptzOctGuardGet(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.ptzOctGuardGet(deviceSn, channelId, devUser, devPwd)
                .compose(RxHttpReponseCompat.<OctPtzGuardGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzGuardGetBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull OctPtzGuardGetBean bean) {
                        if (hasView()) {
                            mView.ptzOctGuardGetSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzOctGuardGetFailed(e);
                        }
                    }
                });
    }

    //26.云台控制-设置守望-云视通2.0
    public void ptzOctGuardSet(String deviceSn, int channelId, String devUser, String devPwd, int preset, int staySeconds) {
        mModel.ptzOctGuardSet(deviceSn, channelId, devUser, devPwd, preset, staySeconds)
                .compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctGuardSetSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzOctGuardSetFailed(e);
                        }
                    }
                });
    }

    //27.云台控制-启动或者停止守望-云视通2.0
    public void ptzOctGuardAction(String deviceSn, int channelId, String devUser, String devPwd, boolean bStart) {
        mModel.ptzOctGuardAction(deviceSn, channelId, devUser, devPwd, bStart)
                .compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctGuardActionSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ptzOctGuardActionFailed(e);
                        }
                    }
                });
    }

    //28.云台控制-暂停或者复位守望-云视通2.0
    public void ptzOctGuardPause(String deviceSn, int channelId, String devUser, String devPwd, boolean bPause) {
        mModel.ptzOctGuardPause(deviceSn, channelId, devUser, devPwd, bPause).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctGuardPauseSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctGuardPauseFailed(e);
                        }
                    }
                });
    }

    //29.云台控制-获取定时任务列表-云视通2.0
    public void ptzOctTimeTaskListGet(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.ptzOctTimeTaskListGet(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctPtzTimeTaskListGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzTimeTaskListGetBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull OctPtzTimeTaskListGetBean octPtzTimeTaskListGetBean) {
                        if (hasView()) {
                            mView.ptzOctTimeTaskListGetSuccess(octPtzTimeTaskListGetBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctTimeTaskListGetFailed(e);
                        }
                    }
                });
    }

    //30.云台控制-获取定时任务-云视通2.0
    public void ptzOctTimeTaskGet(String deviceSn, int channelId, String devUser, String devPwd, int taskId) {
        mModel.ptzOctTimeTaskGet(deviceSn, channelId, devUser, devPwd, taskId).compose(RxHttpReponseCompat.<OctPtzTimeTaskGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctPtzTimeTaskGetBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull OctPtzTimeTaskGetBean octPtzTimeTaskGetBean) {
                        if (hasView()) {
                            mView.ptzOctTimeTaskGetSuccess(octPtzTimeTaskGetBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctTimeTaskGetFailed(e);
                        }
                    }
                });
    }

    //31.云台控制-设置定时任务-云视通2.0
    public void ptzOctTimeTaskSet(String deviceSn, int channelId, String devUser, String devPwd, JSONArray taskArray) {
        mModel.ptzOctTimeTaskSet(deviceSn, channelId, devUser, devPwd, taskArray).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctTimeTaskSetSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctTimeTaskSetFailed(e);
                        }
                    }
                });
    }


    //32.云台校准-云视通2.0
    public void ptzOctCalibrate(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.ptzOctCalibrate(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<ErrorBean>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ErrorBean errorBean) {
                        if (hasView()) {
                            mView.ptzOctCalibrateSuccess(errorBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.ptzOctCalibrateFailed(e);
                        }
                    }
                });
    }

    //34.获取日夜切换设置-云视通2.0
    public void octGetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetImageDncutParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctImageDncutParamBean>compatResult())
                .subscribe(new ProgressSubcriber<OctImageDncutParamBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctImageDncutParamBean octImageDncutParamBean) {
                        if (hasView()) {
                            mView.getImageDncutParamSuccess(octImageDncutParamBean.getResult());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.getImageDncutParamFailed(e);
                        }
                    }
                });
    }

    //35.设置日夜切换-云视通2.0
    public void octSetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetImageDncutParam(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setImageDncutParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.setImageDncutParamFailed(e);
                        }
                    }
                });
    }

    //36.获取报警联动总布防状态-云视通2.0
    public void octGetAlarmLinkDefenceParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetAlarmLinkDefenceParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctAlarmLinkDefenceBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAlarmLinkDefenceBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctAlarmLinkDefenceBean octImageDncutParamBean) {
                        if (hasView()) {
                            mView.getAlarmLinkDefenceParamSuccess(octImageDncutParamBean.getResult());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.getAlarmLinkDefenceParamFailed(e);
                        }
                    }
                });
    }

    //37.设置报警联动总布防状态-云视通2.0
    public void octSetAlarmLinkDefenceParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetAlarmLinkDefenceParam(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setAlarmLinkDefenceParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.setAlarmLinkDefenceParamFailed(e);
                        }
                    }
                });
    }

    //38.设置驱离-云视通2.0
    public void octSetAlarmLinkTrigger(String deviceSn, int channelId, String devUser, String devPwd, String status, boolean isNotShowProgress) {
        mModel.octSetAlarmLinkTrigger(deviceSn, channelId, devUser, devPwd, status).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, isNotShowProgress) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setAlarmLinkTriggerSuccess(status);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.setAlarmLinkTriggerFailed(status, e);
                        }
                    }
                });
    }

    //39.获取码流参数-云视通2.0
    public void octGetStreamParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetStreamParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctStreamGetParams>compatResult())
                .subscribe(new ProgressSubcriber<OctStreamGetParams>(mContext, mView, true) {
                    @Override
                    public void onNext(OctStreamGetParams bean) {
                        if (hasView()) {
                            mView.getStreamParamSuccess(bean.getResult());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.getStreamParamFailed(e);
                        }
                    }
                });
    }

    //40.设置码流参数-云视通2.0
    public void octSetStreamParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetStreamParam(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setStreamParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.setStreamParamFailed(e);
                        }
                    }
                });
    }



    /**
     * 3 获取设备卡信息
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetStorageInfo(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetStorageInfo(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctSDCardInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<OctSDCardInfoBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctSDCardInfoBean octSDCardInfoBean) {
                        if (hasView()) {
                            mView.octGetStorageInfoSuccess(octSDCardInfoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetStorageInfoFailed(e);
                        }
                    }
                });
    }

    /**
     * 4 格式化SD存储卡
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octStorageFormat(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octStorageFormat(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octStorageFormatSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octStorageFormatFailed(e);
                        }
                    }
                });
    }


    /**
     * 5 云视通2.0格式化SD卡进度获取
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param diskNum
     * @param diskName
     */
    public void octGetStorageFormatProgress(String deviceSn, int channelId, String devUser, String devPwd, int diskNum, String diskName) {
        mModel.octGetStorageFormatProgress(deviceSn, channelId, devUser, devPwd, diskNum, diskName).compose(RxHttpReponseCompat.<OctSDCardFormatProBean>compatResult())
                .subscribe(new ProgressSubcriber<OctSDCardFormatProBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctSDCardFormatProBean octSDCardFormatProBean) {
                        if (hasView()) {
                            mView.octGetStorageFormatProgressSuccess(octSDCardFormatProBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetStorageFormatProgressFailed(e);
                        }
                    }
                });
    }


    public void octGetAlarmLinkId(String deviceSn, int channelId, String devUser, String devPwd, String module) {
        mModel.octGetAlarmLinkId(deviceSn,channelId, devUser,devPwd, module).compose(RxHttpReponseCompat.<AlarmLinkIdBean>compatResult())
                .subscribe(new ProgressSubcriber<AlarmLinkIdBean>(mContext, mView, true) {
                    @Override
                    public void onNext(AlarmLinkIdBean bean) {
                        if (hasView()) {
                            mView.getAlarmLinkIdSuccess(deviceSn, channelId, bean.getResult());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.getAlarmLinkIdFailed(deviceSn, channelId, e);
                        }
                    }
                });
    }

    public void octAlarmLinkGet(String deviceSn, int channelId, String devUser, String devPwd, int linkId, boolean bDefault) {
        mModel.octAlarmLinkGet(deviceSn,channelId, devUser,devPwd, linkId, bDefault).compose(RxHttpReponseCompat.<OctAlarmLinkGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAlarmLinkGetBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctAlarmLinkGetBean octAlarmLinkGetBean) {
                        if (hasView()) {
                            octAlarmLinkGetBean.getResult().setChannelid(channelId);
                            octAlarmLinkGetBean.getResult().setLink_id(linkId);
                            mView.getAlarmLinkSuccess(deviceSn, channelId, octAlarmLinkGetBean.getResult());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.getAlarmLinkFailed(deviceSn, channelId, e);
                        }
                    }
                });
    }



    public void octGetDevHwinfo(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp) {
        mModel.octGetDevHwinfo(deviceSn, channelId, devUser, devPwd, isAp).compose(RxHttpReponseCompat.<OctDevInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<OctDevInfoBean>(mContext, mView, false) {
                    @Override
                    public void onNext(OctDevInfoBean octDevInfoBean) {
                        if (hasView()) {
                            mView.octGetDevHwinfoSuccess(octDevInfoBean, deviceSn, channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetDevHwinfoFailed(e, deviceSn, channelId);
                        }
                    }
                });
    }


    public void octGetDevHwinfoNotLoading(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp) {
        mModel.octGetDevHwinfo(deviceSn, channelId, devUser, devPwd, isAp).compose(RxHttpReponseCompat.<OctDevInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<OctDevInfoBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctDevInfoBean octDevInfoBean) {
                        if (hasView()) {
                            mView.octGetDevHwinfoSuccess(octDevInfoBean,deviceSn,channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetDevHwinfoFailed(e,deviceSn,channelId);
                        }
                    }
                });
    }



    public void octGetDevVerificationCode(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp) {
        mModel.octGetDevVerificationCode(deviceSn, channelId, devUser, devPwd, isAp).compose(RxHttpReponseCompat.<OctDevGetVC>compatResult())
                .subscribe(new ProgressSubcriber<OctDevGetVC>(mContext, mView, false) {
                    @Override
                    public void onNext(OctDevGetVC octDevGetVC) {
                        if (hasView()) {
                            mView.octGetDevVerificationCodeSuccess(octDevGetVC);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetDevVerificationCodeFailed(e);
                        }
                    }
                });
    }


    public void octAccountModifyUser(String deviceSn, int channelId, String devUser, String devPwd, String newDevUser, String newDevPwd) {
        mModel.octAccountModifyUser(deviceSn, channelId, devUser, devPwd, newDevUser, newDevPwd).compose(RxHttpReponseCompat.<OctAccountModifyUserBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAccountModifyUserBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctAccountModifyUserBean octAccountModifyUserBean) {
                        if (hasView()) {
                            mView.octAccountModifyUserSuccess(octAccountModifyUserBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octAccountModifyUserFailed(e);
                        }
                    }
                });
    }


    public void editDeviceYst(String deviceSn, String newDevUser,String newDevPwd) {
        mModel.editDeviceYst(deviceSn,newDevUser, newDevPwd).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.editDeviceYstSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.editDeviceYstFailed(e);
                        }
                    }
                });
    }


//    /**
//     * 尝试调起播放器播放视频
//     *
//     * @param path      视频地址
//     * @param videoFile 视频文件
//     */
//    public void tryPlayVideo(File videoFile, String path) {
//
//        Intent intent = new Intent(UIUtil.getContext(), PhotoVideoActivity.class);
//        PhotoVideoFragment.selectedIndex = 0;
//        intent.putExtra("isVideoMode", true);
//        UIUtil.startActivity(intent);
//
////        Intent intent = new Intent();
////        intent.setAction(Intent.ACTION_VIEW);
////        // 7.0以上
////        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
////            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
////            Uri uri = FileProvider.getUriForFile(UIUtil.getContext(), UIUtil.getContext().getPackageName() + ".provider", videoFile);
////            intent.setDataAndType(uri, "video/mp4");
////        } else {
////            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////            Uri uri = Uri.parse(path);
////            if (uri.getScheme() == null || uri.getScheme().isEmpty() || uri.getPath() == null || uri.getPath().isEmpty()) {
////                uri = Uri.parse("file://" + path);
////            }
////            intent.setDataAndType(uri, "video/mp4");
////        }
////
////        ComponentName componentName = intent.resolveActivity
////                (UIUtil.getContext().getPackageManager());
////        if (componentName != null) {
////            UIUtil.startActivity(intent);
////        }
//    }


    public void shareToMe(String deviceSn) {//,String channelId
        LogUtil.e("shareToMe-tiaoshi", "3-ptzPresenter:shareToMe-enter");
        mModel.shareToMe(deviceSn).compose(RxHttpReponseCompat.<List<ShareToMeBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<ShareToMeBean>>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull List<ShareToMeBean> shareToMeBeanList) {
                        LogUtil.e("shareToMe-tiaoshi", "3-ptzPresenter:shareToMe-success");
                        if (hasView()) {
                            mView.shareToMeSuccess(shareToMeBeanList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("shareToMe-tiaoshi", "3-ptzPresenter:shareToMe-failed");
                        super.onError(e);
                        if (hasView()) {
                            mView.shareToMeError(e);
                        }
                    }
                });
    }


    //copy DeviceSettingPresenter
    public void getHideStatus(String deviceSn, int channelId) {
        mModel.getHideStatus(deviceSn, channelId).compose(RxHttpReponseCompat.<EnableBean>compatResult())
                .subscribe(new ProgressSubcriber<EnableBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EnableBean enableBean) {
                        if (hasView()) {
                            mView.getHideStatusSuccess(deviceSn, channelId, enableBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getHideStatusError(e);
                        }
                    }
                });

    }

    //copy DeviceSettingPresenter
    public void setHideStatus(String deviceSn, int channelId, boolean enable) {
        mModel.setHideStatus(deviceSn, channelId, enable).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setHideStatusSuccess(enable);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setHideStatusError(e);
                        }
                    }
                });
    }


    //查询有图片日期
    public void getSnapFileDateList(String deviceSn, int channelId, int startYear, int startMonth, String devUser, String devPwd, boolean isAp) {
        mModel.getSnapFileDateList(deviceSn, channelId, startYear, startMonth, devUser, devPwd, isAp).compose(RxHttpReponseCompat.<SnapDateBean>compatResult())
                .subscribe(new ProgressSubcriber<SnapDateBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull SnapDateBean snapDateBean) {
                        if (hasView()) {
                            mView.getSnapFileDateListSuccess(snapDateBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
//                            if (isShowProgress()){
//                                mView.dismissLoading();
//                            }
                            mView.getSnapFileDateListFailed(e);
                        }
                    }
                });
    }


    //查询有图片日期
    public void getSnapFileList(String deviceSn, int channelId, int startYear, int startMonth, int startDay, int page, int pageSize, String devUser, String devPwd, boolean isAp) {
        mModel.getSnapFileList(deviceSn, channelId, startYear, startMonth, startDay, page, pageSize, devUser, devPwd, isAp).compose(RxHttpReponseCompat.<SnapFileListBean>compatResult())
                .subscribe(new ProgressSubcriber<SnapFileListBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull SnapFileListBean snapFileListBean) {
                        if (hasView()) {
                            mView.getSnapFileListSuccess(snapFileListBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
//                            if (isShowProgress()){
//                                mView.dismissLoading();
//                            }
                            mView.getSnapFileListFailed(e);
                        }
                    }
                });
    }


    /**
     * 对讲模式切换-公有云设备
     *
     * @param
     */
    public void publicChatSetParam(String deviceSn, int channelId, boolean singleCall, String devUser, String devPwd) {
        LogUtil.e("CallParamSet", "publicChatSetParam-deviceSn=" + deviceSn + ";channelId=" + channelId + ";singleCall=" + singleCall);
        mModel.publicChatSetParam(deviceSn, channelId, singleCall, devUser, devPwd).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            LogUtil.e("CallParamSet", "publicChatSetParam-publicChatSetParamSuccess");
                            mView.publicChatSetParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            LogUtil.e("CallParamSet", "publicChatSetParam-publicChatSetParamFailed");
                            mView.publicChatSetParamFailed(e);
                        }
                    }
                });
    }


    /**
     * 54 对讲模式切换-云视通2.0
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octChatSetParam(String deviceSn, int channelId, boolean singleCall, String devUser, String devPwd, boolean isAp) {
        LogUtil.e("CallParamSet", "octChatSetParam-deviceSn=" + deviceSn + ";channelId=" + channelId + ";singleCall=" + singleCall + ";isAp=" + isAp);
        mModel.octChatSetParam(deviceSn, channelId, singleCall, devUser, devPwd, isAp).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            LogUtil.e("CallParamSet", "octChatSetParam-octChatSetParamSuccess,singleCall=" + singleCall);
                            mView.octChatSetParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            LogUtil.e("CallParamSet", "octChatSetParam-octChatSetParamFailed");
                            mView.octChatSetParamFailed(e);
                        }
                    }
                });
    }


    /**
     * 40 云视通2.0获取图像能力
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetImageAbility(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp) {
        mModel.octGetImageAbility(deviceSn, channelId, devUser, devPwd, isAp).compose(RxHttpReponseCompat.<OctImageAbilityGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctImageAbilityGetBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctImageAbilityGetBean octImageAbilityGetBean) {
                        if (hasView()) {
                            mView.octGetImageAbilitySuccess(octImageAbilityGetBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetImageAbilityFailed(e);
                        }
                    }
                });
    }


    /**
     * 56 云视通2.0获取图像调节参数
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd, boolean isAp) {
        mModel.octGetImageAdjustParam(deviceSn, channelId, devUser, devPwd, isAp).compose(RxHttpReponseCompat.<OctImageAdjustParamBean>compatResult())
                .subscribe(new ProgressSubcriber<OctImageAdjustParamBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctImageAdjustParamBean bean) {
                        if (hasView()) {
                            mView.octGetImageAdjustParamSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetImageAdjustParamFailed(e);
                        }
                    }
                });
    }


    /**
     * 57 云视通2.0设置图像调节参数
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd, String param, boolean isAp) {
        mModel.octSetImageAdjustParam(deviceSn, channelId, devUser, devPwd, param, isAp).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetImageAdjustParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octSetImageAdjustParamFailed(e);
                        }
                    }
                });
    }


    public void getScreenOverturn(String deviceSn, int channelId) {
        mModel.getScreenOverturn(deviceSn, channelId).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<GetScreenOverTurnBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull GetScreenOverTurnBean getScreenOverTurnBean) {
                        if (hasView()) {
                            mView.getScreenOverturnSuccess(getScreenOverTurnBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getScreenOverturnError(e);
                        }
                    }
                });
    }

    public void controlScreenOverturn(String deviceSn, int channelId, boolean overTurn, boolean rotation) {
        mModel.controlScreenOverturn(deviceSn, channelId, overTurn, rotation).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.controlScreenOverturnSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.controlScreenOverturnError(e);
                        }
                    }
                });

    }




    //车牌识别参数获取接口
    public void getParamLPRSystem(String deviceSn, int channelId) {
        mModel.getParamLPRSystem(deviceSn, channelId)
                .compose(RxHttpReponseCompat.<RDLPRSystemGetParam>compatResult())
                .subscribe(new ProgressSubcriber<RDLPRSystemGetParam>(mContext, mView, false) {
                    @Override
                    public void onNext(RDLPRSystemGetParam rdlprSystemGetParam) {
                        if (hasView()) {
                            mView.getParamLPRSystemSuccess(deviceSn,channelId,rdlprSystemGetParam);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getParamLPRSystemFailed(deviceSn,channelId,e);
                        }
                    }
                });
    }

    //车牌识别参数设置接口
    public void setParamLPRSystem(String deviceSn, int channelId, RDLPRSystemGetParam.ResultBean resultBean) {
        mModel.setParamLPRSystem(deviceSn, channelId,resultBean)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setParamLPRSystemSuccess(deviceSn,channelId,emptyBean);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setParamLPRSystemFailed(deviceSn,channelId,e);
                        }
                    }
                });
    }

    public void getAlarmStatus(String deviceSn, int channelId) {
        mModel.getAlarmStatus(deviceSn, channelId).compose(RxHttpReponseCompat.<AlarmStatusBean>compatResult())
                .subscribe(new ProgressSubcriber<AlarmStatusBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull AlarmStatusBean bean) {
                        if (hasView()){
                            mView.getAlarmStatusSuccess(deviceSn,channelId,bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.getAlarmStatusError(e);
                        }
                    }
                });

    }

    public void cancelAlarmStatus(String deviceSn, int channelId) {
        mModel.cancelAlarmStatus(deviceSn, channelId).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.cancelAlarmStatusSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.cancelAlarmStatusError(e);
                        }
                    }
                });
    }

    public void cancelAlarmManual(String deviceSn, int channelId, String alarmType) {
        mModel.cancelAlarmManual(deviceSn, channelId, alarmType).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.cancelAlarmManualSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.cancelAlarmManualError(e);
                        }
                    }
                });
    }

    public void octCancelAlarmManual(String deviceSn, int channelId, String devUser, String devPwd, String alarmType) {
        mModel.octCancelAlarmManual(deviceSn, channelId, devUser, devPwd, alarmType).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.cancelAlarmManualSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.cancelAlarmManualError(e);
                        }
                    }
                });
    }


    //获取4G卡列表
    public void getSimCardList(String deviceSn, int channelId, boolean isNotShowProgress) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ifconfig_get_simcardlist");
        HashMap<String, Object> param = new HashMap<>();
//        param.put("channelid", channelId);
        body.put("param", param);
        mModel.get4GSimCardList(deviceSn, channelId, body).compose(RxHttpReponseCompat.<SimCardListBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<SimCardListBean.ResultBean>(mContext, mView, isNotShowProgress) {
                    @Override
                    public void onNext(@NonNull SimCardListBean.ResultBean bean) {
                        if (hasView()) {
                            mView.get4GSimCardListSuccess(deviceSn, channelId, bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.get4GSimCardListError(deviceSn, channelId, e);
                        }
                    }
                });
    }


}
