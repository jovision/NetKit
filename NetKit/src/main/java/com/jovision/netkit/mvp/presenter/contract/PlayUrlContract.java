package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.CallUrlBean;
import com.jovision.netkit.mvp.data.bean.response.PetNewDeviceBean;
import com.jovision.netkit.mvp.data.http.ConnectUrlBean;
import com.jovision.netkit.mvp.data.http.PlayUrlBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ZHP on 2018/12/27/0027.
 */
public interface PlayUrlContract {

    interface IPlayUrlModel {
        Observable<BaseBean<List<PlayUrlBean>>> getPlayUrl(String deviceSn, int channelId, int streamId);
        Observable<BaseBean<CallUrlBean>> getCallUrl(String deviceSn, int channelId);
        Observable<BaseBean<List<ConnectUrlBean>>> getYstPlayUrl(String deviceSn, int channelId, String deviceIp, int devicePort);

        //查询套餐是否赠送
        Observable<BaseBean<PetNewDeviceBean>> getSmartAbilityIsPetNewDevice(String deviceSn);



//        Observable<BaseBean<RDLPRSystemGetParam>> getParamLPRSystem(String deviceSn, int channelId);
//        Observable<BaseBean<EmptyBean>> setParamLPRSystem(String deviceSn, int channelId, RDLPRSystemSetParam rdlprSystemSetParam);
    }

    interface View extends BaseView {
        void getPlayUrlSuccess(PlayUrlBean playUrlBean);
        void getPlayUrlFailed(Throwable t);

        void getCallUrlSuccess(String callUrl);
        void getCallUrlFailed(Throwable t);

        void getYstPlayUrlSuccess(List<ConnectUrlBean> playUrlBean);
        void getYstPlayUrlFailed(Throwable t);

        void getSmartAbilityIsPetNewDeviceSuccess(PetNewDeviceBean petNewDeviceBean);
        void getSmartAbilityIsPetNewDeviceFailed(Throwable t);



//        void getParamLPRSystemSuccess(RDLPRSystemGetParam rdlprSystemGetParam);
//        void getParamLPRSystemFailed(Throwable t);
//
//
//        void setParamLPRSystemSuccess(EmptyBean emptyBean);
//        void setParamLPRSystemFailed(Throwable t);
    }

}
