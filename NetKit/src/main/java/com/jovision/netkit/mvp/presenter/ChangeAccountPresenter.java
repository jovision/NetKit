package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.ChangeAccountContract;

import javax.inject.Inject;

public class ChangeAccountPresenter extends BasePresenter<ChangeAccountContract.IChangeAccountModel, ChangeAccountContract.View> {

    @Inject
    public ChangeAccountPresenter(ChangeAccountContract.IChangeAccountModel iModel, ChangeAccountContract.View view) {
        super(iModel, view);
    }

    public void changeAccount(String switchType) {
        mModel.changeAccount(switchType)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView,true) {
                    @Override
                    public void onNext(EmptyBean bean) {
                        if (hasView()) {
                            mView.changeAccountSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.changeAccountError(e);
                        }
                    }
                });
    }

}
