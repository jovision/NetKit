package com.jovision.netkit.mvp.presenter;

import com.google.gson.Gson;
import com.jovision.netkit.mvp.data.bean.Device4GIccidBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.DeviceCloudStorageEnableBean;
import com.jovision.netkit.mvp.data.bean.PlayBackUrlForCloudBean;
import com.jovision.netkit.mvp.data.bean.PlayCallBackUrlBean;
import com.jovision.netkit.mvp.data.bean.PlayCallBackVideosBean;
import com.jovision.netkit.mvp.data.bean.PlayRecordDateBean;
import com.jovision.netkit.mvp.data.bean.PublicAlarmTypeBean;
import com.jovision.netkit.mvp.data.bean.response.ShareDetailBean;
import com.jovision.netkit.mvp.data.bean.response.StorageBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.RemotePlayBackContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/11/12
 * 描述：
 */
public class RemotePlayBackPresenter extends BasePresenter<RemotePlayBackContract.IRemotePlayBackModel, RemotePlayBackContract.View> {

    @Inject
    public RemotePlayBackPresenter(RemotePlayBackContract.IRemotePlayBackModel remotePlayBackModel, RemotePlayBackContract.View view) {
        super(remotePlayBackModel, view);
    }

    public void getPlayBackUrl(String deviceSn, int channelId, String startTime, String endTime) {

        mModel.getPlayBackUrl(deviceSn, channelId, startTime, endTime).compose(RxHttpReponseCompat.<PlayCallBackUrlBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayCallBackUrlBean>(mContext, mView) {
            @Override
            public void onNext(PlayCallBackUrlBean playCallBackUrlBean) {
                if (hasView()) {
                    mView.getPlayBackUrlSuccess(new Gson().toJson(playCallBackUrlBean),channelId);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (hasView()) {
                    mView.getPlayBackUrlError(e,channelId);
                }
            }
        });

    }


    //获取本地播放录像的下载地址，其实就是播放地址
    public void getLocalDownloadUrl(String deviceSn, int channelId, String startTime, String endTime) {

        mModel.getPlayBackUrl(deviceSn, channelId, startTime, endTime).compose(RxHttpReponseCompat.<PlayCallBackUrlBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayCallBackUrlBean>(mContext, mView, true) {
            @Override
            public void onNext(PlayCallBackUrlBean playCallBackUrlBean) {
                if (hasView()) {
                    mView.getLocalDownloadUrlSuccess(new Gson().toJson(playCallBackUrlBean),channelId, startTime, endTime);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (hasView()) {
                    mView.getLocalDownloadUrlError(e,channelId, startTime, endTime);
                }
            }
        });

    }


    public void getCloudDownloadUrl(String deviceSn, int channelId, String startTime, String endTime) {

        mModel.getPlayBackUrlForCloud(deviceSn, channelId, startTime, endTime).compose(RxHttpReponseCompat.<PlayBackUrlForCloudBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayBackUrlForCloudBean>(mContext, mView) {
            @Override
            public void onNext(PlayBackUrlForCloudBean urlForCloud) {
                if (hasView()) {
                    mView.getCloudDownloadUrlSuccess(urlForCloud.getUrl(), channelId, startTime, endTime);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getCloudDownloadUrlError(e, channelId, startTime, endTime);
                }
            }
        });

    }

    public void getPlayBackUrlForCloud(String deviceSn, int channelId, String startTime, String endTime) {

        mModel.getPlayBackUrlForCloud(deviceSn, channelId, startTime, endTime).compose(RxHttpReponseCompat.<PlayBackUrlForCloudBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayBackUrlForCloudBean>(mContext, mView) {
            @Override
            public void onNext(PlayBackUrlForCloudBean urlForCloud) {
                if (hasView()) {
                    mView.getPlayBackUrlForCLoudSuccess(urlForCloud,channelId);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getPlayBackUrlError(e,channelId);
                }
            }
        });

    }


    //    获取视频列表
    public void getVideoList(String url, String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime) {

        mModel.getVideoList(url, deviceSn, channelId, pageStart, pageSize, startTime, endTime).compose(RxHttpReponseCompat.<PlayCallBackVideosBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayCallBackVideosBean>(mContext, mView, true) {

            @Override
            public void onNext(PlayCallBackVideosBean bean) {
                if (hasView()) {
                    mView.getVideoListSuccess(bean,channelId);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);

                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getVideoListError(e,channelId);
                }

            }
        });

    }

    public void getVideoDateList(String deviceSn, int channelId, int year, int month) {

        mModel.getVideoDateList(deviceSn, channelId, year, month).compose(RxHttpReponseCompat.<PlayRecordDateBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayRecordDateBean>(mContext, mView, false) {

            @Override
            public void onNext(PlayRecordDateBean bean) {
                if (hasView()) {
                    mView.getVideoDateListSuccess(bean,channelId);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getVideoDateListError(e,channelId);
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

            @Override
            public void onError(Throwable e) {

                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getDeviceAbilityError(e);
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
            public void onError(Throwable throwable) {
                super.onError(throwable);
                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getDeviceCloudStorageEnableError(throwable);
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

    //获取设备的分享详情
    public void shareDetail(String shareNumber) {
        mModel.shareDetail(shareNumber).compose(RxHttpReponseCompat.<ShareDetailBean>compatResult())
                .subscribe(new ProgressSubcriber<ShareDetailBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull ShareDetailBean shareDetailBean) {
                        if (hasView()) {
                            mView.shareDetailSuccess(shareDetailBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.shareDetailError(e);
                        }

                    }
                });
    }


    // 轻智能回放接口1,查询当天录像类型：查询一段时间内本地录像类型/v1/udms/device/media/get_alarm_types
    public void getLocalAlarmTypes(String deviceSn, int channelId, String startTime, String endTime) {

        mModel.getLocalAlarmTypes(deviceSn, channelId, startTime, endTime).compose(RxHttpReponseCompat.<PublicAlarmTypeBean>compatResult()
        ).subscribe(new ProgressSubcriber<PublicAlarmTypeBean>(mContext, mView, true) {

            @Override
            public void onNext(PublicAlarmTypeBean bean) {
                if (hasView()) {
                    mView.getLocalAlarmTypesSuccess(bean);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);

                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getLocalAlarmTypesError(e);
                }

            }
        });

    }

    // 轻智能回放接口2：查询设备本地录像文件列表-可根据报警类型进行筛选/v1/udms/device/media/get_alarm_record_list
    public void getLocalAlarmRecordList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime, int mergeTimeEnable, String[] alarmTypes) {

        mModel.getLocalAlarmRecordList(deviceSn, channelId, pageStart, pageSize, startTime, endTime, mergeTimeEnable, alarmTypes).compose(RxHttpReponseCompat.<PlayCallBackVideosBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayCallBackVideosBean>(mContext, mView, true) {

            @Override
            public void onNext(PlayCallBackVideosBean bean) {
                if (hasView()) {
                    mView.getLocalAlarmRecordListSuccess(bean);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);

                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getLocalAlarmRecordListError(e);
                }

            }
        });

    }

    public void getLocalVideoDateList(String deviceSn, int channelId, int year, int month) {

        mModel.getLocalVideoDateList(deviceSn, channelId, year, month).compose(RxHttpReponseCompat.<PlayRecordDateBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayRecordDateBean>(mContext, mView, false) {

            @Override
            public void onNext(PlayRecordDateBean bean) {
                if (hasView()) {
                    mView.getVideoDateListSuccess(bean,channelId);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getVideoDateListError(e,channelId);
                }

            }
        });

    }

    public void getLocalVideoList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime) {

        mModel.getLocalVideoList(deviceSn, channelId, pageStart, pageSize, startTime, endTime).compose(RxHttpReponseCompat.<PlayCallBackVideosBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayCallBackVideosBean>(mContext, mView, true) {

            @Override
            public void onNext(PlayCallBackVideosBean bean) {
                if (hasView()) {
                    mView.getVideoListSuccess(bean,channelId);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);

                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getVideoListError(e,channelId);
                }

            }
        });

    }

    // 轻智能回放接口3,查询当天录像类型：查询云端录像类型/v1/udms/device/cloudstorage/get_alarm_types
    public void getCloudAlarmTypes(String deviceSn, int channelId, String startTime, String endTime) {

        mModel.getCloudAlarmTypes(deviceSn, channelId, startTime, endTime).compose(RxHttpReponseCompat.<PublicAlarmTypeBean>compatResult()
        ).subscribe(new ProgressSubcriber<PublicAlarmTypeBean>(mContext, mView, true) {

            @Override
            public void onNext(PublicAlarmTypeBean bean) {
                if (hasView()) {
                    mView.getCloudAlarmTypesSuccess(bean);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);

                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getCloudAlarmTypesError(e);
                }

            }
        });

    }


    // 轻智能回放接口4：查询云端录像文件列表-可根据报警类型进行筛选/v1/udms/device/cloudstorage/get_alarm_record_list
    public void getCloudAlarmRecordList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime, String[] alarmTypes) {

        mModel.getCloudAlarmRecordList(deviceSn, channelId, pageStart, pageSize, startTime, endTime, alarmTypes).compose(RxHttpReponseCompat.<PlayCallBackVideosBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayCallBackVideosBean>(mContext, mView, true) {

            @Override
            public void onNext(PlayCallBackVideosBean bean) {
                if (hasView()) {
                    mView.getCloudAlarmRecordListSuccess(bean);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);

                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getCloudAlarmRecordListError(e);
                }

            }
        });

    }


    public void getCloudVideoDateList(String deviceSn, int channelId, int year, int month) {

        mModel.getCloudVideoDateList(deviceSn, channelId, year, month).compose(RxHttpReponseCompat.<PlayRecordDateBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayRecordDateBean>(mContext, mView, false) {

            @Override
            public void onNext(PlayRecordDateBean bean) {
                if (hasView()) {
                    mView.getVideoDateListSuccess(bean, channelId);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getVideoDateListError(e, channelId);
                }

            }
        });
    }

    public void getCloudVideoList(String deviceSn, int channelId, int pageStart, int pageSize, String startTime, String endTime) {

        mModel.getCloudVideoList(deviceSn, channelId, pageStart, pageSize, startTime, endTime).compose(RxHttpReponseCompat.<PlayCallBackVideosBean>compatResult()
        ).subscribe(new ProgressSubcriber<PlayCallBackVideosBean>(mContext, mView, true) {

            @Override
            public void onNext(PlayCallBackVideosBean bean) {
                if (hasView()) {
                    mView.getVideoListSuccess(bean,channelId);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);

                if (hasView()) {
                    if (isShowProgress()) {
                        mView.dismissLoading();
                    }
                    mView.getVideoListError(e,channelId);
                }

            }
        });

    }



    //查询4G卡厂商 -2023.7.20
    public void get4GDeviceIccid(String deviceSn,String iccid){
        mModel.get4GDeviceIccid(deviceSn).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<Device4GIccidBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull Device4GIccidBean device4GIccidBean) {
                        if (hasView()){
                            mView.get4GDeviceIccidSuccess(device4GIccidBean,iccid);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.get4GDeviceIccidError(e,iccid);
                        }
                    }
                });
    }
}
