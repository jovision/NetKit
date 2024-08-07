package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.UploadUserInfoBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.PushContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


/**
 * Created by ZHP on 2017/11/6.
 */

public class PushModel implements PushContract.IPushModel {

    private ApiService mApiService;

    public PushModel(ApiService apiService) {
        this.mApiService = apiService;
    }


    @Override
    public Observable<BaseBean<EmptyBean>> upLoadToken(String token, int tokenType) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("token", token);
        parma.put("tokenType", tokenType);

        return mApiService.upLoadToken(ParamUtil.getBody(parma));
    }


    @Override
    public Observable<BaseBean<EmptyBean>> uploadUserInfo(UploadUserInfoBean requestBean) {
        return mApiService.uploadUserInfo(requestBean);
    }

}
