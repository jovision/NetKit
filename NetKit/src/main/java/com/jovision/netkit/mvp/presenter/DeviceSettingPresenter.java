package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.GetScreenOverTurnBean;
import com.jovision.netkit.mvp.data.bean.ChannelBean;
import com.jovision.netkit.mvp.data.bean.Device4GIccidBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.DeviceConnectNetBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.FormatProgressBean;
import com.jovision.netkit.mvp.data.bean.request.DeleteDevicesBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmLinkIdBean;
import com.jovision.netkit.mvp.data.bean.response.AlarmSoundPlanBean;
import com.jovision.netkit.mvp.data.bean.response.DevGetLowPowerBean;
import com.jovision.netkit.mvp.data.bean.response.DeviceHourlyChimeBean;
import com.jovision.netkit.mvp.data.bean.response.EnableBean;
import com.jovision.netkit.mvp.data.bean.response.GtrackGetCalibrationBean;
import com.jovision.netkit.mvp.data.bean.response.IndicatorLedBean;
import com.jovision.netkit.mvp.data.bean.response.IntelligenceWaveHandCallParam;
import com.jovision.netkit.mvp.data.bean.response.OctAlarmSoundListGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctChannelAbilityBean;
import com.jovision.netkit.mvp.data.bean.response.OctDevInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageAbilityGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctImageDncutParamBean;
import com.jovision.netkit.mvp.data.bean.response.OctRecordGetInfoBean;
import com.jovision.netkit.mvp.data.bean.response.OctStreamGetAllAbility;
import com.jovision.netkit.mvp.data.bean.response.OctStreamGetParams;
import com.jovision.netkit.mvp.data.bean.response.OctWifiListAp;
import com.jovision.netkit.mvp.data.bean.response.OnvifGetDiscoveryInfo;
import com.jovision.netkit.mvp.data.bean.response.SimCardListBean;
import com.jovision.netkit.mvp.data.bean.response.SnapShotBean;
import com.jovision.netkit.mvp.data.bean.response.StorageBean;
import com.jovision.netkit.mvp.data.bean.response.UpgradeProgressBean;
import com.jovision.netkit.mvp.data.bean.response.VersionBean;
import com.jovision.netkit.mvp.data.http.PlayUrlBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.DeviceSettingContract;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class DeviceSettingPresenter extends BasePresenter<DeviceSettingContract.IDeviceSettingModel, DeviceSettingContract.View> {

    @Inject
    public DeviceSettingPresenter(DeviceSettingContract.IDeviceSettingModel iDeviceSettingModel, DeviceSettingContract.View view) {
        super(iDeviceSettingModel, view);
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
     * 获取公有云设备当前的信息-jy
     * @param body
     */
    public void getDeviceInfo(String deviceSn, int channelId, HashMap<String, Object> body){
        mModel.getDeviceInfo(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctDevInfoBean.ResultBean>(mContext,mView,false) {
                    @Override
                    public void onNext(@NonNull OctDevInfoBean.ResultBean octDevInfoBean) {
                        if (hasView()){
                            mView.getDeviceInfoSuccess(octDevInfoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getDeviceInfoError(e);
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
                            mView.getChannelsFeaturesSuccess(resultBean,deviceSn, channelId);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getChannelsFeaturesError(e,deviceSn, channelId);
                        }
                    }
                });
    }


    public void getHideStatus(String deviceSn, int channelId) {
        mModel.getHideStatus(deviceSn, channelId).compose(RxHttpReponseCompat.<EnableBean>compatResult())
                .subscribe(new ProgressSubcriber<EnableBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EnableBean enableBean) {
                        if (hasView()) {
                            mView.getHideStatusSuccess(enableBean);
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

    public void setHideStatus(String deviceSn, int channelId, boolean enable) {
        mModel.setHideStatus(deviceSn, channelId, enable).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setHideStatusSuccess();
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

    public void deviceDetail(String deviceSn,int channelId) {
        mModel.deviceDetail(deviceSn,channelId).compose(RxHttpReponseCompat.<DeviceBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceBean>(mContext, mView, false) {
                    @Override
                    public void onNext(@NonNull DeviceBean deviceBean) {
                        if (hasView()) {
                            mView.deviceDetailSuccess(deviceBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.deviceDetailError(e);
                        }
                    }
                });
    }

    public void snapshot(String deviceSn, int channelId) {
        mView.showLoading();
        mModel.snapshot(deviceSn, channelId).compose(RxHttpReponseCompat.<SnapShotBean>compatResult())
                .subscribe(new ProgressSubcriber<SnapShotBean>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull SnapShotBean snapShotBean) {
                        if (hasView()) {
                            mView.snapshotSuccess(snapShotBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.snapshotError(e);
                        }
                    }
                });
    }

    public void getRecordMode(String deviceSn, int channelId) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "record_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        body.put("param", param);
        mModel.getRecordMode(deviceSn, channelId, body).compose(RxHttpReponseCompat.<OctRecordGetInfoBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctRecordGetInfoBean.ResultBean>(mContext, mView,true) {
                    @Override
                    public void onNext(@NonNull OctRecordGetInfoBean.ResultBean recordModeBean) {
                        if (hasView()) {
                            mView.getRecordModeSuccess(recordModeBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getRecordModeError(e);
                        }
                    }
                });
    }

    public void setRecordMode(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setRecordMode(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setRecordModeSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setRecordModeError(e);
                        }
                    }
                });
    }


    public void editDeviceName(String deviceSn, String deviceName,String accessProtocol) {
        mModel.editDeviceName(deviceSn, deviceName,accessProtocol).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.editDeviceNameSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.editDeviceNameError(e);
                        }
                    }
                });
    }



    public void editDeviceChannelName(String deviceSn, int channelId,String channelName) {
        mModel.editDeviceChannelName(deviceSn, channelId,channelName).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.editDeviceChannelNameSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.editDeviceChannelNameError(e);
                        }
                    }
                });
    }


    public void getEncryptStatus(String deviceSn) {
        mModel.getEncryptStatus(deviceSn).compose(RxHttpReponseCompat.<EnableBean>compatResult())
                .subscribe(new ProgressSubcriber<EnableBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EnableBean enableBean) {
                        if (hasView()) {
                            mView.getEncryptStatusSuccess(enableBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getEncryptStatusError(e);
                        }
                    }
                });
    }

    public void setEncryptStatus(String deviceSn, boolean enable) {
        mModel.setEncryptStatus(deviceSn, enable).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setEncryptStatusSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setEncryptStatusError(e);
                        }
                    }
                });
    }

    public void getAudioStatus(String deviceSn, int channelId) {
        mModel.getAudioStatus(deviceSn, channelId).compose(RxHttpReponseCompat.<EnableBean>compatResult())
                .subscribe(new ProgressSubcriber<EnableBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EnableBean enableBean) {
                        if (hasView()) {
                            mView.getAudioStatusSuccess(enableBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getAudioStatusError(e);
                        }
                    }
                });
    }

    public void setAudioStatus(String deviceSn, int channelId, boolean enable) {
        mModel.setAudioStatus(deviceSn, channelId, enable).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setAudioStatusSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setAudioStatusError(e);
                        }
                    }
                });
    }

    public void getLEDStatus(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.getLEDStatus(deviceSn, channelId, body).compose(RxHttpReponseCompat.<IndicatorLedBean>compatResult())
                .subscribe(new ProgressSubcriber<IndicatorLedBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull IndicatorLedBean indicatorLedBean) {
                        if (hasView()) {
                            mView.getLEDStatusSuccess(indicatorLedBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getLEDStatusError(e);
                        }
                    }
                });
    }

    public void setLEDStatus(String deviceSn, int status) {
        mModel.setLEDStatus(deviceSn, status).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setLEDStatusSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setLEDStatusError(e);
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

    public void setDefaultFactory(String deviceSn, int channelId, boolean isSimple) {
        mModel.setDefaultFactory(deviceSn, channelId, isSimple).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setDefaultFactorySuccess(isSimple);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setDefaultFactoryError(e);
                        }
                    }
                });
    }

    public void rebootDevice(String deviceSn,int channelId) {
        mModel.rebootDevice(deviceSn,channelId).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.rebootDeviceSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.rebootDeviceError(e);
                        }
                    }
                });
    }

    public void rebootChannelDevice(String deviceSn, int channelId, HashMap<String, Object> body){
        mModel.rebootChannelDevice(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.rebootChannelDeviceSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.rebootChannelDeviceError(e);
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

    public void getVersion(String deviceSn) {
        mModel.getVersion(deviceSn).compose(RxHttpReponseCompat.<VersionBean>compatResult())
                .subscribe(new ProgressSubcriber<VersionBean>(mContext, mView,true) {
                    @Override
                    public void onNext(@NonNull VersionBean versionBean) {
                        if (hasView()) {
                            mView.getVersionSuccess(versionBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getVersionError(e);
                        }
                    }
                });
    }

    public void upgradeVersion(String deviceSn) {
        mModel.upgradeVersion(deviceSn).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.upgradeVersionSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.upgradeVersionError(e);
                        }
                    }
                });
    }

    public void getUpgradeStatus(String deviceSn) {
        mModel.getUpgradeStatus(deviceSn).compose(RxHttpReponseCompat.<UpgradeProgressBean>compatResult())
                .subscribe(new ProgressSubcriber<UpgradeProgressBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull UpgradeProgressBean upgradeProgressBean) {
                        if (hasView()) {
                            mView.getUpgradeStatusSuccess(upgradeProgressBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getUpgradeStatusError(e);
                        }
                    }
                });
    }

    public void updateShareStatus(String shareNumber, String shareStatus) {
        mModel.updateShareStatus(shareNumber, shareStatus).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.updateShareStatusSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.updateShareStatusError(e);
                        }
                    }
                });
    }

    public void getScreenOverturn(String deviceSn, int channelId){
        mModel.getScreenOverturn(deviceSn,channelId).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<GetScreenOverTurnBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull GetScreenOverTurnBean getScreenOverTurnBean) {
                        if (hasView()){
                            mView.getScreenOverturnSuccess(getScreenOverTurnBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getScreenOverturnError(e);
                        }
                    }
                });
    }
    public void controlScreenOverturn(String deviceSn, int channelId, boolean overTurn, boolean rotation){
        mModel.controlScreenOverturn(deviceSn,channelId,overTurn,rotation).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.controlScreenOverturnSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.controlScreenOverturnError(e);
                        }
                    }
                });
    }

    public void editChannelName(String deviceSn, int channelId, HashMap<String, Object> body){
        mModel.editChannelName(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.editChannelNameSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.editChannelNameError(e);
                        }
                    }
                });
    }


    public void getChannelDetail(String deviceSn, int channelId) {

        //获取通道对应的能力
        mModel.getChannelDetail(deviceSn,channelId).compose(RxHttpReponseCompat.<ChannelBean>compatResult())
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

    public void formatSDCardProgress(String deviceSn, int channelId, HashMap<String, Object> body){
        mModel.formatSDCardProgress(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<FormatProgressBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull FormatProgressBean formatProgressBean) {
                        if (hasView()){
                            mView.formatSDCardProgressSuccess(formatProgressBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.formatSDCardProgressError(e);
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




    /**
     * 获取设备端搜索到的WIFI列表-jy
     * @param body
     */
    public void getDeviceApWifiList(String deviceSn, int channelId, HashMap<String, Object> body){
        mModel.getDeviceApWifiList(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctWifiListAp.ResultBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull OctWifiListAp.ResultBean deviceWifiListBean) {
                        if (hasView()){
                            mView.getDeviceApWifiListSuccess(deviceWifiListBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getDeviceApWifiListError(e);
                        }
                    }
                });
    }


    /**
     * 设备在线的情况下配网-jy
     * @param body
     */
    public void deviceWifiConfig(String deviceSn, int channelId, HashMap<String, Object> body){
        mModel.deviceWifiConfig(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.deviceWifiConfigSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.deviceWifiConfigError(e);
                        }
                    }
                });
    }



    // 获取设备的播放地址
    public void getPlayUrl(String deviceSn, int channelId) {
        mModel.getPlayUrl(deviceSn, channelId).compose(RxHttpReponseCompat.<List<PlayUrlBean>>compatResult())
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


    /**
     * 获取公有云设备日夜切换参数
     * @param body
     */
    public void getDayNightParam(String deviceSn, int channelId, HashMap<String, Object> body){
        mModel.getDayNightParam(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctImageDncutParamBean.ResultBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull OctImageDncutParamBean.ResultBean octImageDncutParamBean) {
                        if (hasView()){
                            mView.getDayNightParamSuccess(octImageDncutParamBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getDayNightParamError(e);
                        }
                    }
                });
    }

    /**
     * 设置公有云设备日夜切换参数
     *
     * @param body
     */
    public void setDayNightParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setDayNightParam(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setDayNightParamSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setDayNightParamError(e);
                        }
                    }
                });
    }

    /**
     * 获取公有云设备日夜切换参数
     * @param body
     */
    public void getImageAbility(String deviceSn, int channelId, HashMap<String, Object> body){
        mModel.getImageAbility(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctImageAbilityGetBean.ResultBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull OctImageAbilityGetBean.ResultBean bean) {
                        if (hasView()){
                            mView.getImageAbilitySuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getImageAbilityError(e);
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


    //获取设备整点报时设置
    public void getHourlyChime(String deviceSn, int channelId) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "hourly_chime_get_param");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("bDefault", false);
        body.put("param", param);
        mModel.getHourlyChime(deviceSn, channelId, body).compose(RxHttpReponseCompat.<DeviceHourlyChimeBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<DeviceHourlyChimeBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull DeviceHourlyChimeBean.ResultBean bean) {
                        if (hasView()) {
                            mView.getHourlyChimeSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getHourlyChimeError(e);
                        }
                    }
                });
    }

    //获取设备整点报时设置
    public void setHourlyChime(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setHourlyChime(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setHourlyChimeSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setHourlyChimeError(e);
                        }
                    }
                });
    }

    //获取报警音计划配置
    public void getAlarmSoundPlan(String deviceSn, int channelId) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "alarm_sound_plan_get");
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("bdefault", false);
        body.put("param", param);
        mModel.getAlarmSoundPlan(deviceSn, channelId, body).compose(RxHttpReponseCompat.<AlarmSoundPlanBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<AlarmSoundPlanBean.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull AlarmSoundPlanBean.ResultBean bean) {
                        if (hasView()) {
                            mView.getAlarmSoundPlanSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getAlarmSoundPlanError(e);
                        }
                    }
                });
    }

    //设置报警音计划配置
    public void setAlarmSoundPlan(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setAlarmSoundPlan(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setAlarmSoundPlanSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setAlarmSoundPlanError(e);
                        }
                    }
                });
    }




    //获取1.0兼容配置
    public void getOnVifDiscoveryFlag(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.getOnVifDiscoveryFlag(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OnvifGetDiscoveryInfo.ResultBean>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull OnvifGetDiscoveryInfo.ResultBean resultBean) {
                        if (hasView()) {
                            mView.getOnVifDiscoveryFlagSuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getOnVifDiscoveryFlagError(e);
                        }
                    }
                });
    }


    //设置1.0兼容设置
    public void setOnVifDiscoveryFlag(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setOnVifDiscoveryFlag(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setOnVifDiscoveryFlagSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setOnVifDiscoveryFlagError(e);
                        }
                    }
                });
    }




    //获取某个或所有通道的所有码流能力集
    public void getStreamAllAbility(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.getStreamAllAbility(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctStreamGetAllAbility.ResultBean>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull OctStreamGetAllAbility.ResultBean resultBean) {
                        if (hasView()) {
                            mView.getStreamAllAbilitySuccess(resultBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getStreamAllAbilityError(e);
                        }
                    }
                });
    }

    //获取某个或所有通道的所有码流参数
    public void getStreamParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.getStreamParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<OctStreamGetParams.ResultBean>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull OctStreamGetParams.ResultBean resultBean) {
                        if (hasView()) {
                            mView.getStreamParamsSuccess(resultBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getStreamParamsError(e);
                        }
                    }
                });

    }

    //设置多个通道的多个码流参数
    public void setStreamParams(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setStreamParams(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setStreamParamsSuccess(emptyBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setStreamParamsError(e);
                        }
                    }
                });
    }

    //恢复默认设置
    public void setDefaultCfg(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setDefaultCfg(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setDefaultCfgSuccess(emptyBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setDefaultCfgError(e);
                        }
                    }
                });
    }


    //低功耗参数获取接口
    public void getDevGetLowPowerParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.getDevGetLowPowerParam(deviceSn, channelId, body).compose(RxHttpReponseCompat.<DevGetLowPowerBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<DevGetLowPowerBean.ResultBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull DevGetLowPowerBean.ResultBean bean) {
                        if (hasView()) {
                            mView.getDevGetLowPowerParamSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getDevGetLowPowerParamError(e);
                        }
                    }
                });
    }

    //低功耗参数设置接口
    public void setDevGetLowPowerParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setDevGetLowPowerParam(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setDevGetLowPowerParamSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setDevGetLowPowerParamError(e);
                        }
                    }
                });
    }



    //挥手呼叫参数获取接口
    public void getWaveHandCallParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.getWaveHandCallParam(deviceSn, channelId, body).compose(RxHttpReponseCompat.<IntelligenceWaveHandCallParam.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<IntelligenceWaveHandCallParam.ResultBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull IntelligenceWaveHandCallParam.ResultBean bean) {
                        if (hasView()) {
                            mView.getWaveHandCallParamSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getWaveHandCallParamError(e);
                        }
                    }
                });
    }

    //挥手呼叫参数设置接口
    public void setWaveHandCallParam(String deviceSn, int channelId, HashMap<String, Object> body) {
        mModel.setWaveHandCallParam(deviceSn, channelId, body).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean bean) {
                        if (hasView()) {
                            mView.setWaveHandCallParamSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setWaveHandCallParamError(e);
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
                            mView.getAlarmLinkIdSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getAlarmLinkIdError(e);
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
        mModel.getSimCardList(deviceSn, channelId, body).compose(RxHttpReponseCompat.<SimCardListBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<SimCardListBean.ResultBean>(mContext, mView, isNotShowProgress) {
                    @Override
                    public void onNext(@NonNull SimCardListBean.ResultBean bean) {
                        if (hasView()) {
                            mView.getSimCardListSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getSimCardListError(e);
                        }
                    }
                });
    }

    //设置要使用的sim卡
    public void setSimCard(String deviceSn, int channelId, int cardSlotId) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "ifconfig_set_simcard");
        HashMap<String, Object> param = new HashMap<>();
        param.put("cardSlotId", cardSlotId);
        body.put("param", param);
        mModel.setSimCard(deviceSn, channelId, body).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, true) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setSimCardSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setSimCardError(e);
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
