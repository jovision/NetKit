package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.MessagePushSwitchBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.MessageSettingContract;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class MessageSettingPresenter extends BasePresenter<MessageSettingContract.IMessageSettingModel, MessageSettingContract.View> {

    @Inject
    public MessageSettingPresenter(MessageSettingContract.IMessageSettingModel iMessageSettingModel, MessageSettingContract.View view) {
        super(iMessageSettingModel, view);
    }

    public void getPushSwitch() {
        mModel.getPushSwitch().compose(RxHttpReponseCompat.<MessagePushSwitchBean>compatResult())
                .subscribe(new ProgressSubcriber<MessagePushSwitchBean>(mContext, mView,false) {
                    @Override
                    public void onNext(MessagePushSwitchBean messagePushSwitchBean) {
                        if (hasView()) {
                            mView.getPushSwitchSuccess(messagePushSwitchBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.getPushSwitchFailed(e);
                        }
                    }
                });
    }

    public void setPushSwitch(int alarmSwitch, int userSwitch, int noticeSwitch,int offlineSwitch) {
        mModel.setPushSwitch(alarmSwitch, userSwitch, noticeSwitch,offlineSwitch).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setPushSwitchSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            if (isShowProgress()) {
                                mView.dismissLoading();
                            }
                            mView.setPushSwitchFailed(e);
                        }
                    }
                });
    }

}
