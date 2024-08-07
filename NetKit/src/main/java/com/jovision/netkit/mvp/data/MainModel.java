package com.jovision.netkit.mvp.data;

import android.os.Build;

import com.jovision.basekit.deviceid.DeviceFlagUtil;
import com.jovision.basekit.utilcode.AppUtils;
import com.jovision.basekit.utilcode.Utils;
import com.jovision.netkit.mvp.CodeConstant;
import com.jovision.netkit.mvp.Constant;
import com.jovision.netkit.mvp.data.bean.AgreementBean;
import com.jovision.netkit.mvp.data.bean.AppVersionResponseBean;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.UserInfoWithAgreementVersionBean;
import com.jovision.netkit.mvp.data.bean.request.UploadUserInfoBean;
import com.jovision.netkit.mvp.data.bean.response.ACUserInfoBean;
import com.jovision.netkit.mvp.data.bean.response.HomeMenuBean;
import com.jovision.netkit.mvp.data.bean.response.MultiBindBean;
import com.jovision.netkit.mvp.data.bean.response.ToDoOperationListBean;
import com.jovision.netkit.mvp.data.bean.response.ToDoTransferListBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.MainContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

public class MainModel implements MainContract.IMainModel {

    private ApiService mApiService;

    public MainModel(ApiService apiService) {
        this.mApiService = apiService;
    }


    @Override
    public Observable<BaseBean<HomeMenuBean>> getMenuList() {

        return mApiService.getMenuList(CodeConstant.LOGIN_APP_TYPE_ANDROID, AppUtils.getAppInfo().getVersionName());
    }

    @Override
    public Observable<BaseBean<AppVersionResponseBean>> getAppNewestVersion() {
        TreeMap<String, Object> map = ParamUtil.getParma();
        map.put("versionCode", AppUtils.getAppInfo().getVersionCode());
        map.put("terminalId", DeviceFlagUtil.getUniqueDeviceId(Utils.getApp()));
        map.put("osVersion", Build.VERSION.SDK_INT);
        map.put("osType", CodeConstant.LOGIN_APP_TYPE_ANDROID);
        map.put("phoneManufacturer", Build.MANUFACTURER);
        return mApiService.getAppNewestVersion(ParamUtil.getBody(map));
    }

    @Override
    public Observable<BaseBean<AgreementBean>> getEnableLink() {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("tenantId", Constant.tenantId);
        return mApiService.getEnableLink(ParamUtil.getBody(parma));
    }


    @Override
    public Observable<BaseBean<EmptyBean>> agree() {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("type", 1);
        return mApiService.agree(ParamUtil.getBody(param));
    }

    @Override
    public Observable<BaseBean<ACUserInfoBean>> ACGetUserInfo() {
        return mApiService.ACGetUserInfo();
    }

    @Override
    public Observable<BaseBean<UserInfoWithAgreementVersionBean>> getUserInfoWithAgreementVersion() {
        return mApiService.getUserInfoWithAgreementVersion();
    }


    @Override
    public Observable<BaseBean<EmptyBean>> uploadUserInfo(UploadUserInfoBean requestBean) {
        return mApiService.uploadUserInfo(requestBean);
    }

    @Override
    public Observable<BaseBean<MultiBindBean>> checkMultiBind() {
        return mApiService.checkMultiBind();
    }

    @Override
    public Observable<BaseBean<EmptyBean>> clearMultiBind() {
        return mApiService.clearMultiBind();
    }

    //[工程商服务]用户回应远程运维申请 -2023.7.19
    @Override
    public Observable<BaseBean<EmptyBean>> answerRemoteOperation(String deviceId,boolean accept) {
        TreeMap<String, Object> param = ParamUtil.getParma();
        param.put("deviceID", deviceId);
        param.put("status", accept?1:0);//状态，0-拒绝 1-同意
        return mApiService.answerRemoteOperation(ParamUtil.getBody(param));
    }


    //设备转移提醒列表
    @Override
    public Observable<BaseBean<ToDoTransferListBean>> getDevTransferList() {
        return mApiService.getDevTransferList();
    }

    //远程运维消息提醒列表
    @Override
    public Observable<BaseBean<ToDoOperationListBean>> getDevOperationList() {
        return mApiService.getDevOperationList();
    }

    //清除设备转移提醒列表
    @Override
    public Observable<BaseBean<EmptyBean>> clearDeviceTransfer() {
        return mApiService.clearDeviceTransfer();
    }
}
