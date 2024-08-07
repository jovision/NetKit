package com.jovision.netkit.mvp.presenter;

import com.jovision.basekit.LogUtil;
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
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.SceneListContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class SceneListPresenter extends BasePresenter<SceneListContract.ISceneListModel, SceneListContract.View>{
    @Inject
    public SceneListPresenter(SceneListContract.ISceneListModel iSceneListModel, SceneListContract.View view) {
        super(iSceneListModel, view);
    }
    public void requestSceneList(){
        mModel.sceneList().compose(RxHttpReponseCompat.<List<SceneInfoBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<SceneInfoBean>>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull List<SceneInfoBean> sceneInfoBeans) {
                        if (hasView()){
                            mView.sceneListSuccess(sceneInfoBeans);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.sceneListError(e);
                        }
                    }
                });
    }

    public void requestDeviceList(){

        mModel.deviceList().compose(RxHttpReponseCompat.<DeviceListResponseBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceListResponseBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull DeviceListResponseBean deviceListResponseBean) {
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.deviceListSuccess(deviceListResponseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.deviceListError(e);
                        }
                    }
                });
    }

    public void requestDeviceDetail(String deviceSn){
        mModel.getDeviceDetail(deviceSn).compose(RxHttpReponseCompat.<DeviceBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull DeviceBean deviceBean) {
                        if (hasView()){
                            mView.deviceDetailSuccess(deviceBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.deviceDetailError(e);
                        }
                    }
                });
    }
    public void createScene(CreateSceneRequestBean createSceneRequestBean){
        mModel.createScene(createSceneRequestBean).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean deviceBean) {
                        if (hasView()){
                            mView.createSceneSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.createSceneError(e);
                        }
                    }
                });
    }
    public void orderScene(OrderScenesRequestBean orderScenesRequestBean){
        mModel.orderScene(orderScenesRequestBean).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean deviceBean) {
                        if (hasView()){
                            mView.orderSceneSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.orderSceneError(e);
                        }
                    }
                });
    }
    public void deleteScene(String sceneId){
        mModel.deleteScene(sceneId).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean deviceBean) {
                        if (hasView()){
                            mView.deleteSceneSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.deleteSceneError(e);
                        }
                    }
                });
    }
    public void sceneChannels(String sceneId){
        mModel.sceneChannels(sceneId).compose(RxHttpReponseCompat.<DeviceListResponseBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceListResponseBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull DeviceListResponseBean sceneChannelsBean) {
                        if (hasView()){
                            mView.sceneChannelsSuccess(sceneChannelsBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.sceneChannelsError(e);
                        }
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
    //copy Sharelistpresenter
    public void shareToMe(String deviceSn){//,String channelId
        LogUtil.e("shareToMe-tiaoshi","2-SceneListPresenter:shareToMe-enter");
        mModel.shareToMe(deviceSn).compose(RxHttpReponseCompat.<List<ShareToMeBean>>compatResult())
                .subscribe(new ProgressSubcriber<List<ShareToMeBean>>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull List<ShareToMeBean> shareToMeBeanList) {
                        LogUtil.e("shareToMe-tiaoshi","2-SceneListPresenter:shareToMe-success");
                        if (hasView()){
                            mView.shareToMeSuccess(shareToMeBeanList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("shareToMe-tiaoshi","2-SceneListPresenter:shareToMe-failed");
                        super.onError(e);
                        if (hasView()){
                            mView.shareToMeError(e);
                        }
                    }
                });
    }
    //copy Sharelistpresenter
    public void updateShareStatus(String shareNumber, String shareStatus){
        mModel.updateShareStatus(shareNumber, shareStatus).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.updateShareStatusSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.updateShareStatusError(e);
                        }
                    }
                });
    }
    //copy DeviceSettingPresenter
    public void getHideStatus(String deviceSn,int channelId){
        mModel.getHideStatus(deviceSn,channelId).compose(RxHttpReponseCompat.<EnableBean>compatResult())
                .subscribe(new ProgressSubcriber<EnableBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EnableBean enableBean) {
                        if (hasView()){
                            mView.getHideStatusSuccess(deviceSn,channelId,enableBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.getHideStatusError(e);
                        }
                    }
                });

    }
    //copy DeviceSettingPresenter
    public void setHideStatus(String deviceSn,int channelId,boolean enable){
        mModel.setHideStatus(deviceSn,channelId,enable).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.setHideStatusSuccess(enable);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()){
                                mView.dismissLoading();
                            }
                            mView.setHideStatusError(e);
                        }
                    }
                });
    }

    public void getChannelBadges(String deviceSn,int channelId){
        mModel.getChannelBadges(deviceSn, channelId).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<ChannelBadgesBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull ChannelBadgesBean channelBadgesBean) {
                        if (hasView()){
                            mView.getChannelBadgesSuccess(channelBadgesBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getChannelBadgesError(e);
                        }
                    }
                });
    }

    public void getCalendarMark(String deviceSn, String alarmCategories,String yearMonth){
        mModel.getCalendarMark(deviceSn, alarmCategories, yearMonth).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<PlayRecordDateBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull PlayRecordDateBean playRecordDateBean) {
                        if (hasView()){
                            mView.getCalendarMarkSuccess(playRecordDateBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);

                    }
                });
    }


    //查询4G卡厂商 -2023.7.20
    public void get4GDeviceIccid(String deviceSn,String iccId){
        mModel.get4GDeviceIccid(deviceSn).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<Device4GIccidBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull Device4GIccidBean device4GIccidBean) {
                        if (hasView()){
                            mView.get4GDeviceIccidSuccess(device4GIccidBean,iccId);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.get4GDeviceIccidError(e,iccId);
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
    //copy DeviceSettingPresenter
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
}
