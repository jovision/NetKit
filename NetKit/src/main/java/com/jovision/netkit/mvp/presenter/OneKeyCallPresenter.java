package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.OneKeyCallContract;

import javax.inject.Inject;

public class OneKeyCallPresenter  extends BasePresenter<OneKeyCallContract.IOneKeyCallModel, OneKeyCallContract.View> {

    @Inject
    public OneKeyCallPresenter(OneKeyCallContract.IOneKeyCallModel iOneKeyCallModel, OneKeyCallContract.View view) {
        super(iOneKeyCallModel, view);
    }

    // 设备主动呼叫命令配置, 呼叫状态 answer 接听  refuse 拒接  hangup 挂断
    public void oneKeyCallPublic(String deviceSn, int channelId,String status) {
        mModel.oneKeyCallPublic(deviceSn, channelId,status).compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.oneKeyCallPublicSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.oneKeyCallPublicFailed(e);
                        }
                    }

                });
    }


}
