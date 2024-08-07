package com.jovision.netkit.mvp.presenter;
import com.jovision.netkit.mvp.data.bean.AlarmSoundBean;
import com.jovision.netkit.mvp.data.bean.AlarmSoundVolumeBean;
import com.jovision.netkit.mvp.data.bean.ChannelBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.OctIvpVfBean;
import com.jovision.netkit.mvp.data.bean.RDLPRSystemGetParam;
import com.jovision.netkit.mvp.data.bean.request.SmartAppAlarmVoiceBean;
import com.jovision.netkit.mvp.data.bean.response.DefencePlanBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmCryBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmLiGangBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmPetBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmZhanDaoBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceAlarmZhoujieBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceSmartTrackBean;
import com.jovision.netkit.mvp.data.bean.response.GtrackGetCalibrationBean;
import com.jovision.netkit.mvp.data.bean.response.HideAlarmBean;
import com.jovision.netkit.mvp.data.bean.response.IntelligenceAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmLinkGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmSoundListGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageDncutParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctIvpBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAbilityDetailBean;
import com.jovision.netkit.mvp.data.bean.response.SmartAppAlarmVoiceResBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.DeviceAlarmSettingContract;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class DeviceAlarmSettingPresenter extends BasePresenter<DeviceAlarmSettingContract.IDeviceAlarmSettingModel, DeviceAlarmSettingContract.View> {
    @Inject
    public DeviceAlarmSettingPresenter(DeviceAlarmSettingContract.IDeviceAlarmSettingModel iDeviceSettingModel, DeviceAlarmSettingContract.View view) {
        super(iDeviceSettingModel, view);
    }

    public void sendCmdForAlarm(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.sendCmdForAlarm(deviceSn, channelId, body).compose(RxHttpReponseCompat.<DeviceAlarmBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceAlarmBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull DeviceAlarmBean deviceAlarmBean) {
                        if (hasView()) {
                            mView.sendCmdForAlarmSuccess(deviceAlarmBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.sendCmdForAlarmError(e);
                        }
                    }
                });
    }

    public void getParamsForZhoujie(String deviceSn, int channelId, HashMap<String, Object> body) {

        mModel.getParamsForZhoujie(deviceSn, channelId, body).compose(RxHttpReponseCompat.<DeviceAlarmZhoujieBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceAlarmZhoujieBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull DeviceAlarmZhoujieBean deviceAlarmBean) {
                        if (hasView()) {
                            mView.getParamsForZhoujieSuccess(deviceAlarmBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getParamsForZhoujieError(e);
                        }
                    }
                });
    }

    public void getSmartTrackParam(String deviceSn, int channelId, HashMap<String, Object> body) {


        mModel.getSmartTrackParam(deviceSn, channelId, body).compose(RxHttpReponseCompat.<DeviceSmartTrackBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceSmartTrackBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull DeviceSmartTrackBean deviceAlarmBean) {
                        if (hasView()) {
                            mView.getSmartTrackParamSuccess(deviceAlarmBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getSmartTrackParamError(e);
                        }
                    }
                });


    }


    public void openDeviceSmartTracking(String deviceSn, int channelId, HashMap<String, Object> body) {


        mModel.openDeviceSmartTracking(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.openDeviceSmartTrackingSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.openDeviceSmartTrackingError(e);
                        }
                    }
                });


    }

    public void setMotionAndHumanParams(String deviceSn, int channelId, HashMap<String, Object> body) {

        mModel.setMotionAndHumanParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setMotionAndHumanParamsSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setMotionAndHumanParamsError(e);
                        }
                    }
                });
    }

    public void setZhoujieParams(String deviceSn, int channelId, HashMap<String, Object> body) {

        mModel.setZhoujieParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setZhoujieParamsSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setZhoujieParamsError(e);
                        }
                    }
                });
    }

    //获取占道检测参数
    public void getParamsForZhanDao(String deviceSn, int channelId) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "intelligence_road_occupied_get_param");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("bdefault", false);
        body.put("param", param);
        mModel.getParamsForZhanDao(deviceSn, channelId, body).compose(RxHttpReponseCompat.<DeviceAlarmZhanDaoBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceAlarmZhanDaoBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull DeviceAlarmZhanDaoBean bean) {
                        if (hasView()) {
                            bean.setChannelid(channelId);
                            mView.getParamsForZhanDaoSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getParamsForZhanDaoError(e);
                        }
                    }
                });
    }

    //设置占道检测参数
    public void setZhanDaoParams(String deviceSn, int channelId, HashMap<String, Object> body) {

        mModel.setZhanDaoParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setZhanDaoParamsSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setZhanDaoParamsError(e);
                        }
                    }
                });
    }

    //获取离岗检测参数
    public void getParamsForLiGang(String deviceSn, int channelId) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ivp_pdleave_get_param");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        body.put("param", param);
        mModel.getParamsForLiGang(deviceSn, channelId, body).compose(RxHttpReponseCompat.<DeviceAlarmLiGangBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceAlarmLiGangBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull DeviceAlarmLiGangBean bean) {
                        if (hasView()) {
                            bean.setChannelid(channelId);
                            mView.getParamsForLiGangSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getParamsForLiGangError(e);
                        }
                    }
                });
    }


    //设置离岗检测参数
    public void setLiGangParams(String deviceSn, int channelId, HashMap<String, Object> body) {

        mModel.setLiGangParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setLiGangParamsSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setLiGangParamsError(e);
                        }
                    }
                });
    }

    //获取哭声检测参数
    public void getCryAlarmParam(String deviceSn, int channelId) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "intelligence_cry_detection_get_param");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        body.put("param", param);
        mModel.getCryAlarmParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.<DeviceAlarmCryBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceAlarmCryBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull DeviceAlarmCryBean bean) {
                        if (hasView()) {
                            bean.setChannelid(channelId);
                            mView.getCryAlarmParamsSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getCryAlarmParamsError(e);
                        }
                    }
                });
    }

    //设置哭声检测参数
    public void setCryAlarmParams(String deviceSn, int channelId, DeviceAlarmCryBean bean) {
        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "intelligence_cry_detection_set_param");
        body.put("level", "Operator");
        if (null != bean) {
            body.put("param", bean);
        }
        mModel.setCryAlarmParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setCryAlarmParamsSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setCryAlarmParamsError(e);
                        }
                    }
                });
    }

    //获取宠物检测参数
    public void getPetAlarmParam(String deviceSn, int channelId) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "smart_alarm_pet_detection_get_param");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("bdefault", false);
        body.put("param", param);
        mModel.getPetAlarmParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.<DeviceAlarmPetBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceAlarmPetBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull DeviceAlarmPetBean bean) {
                        if (hasView()) {
                            bean.setChannelid(channelId);
                            mView.getPetAlarmParamsSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getPetAlarmParamsError(e);
                        }
                    }
                });
    }

    //设置宠物检测参数
    public void setPetAlarmParams(String deviceSn, int channelId, DeviceAlarmPetBean bean) {
        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("method", "smart_alarm_pet_detection_set_param");
        body.put("level", "Operator");
        if (null != bean) {
            body.put("param", bean);
        }
        mModel.setPetAlarmParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setPetAlarmParamsSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setPetAlarmParamsError(e);
                        }
                    }
                });
    }

    //获取智能能力集，判断是否支持占道检测
    public void getIntelligenceAbility(String deviceSn, int channelId) {
        try {
            HashMap<String, Object> body = new HashMap<>();
            body.put("method", "intelligence_get_ability");
            HashMap<String, Object> param = new HashMap<>();
            param.put("channelid", channelId);
            body.put("param", param);
            mModel.getIntelligenceAbility(deviceSn, channelId, body).compose(RxHttpReponseCompat.<IntelligenceAbilityBean>compatResult())
                    .subscribe(new ProgressSubcriber<IntelligenceAbilityBean>(mContext, mView, false) {
                        @Override
                        public void onNext(@NonNull IntelligenceAbilityBean bean) {
                            if (hasView()) {
                                mView.getIntelligenceAbilitySuccess(bean);
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取智能分析能力
    public void getIvpSupport(String deviceSn, int channelId) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ivp_support_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        body.put("param", param);
        mModel.getIvpSupport(deviceSn, channelId, body).compose(RxHttpReponseCompat.<OctIvpBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctIvpBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull OctIvpBean.ResultBean bean) {
                        if (hasView()) {
                            mView.getIvpSupportSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getIvpSupportError(e);
                        }
                    }
                });
    }

    //获取布防计划参数
    public void getDefencePlan(String deviceSn, int channelId, int planId) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "alarm_defence_plan_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("plan_id", planId);
        param.put("bdefault", false);
        body.put("param", param);
        mModel.getDefencePlan(deviceSn, channelId, body).compose(RxHttpReponseCompat.<DefencePlanBean>compatResult())
                .subscribe(new ProgressSubcriber<DefencePlanBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull DefencePlanBean bean) {
                        if (hasView()) {
                            bean.setChannelid(channelId);
                            bean.setPlan_id(planId);
                            mView.getDefencePlanSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getDefencePlanError(e);
                        }
                    }
                });
    }

    //设置布防计划参数
    public void setDefencePlan(String deviceSn, int channelId, HashMap<String, Object> body) {

        mModel.setLiGangParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setDefencePlanSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setDefencePlanError(e);
                        }
                    }
                });
    }

    //老协议获取当前报警音
    public void getAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body) {

        mModel.getAlarmSound(deviceSn, channelId, body).compose(RxHttpReponseCompat.<AlarmSoundBean>compatResult())
                .subscribe(new ProgressSubcriber<AlarmSoundBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull AlarmSoundBean bean) {
                        if (hasView()) {
                            mView.getAlarmSoundSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getAlarmSoundError(e);
                        }
                    }
                });
    }


    //新协议获取当前报警音
    public void getAlarmSoundList(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.getAlarmSoundList(deviceSn, channelId, body).compose(RxHttpReponseCompat.<OctAlarmSoundListGetBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAlarmSoundListGetBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull OctAlarmSoundListGetBean.ResultBean bean) {
                        if (hasView()) {
                            mView.getAlarmSoundListSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getAlarmSoundListError(e);
                        }
                    }
                });
    }


    //新协议设备端播放报警音
    public void devicePlayAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.devicePlayAlarmSound(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.devicePlayAlarmSoundSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.devicePlayAlarmSoundError(e);
                        }
                    }
                });
    }


    //新协议添加新报警音
    public void addAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.addAlarmSound(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.addAlarmSoundSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.addAlarmSoundError(e);
                        }
                    }
                });
    }


    //新协议删除报警音
    public void deleteAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.deleteAlarmSound(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.deleteAlarmSoundSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.deleteAlarmSoundError(e);
                        }
                    }
                });
    }


    public void setAlarmSound(String deviceSn, int channelId, HashMap<String, Object> body) {

        mModel.setAlarmSound(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setAlarmSoundSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setAlarmSoundError(e);
                        }
                    }
                });
    }

    public void getAlarmSoundVolume(String deviceSn, int channelId, HashMap<String, Object> body) {

        mModel.getAlarmSoundVolume(deviceSn, channelId, body).compose(RxHttpReponseCompat.<AlarmSoundVolumeBean>compatResult())
                .subscribe(new ProgressSubcriber<AlarmSoundVolumeBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull AlarmSoundVolumeBean bean) {
                        if (hasView()) {
                            mView.getAlarmSoundVolumeSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getAlarmSoundVolumeError(e);
                        }
                    }
                });
    }

    public void setAlarmSoundVolume(String deviceSn, int channelId, HashMap<String, Object> body) {

        mModel.setAlarmSoundVolume(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setAlarmSoundVolumeSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setAlarmSoundVolumeError(e);
                        }
                    }
                });
    }


    //报警联动获取
    public void getAlarmLink(String deviceSn, int channelId, int alarmLinkId) {

        mModel.getAlarmLink(deviceSn, channelId, alarmLinkId).compose(RxHttpReponseCompat.<OctAlarmLinkGetBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAlarmLinkGetBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull OctAlarmLinkGetBean.ResultBean resultBean) {
                        if (hasView()) {
                            resultBean.setChannelid(channelId);
                            resultBean.setLink_id(alarmLinkId);
                            mView.getAlarmLinkSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getAlarmLinkError(e);
                        }
                    }
                });
    }

    //报警联动配置
    public void setAlarmLink(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setAlarmLink(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setAlarmLinkSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setAlarmLinkError(e);
                        }
                    }
                });
    }


    public void getHideAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        //获取遮挡报警參數

        mModel.getHideAlarmParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.<HideAlarmBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<HideAlarmBean.ResultBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull HideAlarmBean.ResultBean deviceAlarmBean) {
                        if (hasView()) {
                            mView.getHideAlarmParamsSuccess(deviceAlarmBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getHideAlarmParamsError(e);
                        }
                    }
                });


    }

    public void setHideAlarmParams(String deviceSn, int channelId, HashMap<String, Object> body) {

        mModel.setHideAlarmParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean deviceAlarmBean) {
                        if (hasView()) {
                            mView.setHideAlarmParamsSuccess(deviceAlarmBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setHideAlarmParamsError(e);
                        }
                    }
                });


    }

    public void getChannelDetail(String deviceNo, int channelId) {
        //获取通道对应的能力
        mModel.getChannelDetail(deviceNo, channelId).compose(RxHttpReponseCompat.<ChannelBean>compatResult())
                .subscribe(new ProgressSubcriber<ChannelBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull ChannelBean channelBean) {
                        if (hasView()) {
                            mView.getChannelDetailSuccess(channelBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getChannelDetailError(e);
                        }
                    }
                });

    }

    public void getDeviceAbility(String deviceNo) {


        //获取设备的能力集
        mModel.getDeviceAbility(deviceNo).compose(RxHttpReponseCompat.<DeviceBean>compatResult()
        ).subscribe(new ProgressSubcriber<DeviceBean>(mContext, mView) {

            @Override
            public void onNext(DeviceBean bean) {
                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getDeviceAbilitySuccess(bean);
                }
            }
        });


    }


    /**
     * 标定相关接口-1 获取标定状态
     *
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


    //获取虚焦检测的参数
    public void getParamsForVFS(String deviceSn, int channelId) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ivp_vf_get_param");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        body.put("param", param);
        mModel.getParamsForVFS(deviceSn, channelId, body).compose(RxHttpReponseCompat.<OctIvpVfBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctIvpVfBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull OctIvpVfBean.ResultBean bean) {
                        if (hasView()) {
                            bean.setChannelid(channelId);
                            mView.getParamsForVFSSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getParamsForVFSFailed(e);
                        }
                    }
                });
    }


    //设置虚焦检测的参数
    public void setParamsForVFS(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setParamsForVFS(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setParamsForVFSSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setParamsForVFSFailed(e);
                        }
                    }
                });


    }

    /**
     * 获取公有云设备日夜切换参数
     *
     * @param body
     */
    public void getDayNightParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.getDayNightParam(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctImageDncutParamBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull OctImageDncutParamBean.ResultBean octImageDncutParamBean) {
                        if (hasView()) {
                            mView.getDayNightParamSuccess(octImageDncutParamBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getDayNightParamError(e);
                        }
                    }
                });
    }

    //哭声宠物开启状态获取接口
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


    //车牌识别参数获取接口
    public void getParamLPRSystem(String deviceSn, int channelId) {
        mModel.getParamLPRSystem(deviceSn, channelId)
                .compose(RxHttpReponseCompat.<RDLPRSystemGetParam>compatResult())
                .subscribe(new ProgressSubcriber<RDLPRSystemGetParam>(mContext, mView, false) {
                    @Override
                    public void onNext(RDLPRSystemGetParam rdlprSystemGetParam) {
                        if (hasView()) {
                            mView.getParamLPRSystemSuccess(rdlprSystemGetParam);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getParamLPRSystemFailed(e);
                        }
                    }
                });
    }

    //车牌识别参数设置接口
    public void setParamLPRSystem(String deviceSn, int channelId, RDLPRSystemGetParam.ResultBean resultBean) {
        mModel.setParamLPRSystem(deviceSn, channelId, resultBean)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setParamLPRSystemSuccess(emptyBean);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setParamLPRSystemFailed(e);
                        }
                    }
                });
    }

    //动态智能算法设置报警提示音
    public void setSmartAppAlarmVoice(String deviceSn, int channelId, SmartAppAlarmVoiceBean.Param param) {
        mModel.setSmartAppAlarmVoice(deviceSn, channelId, param)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setSmartAppAlarmVoiceSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setSetSmartAppAlarmVoiceFailed(e);
                        }
                    }
                });
    }

    public void getSmartAppAlarmVoice(String deviceSn, int channelId, SmartAppAlarmVoiceBean.Param param) {
        mModel.getSmartAppAlarmVoice(deviceSn, channelId, param)
                .compose(RxHttpReponseCompat.<SmartAppAlarmVoiceResBean>compatResult())
                .subscribe(new ProgressSubcriber<SmartAppAlarmVoiceResBean>(mContext, mView, false) {
                    @Override
                    public void onNext(SmartAppAlarmVoiceResBean bean) {
                        if (hasView()) {
                            mView.getSmartAppAlarmVoiceSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getSetSmartAppAlarmVoiceFailed(e);
                        }
                    }
                });
    }

}
