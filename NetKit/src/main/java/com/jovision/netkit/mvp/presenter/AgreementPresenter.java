package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.AgreementBean;
import com.jovision.netkit.mvp.data.bean.response.QuestionLinkBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.AgreementContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class AgreementPresenter extends BasePresenter<AgreementContract.IAgreementModel,AgreementContract.View> {
    @Inject
    public AgreementPresenter(AgreementContract.IAgreementModel iAgreementModel, AgreementContract.View view) {
        super(iAgreementModel, view);
    }
    public void getEnableLink(){
        mModel.getEnableLink().compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<AgreementBean>(mContext,mView,false) {
                    @Override
                    public void onNext(@NonNull AgreementBean agreementBean) {
                        if (hasView()){
                            mView.getEnableLinkSuccess(agreementBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getEnableLinkError(e);
                        }
                    }
                });
    }
    public void questionLink(){
        mModel.questionLink().compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<QuestionLinkBean>(mContext,mView,false) {
                    @Override
                    public void onNext(@NonNull QuestionLinkBean questionLinkBean) {
                        if (hasView()){
                            mView.questionLinkSuccess(questionLinkBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.questionLinkError(e);
                        }
                    }
                });
    }
}
