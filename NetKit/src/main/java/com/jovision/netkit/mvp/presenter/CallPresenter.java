package com.jovision.netkit.mvp.presenter;

import com.jovision.basekit.JsonUtils;
import com.jovision.netkit.mvp.data.bean.CallUrlBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.CallContract;

import javax.inject.Inject;

/**
 * Created by ZHP on 2017/7/19.
 */

public class CallPresenter extends BasePresenter<CallContract.ICallModel, CallContract.View> {

    @Inject
    public CallPresenter(CallContract.ICallModel iCallModel, CallContract.View view) {
        super(iCallModel, view);
    }


    public void getCallUrl(String deviceSn, int channelId) {
        mModel.getCallUrl(deviceSn, channelId).compose(RxHttpReponseCompat.<CallUrlBean>compatResult())
                .subscribe(new ProgressSubcriber<CallUrlBean>(mContext, mView) {
                    @Override
                    public void onNext(CallUrlBean callUrlBean) {
                        if (hasView()) {
                            mView.getCallUrlSuccess(JsonUtils.toJson(callUrlBean));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getCallUrlFailed(e);
                        }
                    }
                });
    }
}
