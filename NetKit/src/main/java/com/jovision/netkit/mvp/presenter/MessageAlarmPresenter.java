package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.http.MessageCategoryBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.MessageAlarmContract;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class MessageAlarmPresenter extends BasePresenter<MessageAlarmContract.IMessageAlarmModel, MessageAlarmContract.View> {

    @Inject
    public MessageAlarmPresenter(MessageAlarmContract.IMessageAlarmModel iMessageAlarmModel, MessageAlarmContract.View view) {
        super(iMessageAlarmModel, view);
    }

    public void getMsgCategoryList() {
        mModel.getMsgCategoryList().compose(RxHttpReponseCompat.<MessageCategoryBean>compatResult())
                .subscribe(new ProgressSubcriber<MessageCategoryBean>(mContext, mView, true) {
                    @Override
                    public void onNext(MessageCategoryBean messageCategoryBean) {
                        if (hasView()) {
                            mView.getMsgCategoryListSuccess(messageCategoryBean);
                        }
                    }
                });
    }

    public void alarmMsgRead(List<String> alarmCategories, List<Integer> msgIdList) {
        mModel.alarmMsgRead(alarmCategories, msgIdList).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,true) {
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

    public void alarmMsgClean(List<String> alarmCategories, List<Integer> msgIdList, String deviceSn) {
        mModel.alarmMsgClean(alarmCategories, msgIdList, deviceSn).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            //只要调取这个接口，就要更新首页的消息未读红点逻辑
//                            EventBus.getDefault().post(new MessageReadStateUpdateEvent());
                            mView.alarmMsgCleanSuccess();
                        }
                    }
                });
    }
}
