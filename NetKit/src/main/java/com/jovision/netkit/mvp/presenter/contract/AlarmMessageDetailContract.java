package com.jovision.netkit.mvp.presenter.contract;


import com.jovision.netkit.mvp.data.bean.BaseBean;
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
import com.jovision.uikit.BaseView;

import java.util.List;
import java.util.function.DoubleUnaryOperator;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/12/9
 * 描述：
 */
public interface AlarmMessageDetailContract {


    interface IAlarmMessageDetailModel {

        Observable<BaseBean<MessageAlarmListBean>> getAlarmMsgList(AlarmMessageRequestBean bean);

        Observable<BaseBean<PlayRecordDateBean>> getCalendarMark(String deviceSn, String alarmCategories, String yearMonth);

        Observable<BaseBean<PlayBackUrlForCloudBean>> getCloudPlayUrl(String deviceSn, int channelId, String videoId);

        Observable<BaseBean<EmptyBean>> alarmMsgClean(List<String> alarmCategories, List<Integer> msgIdList, String deviceSn);

        Observable<BaseBean<DeviceCloudStorageEnableBean>> getDeviceCloudStorageEnable(String deviceNo, int channelId);

        Observable<BaseBean<PlayBackUrlForLocalBean>> getLocalPlayUrl(String deviceSn, int channelId, String videoId);

        Observable<BaseBean<PlayBackUrlForGunBallLocalBean>> getGunBallLocalPlayUrl(String deviceSn, int channelId, String videoId);
        Observable<BaseBean<PlayBackUrlForGunBallCloudBean>> getGunBallCloudPlayUrl(String deviceSn, int channelId, String videoId);


        Observable<BaseBean<List<StorageBean>>> getStorage(String deviceSn);

        Observable<BaseBean<EmptyBean>> alarmMsgRead(List<String> alarmCategories, List<Integer> msgIdList);

        Observable<BaseBean<MessageAlarmListDetailBean>> getAlarmInfo(String alarmUuid);
    }

    interface View extends BaseView {

        void getAlarmMsgListSuccess(MessageAlarmListBean bean);
        void getAlarmMsgListError(Throwable throwable);
        void getCalendarMarkSuccess(PlayRecordDateBean bean);
        void getCloudPlayUrlSuccess(PlayBackUrlForCloudBean bean);
        void alarmMsgCleanSuccess();
        void getDeviceCloudStorageEnableSuccess(DeviceCloudStorageEnableBean bean);
        void getDeviceCloudStorageEnableError(Throwable throwable);

        void getLocalPlayUrlSuccess(PlayBackUrlForLocalBean bean);
        void getLocalPlayUrlError(Throwable throwable);



        void getGunBallLocalPlayUrlSuccess(PlayBackUrlForGunBallLocalBean bean, int channelId);
        void getGunBallLocalPlayUrlError(Throwable throwable, int channelId);


        void getGunBallCloudPlayUrlSuccess(PlayBackUrlForGunBallCloudBean bean, int channelId);
        void getGunBallCloudPlayUrlError(Throwable throwable, int channelId);

        void getGunBallLocalDownloadUrlSuccess(PlayBackUrlForGunBallLocalBean bean, int channelId);
        void getGunBallLocalDownloadUrlError(Throwable throwable, int channelId);


        void getGunBallCloudDownloadUrlSuccess(PlayBackUrlForGunBallCloudBean bean, int channelId);
        void getGunBallCloudDownloadUrlError(Throwable throwable, int channelId);




        void getCloudPlayUrlError(Throwable throwable);

        void getStorageSuccess(List<StorageBean> storageBeans);
        void getStorageError(Throwable e);

        void alarmMsgReadSuccess();

        void getAlarmInfoSuccess(MessageAlarmListDetailBean bean);
        void getAlarmInfoError(Throwable e);

    }

}
