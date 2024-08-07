package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.ContractorInfoBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.CreateContractorRequestBean;
import com.jovision.netkit.mvp.data.bean.response.UploadContractorFileBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ContractorVerifyContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

public class ContractorVerifyModel implements ContractorVerifyContract.IContractorVerifyModel {

    private ApiService mApiService;

    public ContractorVerifyModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public Observable<BaseBean<ContractorInfoBean>> getContractorInfo(String phone) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("phone", phone);
        return mApiService.getContractorInfo(ParamUtil.getBody(param));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> createContractor(CreateContractorRequestBean createContractorRequestBean) {
        return mApiService.createContractor(createContractorRequestBean);
    }

    @Override
    public Observable<BaseBean<UploadContractorFileBean>> getUploadContractorFileUrl(String fileSuffix) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("fileSuffix", fileSuffix);
        return mApiService.getUploadContractorFileUrl(ParamUtil.getBody(param));
    }
}
