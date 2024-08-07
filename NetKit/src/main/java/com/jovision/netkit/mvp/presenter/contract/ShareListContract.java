package com.jovision.netkit.mvp.presenter.contract;

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
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface ShareListContract {
    interface IShareListModel{
        //获取共享列表
        Observable<BaseBean<ShareListBean>> shareList(String deviceSn);//, int channelId);
        //添加共享
        Observable<BaseBean<AddShareBean>> addShare(String deviceSn, String account, Permission permission);//int channelId,
        //取消设备下所有分享
        Observable<BaseBean<EmptyBean>> cancelShare(ShareCancelRequest shareCancelRequest);
        //分享详情
        Observable<BaseBean<ShareDetailBean>> shareDetail(String shareNumber);
        //修改共享人备注名
        Observable<BaseBean<EmptyBean>> updateSharedNickName(String shareNumber,String nickname);
        //修改共享权限
        Observable<BaseBean<EmptyBean>> updatePermission(String shareNumber, Permission permission);
        //修改共享状态
        Observable<BaseBean<EmptyBean>> updateShareStatus(String shareNumber,String shareStatus);
        //我的共享
        Observable<BaseBean<List<MyShareDeviceBean>>> myShare(String deviceSn);//,String channelId
        //共享给我的
        Observable<BaseBean<List<ShareToMeBean>>> shareToMe(String deviceSn);//,String channelId

        //获取设备能力级
        Observable<BaseBean<DeviceBean>> getDeviceAbility(String deviceNo);


    }
    interface View extends BaseView {
        void shareListSuccess(ShareListBean shareListBean);
        void shareListError(Throwable e);
        void addShareSuccess(AddShareBean addShareBean);
        void addShareError(Throwable e);
        void shareCancelSuccess();
        void shareCancelError(Throwable e);
        void shareDetailSuccess(ShareDetailBean shareDetailBean);
        void shareDetailError(Throwable e);
        void updateSharedNickNameSuccess();
        void updateSharedNickNameError(Throwable e);
        void updatePermissionSuccess();
        void updatePermissionError(Throwable e);
        void updateShareStatusSuccess();
        void updateShareStatusError(Throwable e);
        void myShareSuccess(List<MyShareDeviceBean> myShareDeviceBeanList);
        void myShareError(Throwable e);
        void shareToMeSuccess(List<ShareToMeBean> shareToMeBeanList);
        void shareToMeError(Throwable e);

        void getDeviceAbilitySuccess(DeviceBean bean);
    }
}
