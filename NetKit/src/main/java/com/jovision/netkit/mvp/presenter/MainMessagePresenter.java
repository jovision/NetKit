package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.MessageBadgesBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.MainMessageContract;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class MainMessagePresenter extends BasePresenter<MainMessageContract.IMainMessageModel, MainMessageContract.View> {

    @Inject
    public MainMessagePresenter(MainMessageContract.IMainMessageModel iMainMessageModel, MainMessageContract.View view) {
        super(iMainMessageModel, view);
    }


    public void getMsgBadges() {
        mModel.getMsgBadges().compose(RxHttpReponseCompat.<MessageBadgesBean>compatResult())
                .subscribe(new ProgressSubcriber<MessageBadgesBean>(mContext, mView, true) {
                    @Override
                    public void onNext(MessageBadgesBean messageBadgesBean) {
                        if (hasView()) {
                            mView.getMsgBadgesSuccess(messageBadgesBean);
                        }
                    }
                });
    }


    //获取未读状态（工程商、意见反馈）
    public void getUnreadStatus() {
        mModel.getUnreadStatus().compose(RxHttpReponseCompat.<UnreadCountBean>compatResult())
                .subscribe(new ProgressSubcriber<UnreadCountBean>(mContext, mView, true) {
                    @Override
                    public void onNext(UnreadCountBean unreadCountBean) {
                        if (hasView()) {
                            mView.getUnreadStatusSuccess(unreadCountBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getUnreadStatusError(e);
                        }
                    }
                });
    }
}
