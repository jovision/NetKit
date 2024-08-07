package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.LogoutContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class LogoutPresenter extends BasePresenter<LogoutContract.ILogoutModel,LogoutContract.View>{

    @Inject
    public LogoutPresenter(LogoutContract.ILogoutModel iLogoutModel, LogoutContract.View view) {
        super(iLogoutModel, view);
    }

    public void logout(){
        mModel.ACLogout().compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {

                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.ACLogoutSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.ACLogoutError();
                        }
                    }
                });
    }

    public void stopPushMsg(){
        mModel.stopPushMsg().compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView) {

                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.stopPushMsgSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.stopPushMsgError();
                        }
                    }
                });
    }
}
