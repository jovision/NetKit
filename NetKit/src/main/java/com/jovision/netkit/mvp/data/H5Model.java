package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.FileUploadBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.H5Contract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;


public class H5Model implements H5Contract.IH5Model {

    private ApiService mApiService;

    public H5Model(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<FileUploadBean>> getFileUploadInfo(String filename) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("fileName", filename);
        return mApiService.getFileUploadInfo(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> addLogo(String filepath) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("imageUrl", filepath);
        return mApiService.addLogo(ParamUtil.getBody(parma));
    }
}
