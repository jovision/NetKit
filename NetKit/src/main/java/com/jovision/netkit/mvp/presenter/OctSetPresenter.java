package com.jovision.netkit.mvp.presenter;

import com.alibaba.fastjson.JSONObject;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.OctIvpVfBean;
import com.jovision.netkit.mvp.data.bean.request.DeleteDevicesBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmLinkIdBean;
import com.jovision.netkit.mvp.data.bean.response.OctAccountModifyUserBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmLinkGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmSoundGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmSoundListGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctAudioAbilityGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctAudioAoGetParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctChannelAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevIPInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevNtpBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevUpdateBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevUpdateCheckBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevUpdateProgressBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAbilityGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAdjustParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageDncutParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageExpertBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctIntelEbikeDetectionBean;
import com.jovision.netkit.mvp.data.bean.response.OctInvadeBean;
import com.jovision.netkit.mvp.data.bean.response.OctIvpBean;
import com.jovision.netkit.mvp.data.bean.response.OctIvpFacercgParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctIvpHideBean;
import com.jovision.netkit.mvp.data.bean.response.OctMotionDetectBean;
import com.jovision.netkit.mvp.data.bean.response.OctMotionTrackBean;
import com.jovision.netkit.mvp.data.bean.response.OctOsdParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctRecordGetInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctSDCardFormatProBean;
import com.jovision.netkit.mvp.data.bean.response.OctSDCardInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctStreamGetAllAbility;
import com.jovision.netkit.mvp.data.bean.response.OctStreamGetParams;
import com.jovision.netkit.mvp.data.bean.response.OctTimeBean;
import com.jovision.netkit.mvp.data.bean.response.OctTimingSnapBean;
import com.jovision.netkit.mvp.data.bean.response.OctWifiListAp;
import com.jovision.netkit.mvp.data.bean.response.OnvifGetDiscoveryInfo;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.OctSetContract;


import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by ZHP on 2017/7/19.
 */


public class OctSetPresenter extends BasePresenter<OctSetContract.IOctSetModel, OctSetContract.View> {

    @Inject
    public OctSetPresenter(OctSetContract.IOctSetModel iOctSetModel, OctSetContract.View view) {
        super(iOctSetModel, view);
    }


    /**
     * 1 获取设备详情
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetDevHwinfo(String deviceSn, int channelId,
                                String devUser, String devPwd, boolean isNotShowProgress) {
        mModel.octGetDevHwinfo(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctDevInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<OctDevInfoBean>(mContext, mView, isNotShowProgress) {
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


    /**
     * 2 修改管理员密码
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param newDevUser
     * @param newDevPwd
     */
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


    /**
     * 6 云视通2.0获取IPC设备录像信息
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetRecordMode(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetRecordMode(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctRecordGetInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<OctRecordGetInfoBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctRecordGetInfoBean octRecordInfoBean) {
                        if (hasView()) {
                            mView.octGetRecordModeSuccess(octRecordInfoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetRecordModeFailed(e);
                        }
                    }
                });
    }


    /**
     * 7 云视通2.0设置IPC设备录像信息
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octSetRecordMode(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetRecordMode(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetRecordModeSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetRecordModeFailed(e);
                        }
                    }
                });
    }


    /**
     * 8 云视通2.0获取网络配置-给ipc设置ip使用
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetInetConfig(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetInetConfig(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctDevIPInfoBean>compatResult())
                .subscribe(new ProgressSubcriber<OctDevIPInfoBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctDevIPInfoBean octDevIPInfoBean) {
                        if (hasView()) {
                            mView.octGetInetConfigSuccess(octDevIPInfoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetInetConfigFailed(e);
                        }
                    }
                });
    }

    /**
     * 8.1 云视通2.0获取设备端wifi列表-给ipc设置ip使用
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetDevWifiListAp(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetDevWifiListAp(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctWifiListAp>compatResult())
                .subscribe(new ProgressSubcriber<OctWifiListAp>(mContext, mView, false) {
                    @Override
                    public void onNext(OctWifiListAp octWifiListAp) {
                        if (hasView()) {
                            mView.octGetDevWifiListApSuccess(octWifiListAp);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetDevWifiListApFailed(e);
                        }
                    }
                });
    }


    /**
     * 8.2 云视通2.0在线配网-给ipc设置ip使用
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param wifiName
     * @param wifiPassword
     */
    public void octOnLineWifiConnect(String deviceSn, int channelId, String devUser, String devPwd,String wifiName,String wifiPassword) {
        mModel.octOnLineWifiConnect(deviceSn, channelId, devUser, devPwd,wifiName,wifiPassword).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octOnLineWifiConnectSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octOnLineWifiConnectFailed(e);
                        }
                    }
                });
    }


    /**
     * 9 云视通2.0设置网络配置-给ipc设置ip使用
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octSetInetConfig(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetInetConfig(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetInetConfigSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetInetConfigFailed(e);
                        }
                    }
                });
    }

    /**
     * 10 云视通2.0获取移动侦测报警模式
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetIvpSupport(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetIvpSupport(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctIvpBean>compatResult())
                .subscribe(new ProgressSubcriber<OctIvpBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctIvpBean octIvpBean) {
                        if (hasView()) {
                            mView.octGetIvpSupportSuccess(octIvpBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetIvpSupportFailed(e);
                        }
                    }
                });
    }


    /**
     * 11 云视通2.0设置移动侦测报警模式
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetMdetectParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetMdetectParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctMotionDetectBean>compatResult())
                .subscribe(new ProgressSubcriber<OctMotionDetectBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctMotionDetectBean octMotionDetectBean) {
                        if (hasView()) {
                            mView.octGetMdetectParamSuccess(octMotionDetectBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetMdetectParamFailed(e);
                        }
                    }
                });
    }




    /**
     * 12 云视通2.0设置移动侦测报警模式
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octSetMdetectParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetMdetectParam(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetMdetectParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetMdetectParamFailed(e);
                        }
                    }
                });
    }





    /**
     * 13 云视通2.0获取移动跟踪报警模式
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetMoveTrack(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetMoveTrack(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctMotionTrackBean>compatResult())
                .subscribe(new ProgressSubcriber<OctMotionTrackBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctMotionTrackBean octMotionTrackBean) {
                        if (hasView()) {
                            mView.octGetMoveTrackSuccess(octMotionTrackBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetMoveTrackFailed(e);
                        }
                    }
                });
    }


    /**
     * 14 云视通2.0设置移动跟踪报警模式
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetMoveTrack(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetMoveTrack(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetMoveTrackSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetMoveTrackFailed(e);
                        }
                    }
                });
    }


    /**
     * 15 云视通2.0获取绊线/区域入侵报警模式
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetIvpRlParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetIvpRlParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctInvadeBean>compatResult())
                .subscribe(new ProgressSubcriber<OctInvadeBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctInvadeBean octInvadeBean) {
                        if (hasView()) {
                            mView.octGetIvpRlParamSuccess(octInvadeBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetIvpRlParamFailed(e);
                        }
                    }
                });
    }



    /**
     * 16 云视通2.0设置绊线/区域入侵报警模式
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetIvpRlParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetIvpRlParam(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetIvpRlParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetIvpRlParamFailed(e);
                        }
                    }
                });
    }


    /**
     * 17 云视通2.0获取遮挡报警模式
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetIvpHideParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetIvpHideParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctIvpHideBean>compatResult())
                .subscribe(new ProgressSubcriber<OctIvpHideBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctIvpHideBean octIvpHideBean) {
                        if (hasView()) {
                            mView.octGetIvpHideParamSuccess(octIvpHideBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetIvpHideParamFailed(e);
                        }
                    }
                });
    }





    /**
     * 18 云视通2.0设置遮挡报警模式
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetIvpHideParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetIvpHideParam(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetIvpHideParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetIvpHideParamFailed(e);
                        }
                    }
                });
    }



    /**
     * 19 云视通2.0获取电动车报警模式
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetIntelEbikeDetect(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetIntelEbikeDetect(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctIntelEbikeDetectionBean>compatResult())
                .subscribe(new ProgressSubcriber<OctIntelEbikeDetectionBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctIntelEbikeDetectionBean octIntelEbikeDetectionBean) {
                        if (hasView()) {
                            mView.octGetIntelEbikeDetectSuccess(octIntelEbikeDetectionBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetIntelEbikeDetectFailed(e);
                        }
                    }
                });
    }

    /**
     * 20 云视通2.0设置电动车报警模式
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetIntelEbikeDetect(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetIntelEbikeDetect(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetIntelEbikeDetectSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetIntelEbikeDetectFailed(e);
                        }
                    }
                });
    }



    /**
     * 21 云视通2.0获取当前选中的报警音
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetAlarmSound(String deviceSn, int channelId, String devUser, String devPwd,String fileName,boolean bGetData) {
        mModel.octGetAlarmSound(deviceSn, channelId, devUser, devPwd,fileName,bGetData).compose(RxHttpReponseCompat.<OctAlarmSoundGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAlarmSoundGetBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctAlarmSoundGetBean octAlarmSoundGetBean) {
                        if (hasView()) {
                            mView.octGetAlarmSoundSuccess(octAlarmSoundGetBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetAlarmSoundFailed(e);
                        }
                    }
                });
    }






    /**
     * 22 云视通2.0设置报警音
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetAlarmSound(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetAlarmSound(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetAlarmSoundSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetAlarmSoundFailed(e);
                        }
                    }
                });
    }




    /**
     * 25 云视通2.0是否支持报警音量设置
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetAudioAbility(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetAudioAbility(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctAudioAbilityGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAudioAbilityGetBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctAudioAbilityGetBean octAudioAbilityGetBean) {
                        if (hasView()) {
                            mView.octGetAudioAbilitySuccess(octAudioAbilityGetBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetAudioAbilityFailed(e);
                        }
                    }
                });
    }




    /**
     * 26 云视通2.0报警声音音量获取
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetAoParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetAoParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctAudioAoGetParamBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAudioAoGetParamBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctAudioAoGetParamBean octAudioAoGetParamBean) {
                        if (hasView()) {
                            mView.octGetAoParamSuccess(octAudioAoGetParamBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetAoParamFailed(e);
                        }
                    }
                });
    }


    /**
     * 27 云视通2.0报警声音音量设置
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetAoParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetAoParam(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetAoParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetAoParamFailed(e);
                        }
                    }
                });
    }



    /**
     * 28 云视通2.0获取网络校时状态
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetDevNtp(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetDevNtp(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctDevNtpBean>compatResult())
                .subscribe(new ProgressSubcriber<OctDevNtpBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctDevNtpBean octDevNtpBean) {
                        if (hasView()) {
                            mView.octGetDevNtpSuccess(octDevNtpBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetDevNtpFailed(e);
                        }
                    }
                });
    }


    /**
     * 29 云视通2.0设置网络校时状态
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetDevNtp(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetDevNtp(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetDevNtpSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetDevNtpFailed(e);
                        }
                    }
                });
    }





    /**
     * 30 云视通2.0获取日期格式
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetChnosdParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetChnosdParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctOsdParamBean>compatResult())
                .subscribe(new ProgressSubcriber<OctOsdParamBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctOsdParamBean octOsdParamBean) {
                        if (hasView()) {
                            mView.octGetChnosdParamSuccess(octOsdParamBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetChnosdParamFailed(e);
                        }
                    }
                });
    }




    /**
     * 31 云视通2.0设置日期格式
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetChnosdParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetChnosdParam(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetChnosdParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetChnosdParamFailed(e);
                        }
                    }
                });
    }



    /**
     * 32 云视通2.0获取设备时间
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetDevTime(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetDevTime(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctTimeBean>compatResult())
                .subscribe(new ProgressSubcriber<OctTimeBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctTimeBean octTimeBean) {
                        if (hasView()) {
                            mView.octGetDevTimeSuccess(octTimeBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetDevTimeFailed(e);
                        }
                    }
                });
    }



    /**
     * 33 云视通2.0设置设备时间
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetDevTime(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetDevTime(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetDevTimeSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetDevTimeFailed(e);
                        }
                    }
                });
    }




    /**
     * 34 云视通2.0重启设备
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octRebootDev(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octRebootDev(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octRebootDevSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octRebootDevFailed(e);
                        }
                    }
                });
    }

    /**
     * 35 云视通2.0重置设备
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octResetDev(String deviceSn, int channelId, String devUser, String devPwd, boolean isSimple) {
        mModel.octResetDev(deviceSn, channelId, devUser, devPwd, isSimple).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octResetDevSuccess(isSimple);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octResetDevFailed(e);
                        }
                    }
                });
    }




    /**
     * 36 云视通2.0检查设备是否需要升级
     *
     * @param deviceSn
     * @param devUser
     * @param devPwd
     */
    public void octCheckDevUpdate(String deviceSn,  String devUser, String devPwd) {
        mModel.octCheckDevUpdate(deviceSn,devUser, devPwd).compose(RxHttpReponseCompat.<OctDevUpdateCheckBean>compatResult())
                .subscribe(new ProgressSubcriber<OctDevUpdateCheckBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctDevUpdateCheckBean octDevUpdateCheckBean) {
                        if (hasView()) {
                            mView.octCheckDevUpdateSuccess(octDevUpdateCheckBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octCheckDevUpdateFailed(e);
                        }
                    }
                });
    }


    /**
     * 37 云视通2.0设备升级
     *
     * @param deviceSn
     * @param devUser
     * @param devPwd
     */
    public void octDevUpdate(String deviceSn, String devUser, String devPwd) {
        mModel.octDevUpdate(deviceSn,devUser, devPwd).compose(RxHttpReponseCompat.<OctDevUpdateBean>compatResult())
                .subscribe(new ProgressSubcriber<OctDevUpdateBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctDevUpdateBean octDevUpdateBean) {
                        if (hasView()) {
                            mView.octDevUpdateSuccess(octDevUpdateBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octDevUpdateFailed(e);
                        }
                    }
                });
    }



    /**
     * 38 云视通2.0设备升级进度
     *
     * @param deviceSn
     * @param devUser
     * @param devPwd
     */
    public void octGetDevUpdateProgress(String deviceSn, String devUser, String devPwd) {
        mModel.octGetDevUpdateProgress(deviceSn,devUser, devPwd).compose(RxHttpReponseCompat.<OctDevUpdateProgressBean>compatResult())
                .subscribe(new ProgressSubcriber<OctDevUpdateProgressBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctDevUpdateProgressBean octDevUpdateProgressBean) {
                        if (hasView()) {
                            mView.octGetDevUpdateProgressSuccess(octDevUpdateProgressBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetDevUpdateProgressFailed(e);
                        }
                    }
                });
    }



    /**
     * 39 云视通2.0设置双光源灯光开关
     * @param deviceSn
     * @param devUser
     * @param devPwd
     * @param bOpen
     */
    public void octManualSetAlarmLight(String deviceSn,  String devUser, String devPwd, boolean bOpen) {
        mModel.octManualSetAlarmLight(deviceSn, devUser,devPwd, bOpen).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octManualSetAlarmLightSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octManualSetAlarmLightFailed(e);
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
    public void octGetImageAbility(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetImageAbility(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctImageAbilityGetBean>compatResult())
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
     * 41 云视通2.0设置车牌模式是否开启
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetImageExpertSettingParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetImageExpertSettingParam(deviceSn,channelId, devUser,devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetImageExpertSettingParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octSetImageExpertSettingParamFailed(e);
                        }
                    }
                });
    }




    /**
     * 42 云视通2.0获取车牌模式是否开启
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetImageExpertSettingParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetImageExpertSettingParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctImageExpertBean>compatResult())
                .subscribe(new ProgressSubcriber<OctImageExpertBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctImageExpertBean octImageExpertBean) {
                        if (hasView()) {
                            mView.octGetImageExpertSettingParamSuccess(octImageExpertBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetImageExpertSettingParamFailed(e);
                        }
                    }
                });
    }


    /**
     * 43 云视通2.0获取图像参数
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetImageParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetImageParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctImageParamBean>compatResult())
                .subscribe(new ProgressSubcriber<OctImageParamBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctImageParamBean octImageParamBean) {
                        if (hasView()) {
                            mView.octGetImageParamSuccess(octImageParamBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetImageParamFailed(e);
                        }
                    }
                });
    }


    /**
     * 44 云视通2.0设置图像参数
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetImageParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetImageParam(deviceSn,channelId, devUser,devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetImageParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octSetImageParamFailed(e);
                        }
                    }
                });
    }


    /**
     * 45 云视通2.0获取人脸识别的参数
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetIvpFacercgParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetIvpFacercgParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctIvpFacercgParamBean>compatResult())
                .subscribe(new ProgressSubcriber<OctIvpFacercgParamBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctIvpFacercgParamBean octIvpFacercgParamBean) {
                        if (hasView()) {
                            mView.octGetIvpFacercgParamSuccess(octIvpFacercgParamBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetIvpFacercgParamFailed(e);
                        }
                    }
                });
    }



    /**
     * 46 云视通2.0设置人脸识别的参数
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetIvpFacercgParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetIvpFacercgParam(deviceSn,channelId, devUser,devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetIvpFacercgParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octSetIvpFacercgParamFailed(e);
                        }
                    }
                });
    }



    /**
     * 47 云视通2.0设置LED指示灯状态
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @mode mode 自动:0 ,常开:1,常灭:2
     */
    public void octSetIndicatorled(String deviceSn, int channelId, String devUser, String devPwd, int mode) {
        mModel.octSetIndicatorled(deviceSn,channelId, devUser,devPwd, mode).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetIndicatorledSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octSetIndicatorledFailed(e);
                        }
                    }
                });
    }


    /**
     * 48 云视通2.0获取日夜切换配置
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetImageDncutParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctImageDncutParamBean>compatResult())
                .subscribe(new ProgressSubcriber<OctImageDncutParamBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctImageDncutParamBean octImageDncutParamBean) {
                        if (hasView()) {
                            mView.octGetImageDncutParamSuccess(octImageDncutParamBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetImageDncutParamFailed(e);
                        }
                    }
                });
    }


    /**
     * 49 云视通2.0设置日夜切换配置
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetImageDncutParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetImageDncutParam(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetImageDncutParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octSetImageDncutParamFailed(e);
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
    public void octGetChannelsFeatures(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetChannelsFeatures(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctChannelAbilityBean>compatResult())
                .subscribe(new ProgressSubcriber<OctChannelAbilityBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctChannelAbilityBean octChannelAbilityBean) {
                        if (hasView()) {
                            mView.octGetChannelsFeaturesSuccess(octChannelAbilityBean,deviceSn,channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetChannelsFeaturesFailed(e,deviceSn,channelId);
                        }
                    }
                });
    }


    /**
     * 51 云视通2.0定时抓拍参数获取
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetTimingSnap(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetTimingSnap(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctTimingSnapBean>compatResult())
                .subscribe(new ProgressSubcriber<OctTimingSnapBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctTimingSnapBean octTimingSnapBean) {
                        if (hasView()) {
                            mView.octGetTimingSnapSuccess(octTimingSnapBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetTimingSnapFailed(e);
                        }
                    }
                });
    }

    /**
     * 52 云视通2.0定时抓拍参数设置
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetTimingSnap(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetTimingSnap(deviceSn,channelId, devUser,devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetTimingSnapSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octSetTimingSnapFailed(e);
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
    public void octGetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetImageAdjustParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctImageAdjustParamBean>compatResult())
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
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetImageAdjustParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetImageAdjustParam(deviceSn,channelId, devUser,devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
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



    /**
     * 58 云视通2.0获取报警音列表
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetAlarmSoundList(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetAlarmSoundList(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctAlarmSoundListGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAlarmSoundListGetBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctAlarmSoundListGetBean octAlarmSoundGetBean) {
                        if (hasView()) {
                            mView.octGetAlarmSoundListSuccess(octAlarmSoundGetBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetAlarmSoundListFailed(e);
                        }
                    }
                });
    }


    /**
     * 59云视通2.0添加自定义报警音
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param fileName
     * @param fileData
     */
    public void octAddAlarmSound(String deviceSn, int channelId, String devUser, String devPwd, String fileName,String fileData) {
        mModel.octAddAlarmSound(deviceSn,channelId, devUser,devPwd, fileName,fileData).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octAddAlarmSoundSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octAddAlarmSoundFailed(e);
                        }
                    }
                });
    }


    /**
     * 60 云视通2.0删除自定义报警音
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */

    public void octDeleteAlarmSound(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octDeleteAlarmSound(deviceSn,channelId, devUser,devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octDeleteAlarmSoundSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octDeleteAlarmSoundFailed(e);
                        }
                    }
                });
    }


    /**
     * 61 云视通2.0报警声音播放（设备端播放）
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param fileName
     */
    public void octAlarmSoundPlay(String deviceSn, int channelId, String devUser, String devPwd, String fileName) {
        mModel.octAlarmSoundPlay(deviceSn,channelId, devUser,devPwd, fileName).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {

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

    /**
     * 62 云视通2.0报警联动获取
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param linkId
     * @param bDefault
     */
    public void octAlarmLinkGet(String deviceSn, int channelId, String devUser, String devPwd, int linkId,boolean bDefault) {
        mModel.octAlarmLinkGet(deviceSn,channelId, devUser,devPwd, linkId,bDefault).compose(RxHttpReponseCompat.<OctAlarmLinkGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAlarmLinkGetBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctAlarmLinkGetBean octAlarmLinkGetBean) {
                        if (hasView()) {
                            if (octAlarmLinkGetBean != null && octAlarmLinkGetBean.getResult() != null) {
                                octAlarmLinkGetBean.getResult().setLink_id(linkId);
                            }
                            mView.octAlarmLinkGetSuccess(octAlarmLinkGetBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octAlarmLinkGetFailed(e);
                        }
                    }
                });
    }


    /**
     * 63 云视通2.0报警联动配置
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param paramObj
     */
    public void octAlarmLinkSet(String deviceSn, int channelId, String devUser, String devPwd, JSONObject paramObj) {
        mModel.octAlarmLinkSet(deviceSn,channelId, devUser,devPwd, paramObj).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octAlarmLinkSetSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octAlarmLinkSetFailed(e);
                        }
                    }
                });
    }


//    /**
//     * 54 对讲模式切换-云视通2.0
//     * @param deviceSn
//     * @param channelId
//     * @param devUser
//     * @param devPwd
//     * @param param
//     */
//    public void octChatSetParam(String deviceSn, int channelId, boolean singleCall,String devUser, String devPwd, String param) {
//        mModel.octChatSetParam(deviceSn,channelId,singleCall, devUser,devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
//                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
//                    @Override
//                    public void onNext(EmptyBean emptyBean) {
//                        if (hasView()) {
//                            mView.octChatSetParamSuccess();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        if (hasView()) {
//                            mView.octChatSetParamFailed(e);
//                        }
//                    }
//                });
//    }




    public void editDeviceYst(String deviceSn, String deviceName, String deviceUser, String newDevPwd) {
        mModel.editDeviceYst(deviceSn, deviceName, deviceUser, newDevPwd).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.editDeviceYstSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.editDeviceYstFailed(e);
                        }
                    }
                });
    }


    public void deleteDevices(DeleteDevicesBean deleteDevicesBean) {
        mModel.deleteDevices(deleteDevicesBean).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.deleteDevicesSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.deleteDevicesError(e);
                        }
                    }
                });
    }





    /**
     * 64 云视通2.0协议 获取1.0兼容配置
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetOnVifDiscoveryFlag(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetOnVifDiscoveryFlag(deviceSn,channelId, devUser,devPwd).compose(RxHttpReponseCompat.<OnvifGetDiscoveryInfo>compatResult())
                .subscribe(new ProgressSubcriber<OnvifGetDiscoveryInfo>(mContext, mView, false) {
                    @Override
                    public void onNext(OnvifGetDiscoveryInfo onvifGetDiscoveryInfo) {
                        if (hasView()) {
                            mView.octGetOnVifDiscoveryFlagSuccess(onvifGetDiscoveryInfo);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octGetOnVifDiscoveryFlagError(e);
                        }
                    }
                });
    }


    /**
     * 65 云视通2.0协议 设置1.0兼容设置
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octSetOnVifDiscoveryFlag(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octSetOnVifDiscoveryFlag(deviceSn,channelId, devUser,devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetOnVifDiscoveryFlagSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octSetOnVifDiscoveryFlagError(e);
                        }
                    }
                });
    }


    /**
     * 66.获取某个或所有通道的所有码流能力集
     * @param deviceSn
     * @param channelId
     */
    public void octGetStreamAllAbility(String deviceSn, int channelId,String devUser, String devPwd) {
        mModel.octGetStreamAllAbility(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctStreamGetAllAbility>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull OctStreamGetAllAbility octStreamGetAllAbility) {
                        if (hasView()) {
                            mView.octGetStreamAllAbilitySuccess(octStreamGetAllAbility);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetStreamAllAbilityError(e);
                        }
                    }
                });
    }

    /**
     * 获取某个或所有通道的所有码流参数
     * @param deviceSn
     * @param channelId
     */
    public void octGetStreamParams(String deviceSn, int channelId,String devUser, String devPwd) {
        mModel.octGetStreamParams(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctStreamGetParams>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull OctStreamGetParams octStreamGetParams) {
                        if (hasView()) {
                            mView.octGetStreamParamsSuccess(octStreamGetParams);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetStreamParamsError(e);
                        }
                    }
                });

    }

    /**
     * 设置多个通道的多个码流参数
     * @param deviceSn
     * @param channelId
     * @param
     */
    public void octSetStreamParams(String deviceSn, int channelId,String devUser, String devPwd, OctStreamGetParams.ResultBean octStreamGetParams) {
        mModel.octSetStreamParams(deviceSn, channelId, devUser, devPwd, octStreamGetParams).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetStreamParamsSuccess(emptyBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetStreamParamsError(e);
                        }
                    }
                });
    }

    /**
     * 恢复默认设置
     * @param deviceSn
     * @param channelId
     * @param
     */
    public void octSetDefaultCfg(String deviceSn, int channelId,String devUser, String devPwd) {
        mModel.octSetDefaultCfg(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetDefaultCfgSuccess(emptyBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octSetDefaultCfgError(e);
                        }
                    }
                });
    }






    /**
     * 云视通2.0-获取虚焦检测的参数
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octIvpVfGetParam(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octIvpVfGetParam(deviceSn, channelId, devUser, devPwd).compose(RxHttpReponseCompat.<OctIvpVfBean>compatResult())
                .subscribe(new ProgressSubcriber<OctIvpVfBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctIvpVfBean octIvpVfBean) {
                        if (hasView()) {
//                            octIvpVfBean.getResult().setChannelid(channelId);
                            mView.octIvpVfGetParamSuccess(octIvpVfBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octIvpVfGetParamError(e);
                        }
                    }
                });
    }


    /**
     * 云视通2.0-设置虚焦检测的参数
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param param
     */
    public void octIvpVfSetParam(String deviceSn, int channelId, String devUser, String devPwd, String param) {
        mModel.octIvpVfSetParam(deviceSn, channelId, devUser, devPwd, param).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octIvpVfSetParamSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octIvpVfSetParamError(e);
                        }
                    }
                });
    }

}

