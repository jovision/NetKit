package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.Device4GIccidBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.DeviceListResponseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.PlayRecordDateBean;
import com.jovision.netkit.mvp.data.bean.SceneInfoBean;
import com.jovision.netkit.mvp.data.bean.request.CreateSceneRequestBean;
import com.jovision.netkit.mvp.data.bean.request.OrderScenesRequestBean;
import com.jovision.netkit.mvp.data.bean.request.UpdateSceneRequestBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmStatusBean;
import com.jovision.netkit.mvp.data.bean.response.ChannelBadgesBean;
import com.jovision.netkit.mvp.data.bean.response.EnableBean;
import com.jovision.netkit.mvp.data.bean.response.ShareToMeBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface SceneListContract {

    interface ISceneListModel{
        Observable<BaseBean<List<SceneInfoBean>>> sceneList();
        Observable<BaseBean<DeviceListResponseBean>> deviceList();
        Observable<BaseBean<DeviceBean>> getDeviceDetail(String deviceSn);
        Observable<BaseBean<EmptyBean>> createScene(CreateSceneRequestBean createSceneRequestBean);
        Observable<BaseBean<EmptyBean>> orderScene(OrderScenesRequestBean orderScenesRequestBean);
        Observable<BaseBean<EmptyBean>> deleteScene(String sceneId);
        Observable<BaseBean<DeviceListResponseBean>> sceneChannels(String sceneId);
        Observable<BaseBean<EmptyBean>> updateScene(UpdateSceneRequestBean updateSceneRequestBean);
        //共享给我的
        Observable<BaseBean<List<ShareToMeBean>>> shareToMe(String deviceSn);//, String channelId
        //修改共享状态
        Observable<BaseBean<EmptyBean>> updateShareStatus(String shareNumber,String shareStatus);

        Observable<BaseBean<EnableBean>> getHideStatus(String deviceSn, int channelId);
        Observable<BaseBean<EmptyBean>> setHideStatus(String deviceSn,int channelId,boolean enable);
        //获取设备未读消息
        Observable<BaseBean<ChannelBadgesBean>> getChannelBadges(String deviceSn, int channelId);

        //获取报警消息日历掩码
        Observable<BaseBean<PlayRecordDateBean>> getCalendarMark(String deviceSn, String alarmCategories, String yearMonth);


        //查询4G卡厂商 -2023.7.20
        Observable<BaseBean<Device4GIccidBean>> get4GDeviceIccid(String deviceSn);


        Observable<BaseBean<AlarmStatusBean>> getAlarmStatus(String deviceSn, int channelId);
        Observable<BaseBean<EmptyBean>> cancelAlarmStatus(String deviceSn, int channelId);
    }
    interface View extends BaseView {
        void sceneListSuccess(List<SceneInfoBean> sceneInfoBeanList);
        void sceneListError(Throwable e);
        void deviceListSuccess(DeviceListResponseBean deviceListResponseBean);
        void deviceListError(Throwable e);
        void deviceDetailSuccess(DeviceBean deviceBean);
        void deviceDetailError(Throwable e);
        void createSceneSuccess();
        void createSceneError(Throwable e);
        void orderSceneSuccess();
        void orderSceneError(Throwable e);
        void deleteSceneSuccess();
        void deleteSceneError(Throwable e);
        void sceneChannelsSuccess(DeviceListResponseBean sceneChannelsBean);
        void sceneChannelsError(Throwable e);
        void updateSceneSuccess();
        void updateSceneError(Throwable e);
        void shareToMeSuccess(List<ShareToMeBean> shareToMeBeanList);
        void shareToMeError(Throwable e);
        void updateShareStatusSuccess();
        void updateShareStatusError(Throwable e);

        void getHideStatusSuccess(String deviceSn,int channelId,EnableBean enableBean);
        void getHideStatusError(Throwable e);
        void setHideStatusSuccess(boolean enable);
        void setHideStatusError(Throwable e);

        void getChannelBadgesSuccess(ChannelBadgesBean channelBadgesBean);
        void getChannelBadgesError(Throwable e);

        void getCalendarMarkSuccess(PlayRecordDateBean bean);

        void get4GDeviceIccidSuccess(Device4GIccidBean device4GIccidBean,String iccId);
        void get4GDeviceIccidError(Throwable e,String iccId);

        void getAlarmStatusSuccess(String deviceSn, int channelId, AlarmStatusBean enableBean);
        void getAlarmStatusError(Throwable e);
        void cancelAlarmStatusSuccess();
        void cancelAlarmStatusError(Throwable e);
    }
}
