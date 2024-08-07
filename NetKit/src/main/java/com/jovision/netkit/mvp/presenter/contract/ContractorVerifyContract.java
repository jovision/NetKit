package com.jovision.netkit.mvp.presenter.contract;


import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.ContractorInfoBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.CreateContractorRequestBean;
import com.jovision.netkit.mvp.data.bean.response.UploadContractorFileBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

public interface ContractorVerifyContract {

    interface IContractorVerifyModel {
        Observable<BaseBean<ContractorInfoBean>> getContractorInfo(String phone);
        Observable<BaseBean<EmptyBean>> createContractor(CreateContractorRequestBean createContractorRequestBean);
        Observable<BaseBean<UploadContractorFileBean>> getUploadContractorFileUrl(String fileSuffix);
    }

    interface View extends BaseView {
        void getContractorInfoSuccess(ContractorInfoBean contractorInfoBean);
        void getContractorInfoError(Throwable e);
        void createContractorSuccess();
        void createContractorError(Throwable e);
        void getUploadContractorFileUrlSuccess(UploadContractorFileBean uploadContractorFileBean);
        void getUploadContractorFileUrlError(Throwable e);
    }


}
