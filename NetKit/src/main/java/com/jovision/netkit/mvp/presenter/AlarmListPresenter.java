package com.jovision.netkit.mvp.presenter;
import com.jovision.netkit.mvp.data.bean.DeviceMessageBean;
import com.jovision.netkit.mvp.data.bean.MessageAlarmListBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.AlarmListContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class AlarmListPresenter extends BasePresenter<AlarmListContract.IAlarmListModel, AlarmListContract.View> {

    @Inject
    public AlarmListPresenter(AlarmListContract.IAlarmListModel iAlarmListModel, AlarmListContract.View view) {
        super(iAlarmListModel, view);
    }

    public void alarmMsgList(List<String> alarmCategories, List<DeviceMessageBean> devices, String alarmDate, String pageStartAlarmTime, int pageStartId, int pageSize) {
        mModel.alarmMsgList(alarmCategories, devices, alarmDate, pageStartAlarmTime, pageStartId, pageSize).compose(RxHttpReponseCompat.<MessageAlarmListBean>compatResult())
                .subscribe(new ProgressSubcriber<MessageAlarmListBean>(mContext, mView,false) {
                    @Override
                    public void onNext(MessageAlarmListBean messageAlarmListBean) {
                        if (hasView()) {
                            mView.alarmMsgListSuccess(messageAlarmListBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.alarmMsgListError(e);
                        }
                    }
                });
    }
}
