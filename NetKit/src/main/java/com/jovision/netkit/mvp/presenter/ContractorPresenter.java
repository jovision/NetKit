package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.ContractorInfoBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.CreateContractorRequestBean;
import com.jovision.netkit.mvp.data.bean.response.UploadContractorFileBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.ContractorVerifyContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class ContractorPresenter extends BasePresenter<ContractorVerifyContract.IContractorVerifyModel, ContractorVerifyContract.View>{

    @Inject
    public ContractorPresenter(ContractorVerifyContract.IContractorVerifyModel iContractorVerifyModel, ContractorVerifyContract.View view) {
        super(iContractorVerifyModel, view);
    }

    public void createContractor(CreateContractorRequestBean createContractorRequestBean){
        mModel.createContractor(createContractorRequestBean).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext,mView,false) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()){
                            mView.createContractorSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.createContractorError(e);
                        }
                    }
                });
    }

    public void getContractorInfo(String phone){
        mModel.getContractorInfo(phone).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<ContractorInfoBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull ContractorInfoBean contractorInfoBean) {
                        if (hasView()){
                            mView.getContractorInfoSuccess(contractorInfoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getContractorInfoError(e);
                        }
                    }
                });
    }

    public void getUploadContractorFileUrl(String fileSuffix){
        mModel.getUploadContractorFileUrl(fileSuffix).compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<UploadContractorFileBean>(mContext,mView,false) {
                    @Override
                    public void onNext(@NonNull UploadContractorFileBean uploadContractorFileBean) {
                        if (hasView()){
                            mView.getUploadContractorFileUrlSuccess(uploadContractorFileBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getUploadContractorFileUrlError(e);
                        }
                    }
                });
    }

}
