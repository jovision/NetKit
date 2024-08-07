package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.AgreementBean;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.response.QuestionLinkBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.AgreementContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

public class AgreementModel implements AgreementContract.IAgreementModel {
    private ApiService mApiService;

    public AgreementModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public Observable<BaseBean<AgreementBean>> getEnableLink() {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("tenantId", Constant.tenantId);
        return mApiService.getEnableLink(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<QuestionLinkBean>> questionLink() {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("tenantId", Constant.tenantId);
        return mApiService.questionLink(ParamUtil.getBody(parma));
    }
}
