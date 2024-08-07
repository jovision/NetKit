package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.AddLogoBean;
import com.jovision.netkit.mvp.data.bean.response.FileUploadBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.H5Contract;

import javax.inject.Inject;

public class H5Presenter extends BasePresenter<H5Contract.IH5Model, H5Contract.View> {

    @Inject
    public H5Presenter(H5Contract.IH5Model iModel, H5Contract.View view) {
        super(iModel, view);
    }

    public void getFileUploadInfo(String filename) {
        mModel.getFileUploadInfo(filename)
                .compose(RxHttpReponseCompat.<FileUploadBean>compatResult())
                .subscribe(new ProgressSubcriber<FileUploadBean>(mContext, mView, false) {
                    @Override
                    public void onNext(FileUploadBean bean) {
                        if (hasView()) {
                            mView.getFileUploadInfoSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getFileUploadInfoFailed(e);
                        }
                    }
                });
    }

    public void addLogo(String filePath) {
        mModel.addLogo(filePath)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, false) {
                    @Override
                    public void onNext(EmptyBean bean) {
                        if (hasView()) {
                            AddLogoBean addLogoBean = new AddLogoBean();
                            addLogoBean.setFilePath(filePath);
                            mView.addLogoSuccess(addLogoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.addLogoFailed(e);
                        }
                    }
                });
    }

}
