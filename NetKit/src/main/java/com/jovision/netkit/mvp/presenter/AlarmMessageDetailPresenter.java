package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.DeviceCloudStorageEnableBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.MessageAlarmListBean;
import com.jovision.netkit.mvp.data.bean.MessageAlarmListDetailBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForCloudBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForGunBallCloudBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForGunBallLocalBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForLocalBean;
import com.jovision.netkit.mvp.data.bean.PlayRecordDateBean;
import com.jovision.netkit.mvp.data.bean.request.AlarmMessageRequestBean;
import com.jovision.netkit.mvp.data.bean.response.StorageBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.AlarmMessageDetailContract;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/12/9
 * 描述：
 */
public class AlarmMessageDetailPresenter extends
        BasePresenter<AlarmMessageDetailContract.IAlarmMessageDetailModel,
                AlarmMessageDetailContract.View> {


    @Inject
    public AlarmMessageDetailPresenter(AlarmMessageDetailContract.IAlarmMessageDetailModel model, AlarmMessageDetailContract.View view) {
        super(model, view);
    }


    public void getAlarmMsgList(AlarmMessageRequestBean bean) {

        mModel.getAlarmMsgList(bean).compose(RxHttpReponseCompat.<MessageAlarmListBean>compatResult())
                .subscribe(new ProgressSubcriber<MessageAlarmListBean>(mContext, mView, true) {
                    @Override
                    public void onNext(MessageAlarmListBean bean) {
                        if (hasView()) {
                            mView.getAlarmMsgListSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getAlarmMsgListError(e);
                        }
                    }
                });
    }

    public void getCalendarMark(String deviceSn, String alarmCategorie,String yearMonth) {
        //获取日历掩码
        mModel.getCalendarMark(deviceSn, alarmCategorie,yearMonth).compose(RxHttpReponseCompat.<PlayRecordDateBean>compatResult())
                .subscribe(new ProgressSubcriber<PlayRecordDateBean>(mContext, mView) {
                    @Override
                    public void onNext(PlayRecordDateBean bean) {
                        if (hasView()) {
                            mView.getCalendarMarkSuccess(bean);
                        }
                    }
                });

    }

    public void getCloudPlayUrl(String deviceSn, int channelId, String videoId) {
        //获取云端播放Url
        mModel.getCloudPlayUrl(deviceSn, channelId, videoId).compose(RxHttpReponseCompat.<PlayBackUrlForCloudBean>compatResult())
                .subscribe(new ProgressSubcriber<PlayBackUrlForCloudBean>(mContext, mView) {
                    @Override
                    public void onNext(PlayBackUrlForCloudBean bean) {
                        if (hasView()) {
                            mView.getCloudPlayUrlSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getCloudPlayUrlError(e);
                        }
                    }
                });

    }

    public void alarmMsgClean(List<String> alarmCategories, List<Integer> msgIdList, String deviceSn) {
        mModel.alarmMsgClean(alarmCategories, msgIdList, deviceSn).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.alarmMsgCleanSuccess();
                        }
                    }
                });
    }

    public void getDeviceCloudStorageEnable(String deviceNo, int channelId) {
        //判断设备是否开启云存储
        mModel.getDeviceCloudStorageEnable(deviceNo, channelId).compose(RxHttpReponseCompat.<DeviceCloudStorageEnableBean>compatResult()
        ).subscribe(new ProgressSubcriber<DeviceCloudStorageEnableBean>(mContext, mView) {

            @Override
            public void onNext(DeviceCloudStorageEnableBean bean) {
                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getDeviceCloudStorageEnableSuccess(bean);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getDeviceCloudStorageEnableError(e);
                }
            }
        });

    }

    public void getLocalPlayUrl(String deviceSn, int channelId, String videoId) {


        //获取本地播放Url
        mModel.getLocalPlayUrl(deviceSn, channelId, videoId).compose(RxHttpReponseCompat.<PlayBackUrlForLocalBean>compatResult())
                .subscribe(new ProgressSubcriber<PlayBackUrlForLocalBean>(mContext, mView) {
                    @Override
                    public void onNext(PlayBackUrlForLocalBean bean) {
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getLocalPlayUrlSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getLocalPlayUrlError(e);
                        }
                    }
                });
    }




    public void getGunBallLocalPlayUrl(String deviceSn, int channelId, String videoId) {


        //获取枪和球本地播放Url
        mModel.getGunBallLocalPlayUrl(deviceSn, channelId, videoId).compose(RxHttpReponseCompat.<PlayBackUrlForGunBallLocalBean>compatResult())
                .subscribe(new ProgressSubcriber<PlayBackUrlForGunBallLocalBean>(mContext, mView) {
                    @Override
                    public void onNext(PlayBackUrlForGunBallLocalBean bean) {
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getGunBallLocalPlayUrlSuccess(bean,channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getGunBallLocalPlayUrlError(e,channelId);
                        }
                    }
                });
    }


    public void getGunBallCloudPlayUrl(String deviceSn, int channelId, String videoId) {


        //获取枪和球云存播放Url
        mModel.getGunBallCloudPlayUrl(deviceSn, channelId, videoId).compose(RxHttpReponseCompat.<PlayBackUrlForGunBallCloudBean>compatResult())
                .subscribe(new ProgressSubcriber<PlayBackUrlForGunBallCloudBean>(mContext, mView) {
                    @Override
                    public void onNext(PlayBackUrlForGunBallCloudBean bean) {
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getGunBallCloudPlayUrlSuccess(bean,channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getGunBallCloudPlayUrlError(e,channelId);
                        }
                    }
                });
    }


    public void getGunBallLocalDownloadUrl(String deviceSn, int channelId, String videoId) {


        //获取枪和球本地播放Url
        mModel.getGunBallLocalPlayUrl(deviceSn, channelId, videoId).compose(RxHttpReponseCompat.<PlayBackUrlForGunBallLocalBean>compatResult())
                .subscribe(new ProgressSubcriber<PlayBackUrlForGunBallLocalBean>(mContext, mView) {
                    @Override
                    public void onNext(PlayBackUrlForGunBallLocalBean bean) {
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getGunBallLocalDownloadUrlSuccess(bean,channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getGunBallLocalDownloadUrlError(e,channelId);
                        }
                    }
                });
    }


    public void getGunBallCloudDownloadUrl(String deviceSn, int channelId, String videoId) {


        //获取枪和球云存播放Url
        mModel.getGunBallCloudPlayUrl(deviceSn, channelId, videoId).compose(RxHttpReponseCompat.<PlayBackUrlForGunBallCloudBean>compatResult())
                .subscribe(new ProgressSubcriber<PlayBackUrlForGunBallCloudBean>(mContext, mView) {
                    @Override
                    public void onNext(PlayBackUrlForGunBallCloudBean bean) {
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getGunBallCloudDownloadUrlSuccess(bean,channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getGunBallCloudDownloadUrlError(e,channelId);
                        }
                    }
                });
    }

    //设备是否插入sd卡
    public void getStorage(String deviceSn) {
        mModel.getStorage(deviceSn).compose(RxHttpReponseCompat.<List<StorageBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<StorageBean>>(mContext, mView, true) {
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

    //消息已读接口
    public void alarmMsgRead(List<String> alarmCategories, List<Integer> msgIdList) {
        mModel.alarmMsgRead(alarmCategories, msgIdList).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            //只要调取这个接口，就要更新首页的消息未读红点逻辑
//                            EventBus.getDefault().post(new MessageReadStateUpdateEvent());
                            mView.alarmMsgReadSuccess();
                        }
                    }
                });
    }

    public void getAlarmInfo(String alarmUuid) {

        mModel.getAlarmInfo(alarmUuid).compose(RxHttpReponseCompat.<MessageAlarmListDetailBean>compatResult())
                .subscribe(new ProgressSubcriber<MessageAlarmListDetailBean>(mContext, mView) {
                    @Override
                    public void onNext(MessageAlarmListDetailBean bean) {
                        if (hasView()) {
                            mView.getAlarmInfoSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getAlarmInfoError(e);
                        }
                    }
                });


    }
}
