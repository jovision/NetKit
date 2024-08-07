package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.DeviceBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.request.ShareCancelRequest;
import com.jovision.netkit.mvp.data.bean.response.AddShareBean;
import com.jovision.netkit.mvp.data.bean.response.MyShareDeviceBean;
import com.jovision.netkit.mvp.data.bean.response.Permission;
import com.jovision.netkit.mvp.data.bean.response.ShareDetailBean;
import com.jovision.netkit.mvp.data.bean.response.ShareListBean;
import com.jovision.netkit.mvp.data.bean.response.ShareToMeBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.ShareListContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.List;
import java.util.TreeMap;

import io.reactivex.Observable;

public class ShareListModel implements ShareListContract.IShareListModel {

    private ApiService mApiService;

    public ShareListModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public Observable<BaseBean<ShareListBean>> shareList(String deviceSn) {//, int channelId
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
//        parma.put("channelId", channelId);
        return mApiService.getShareList(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<AddShareBean>> addShare(String deviceSn, String account, Permission permission) {// int channelId,
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
//        parma.put("channelId", channelId);
        parma.put("account", account);
        parma.put("permission", permission);
        return mApiService.addShare(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> cancelShare(ShareCancelRequest shareCancelRequest) {
        return mApiService.cancelShare(shareCancelRequest);
    }

    @Override
    public Observable<BaseBean<ShareDetailBean>> shareDetail(String shareNumber) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("shareNumber", shareNumber);
        return mApiService.shareDetail(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> updateSharedNickName(String shareNumber, String nickname) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("shareNumber", shareNumber);
        parma.put("nickname", nickname);
        return mApiService.updateSharedNickName(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> updatePermission(String shareNumber, Permission permission) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("shareNumber", shareNumber);
        parma.put("permission", permission);
        return mApiService.updatePermission(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<EmptyBean>> updateShareStatus(String shareNumber, String shareStatus) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("shareNumber", shareNumber);
        parma.put("shareStatus", shareStatus);
        return mApiService.updateShareStatus(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<List<MyShareDeviceBean>>> myShare(String deviceSn) {//, String channelId
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
//        parma.put("channelId", channelId);
        return mApiService.myShare(ParamUtil.getBody(parma));
    }

    @Override
    public Observable<BaseBean<List<ShareToMeBean>>> shareToMe(String deviceSn) {//,String channelId
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceSn);
//        parma.put("channelId", channelId);
        return mApiService.shareToMe(ParamUtil.getBody(parma));
    }


    @Override
    public Observable<BaseBean<DeviceBean>> getDeviceAbility(String deviceNo) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("deviceSn", deviceNo);
        return mApiService.getDeviceDetail(ParamUtil.getBody(parma));
    }

}
