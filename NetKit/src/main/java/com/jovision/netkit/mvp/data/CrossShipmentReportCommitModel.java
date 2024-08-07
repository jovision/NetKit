package com.jovision.netkit.mvp.data;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportBean;
import com.jovision.netkit.mvp.data.bean.response.CrossShipmentReportFileLimitBean;
import com.jovision.netkit.mvp.data.bean.response.UnreadCountBean;
import com.jovision.netkit.mvp.data.bean.response.UploadFilesResponseBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.CrossShipmentReportCommitContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;

public class CrossShipmentReportCommitModel implements CrossShipmentReportCommitContract.IModel {

    private ApiService mApiService;

    public CrossShipmentReportCommitModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<UnreadCountBean>> getCrossShipmentUnreadStatus() {
        return mApiService.getCrossShipmentUnreadStatus();
    }

    @Override
    public Observable<BaseBean<CrossShipmentReportFileLimitBean>> getCrossShipmentReportFileLimit() {
        return mApiService.getCrossShipmentReportFileLimit();
    }

    @Override
    public Observable<BaseBean<EmptyBean>> commitCrossShipmentReport(CrossShipmentReportBean body) {
        return mApiService.commitCrossShipmentReport(body);
    }

    @Override
    public Observable<BaseBean<UploadFilesResponseBean>> uploadFileList(List<String> files) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("files", files);
        return mApiService.uploadFileList(ParamUtil.getBody(parma));
    }
}
