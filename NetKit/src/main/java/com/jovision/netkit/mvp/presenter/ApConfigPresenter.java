package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.GetUserResponseDataBean;
import com.jovision.netkit.mvp.data.bean.response.ErrorBean2;
import com.jovision.netkit.mvp.data.bean.response.OctAccountModifyUserBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.ApConfigContract;

import javax.inject.Inject;


/**
 * 云视通2.0协议Ap配网功能
 */
public class ApConfigPresenter extends BasePresenter<ApConfigContract.IApConfigModel, ApConfigContract.View> {

    @Inject
    public ApConfigPresenter(ApConfigContract.IApConfigModel model, ApConfigContract.View view) {
        super(model, view);
    }


    /**
     * 2.0 Ap配网
     * @param deviceSn
     * @param wifiName
     * @param wifiPwd
     */
    public void octApConfig(String deviceSn, String devUser, String devPwd,String wifiName, String wifiPwd) {
        mModel.octApConfig(deviceSn,devUser,devPwd,wifiName, wifiPwd).compose(RxHttpReponseCompat.<ErrorBean2>compatResult())
                .subscribe(new ProgressSubcriber<ErrorBean2>(mContext, mView, true) {
                    @Override
                    public void onNext(ErrorBean2 errorBean2) {
                        if (hasView()) {
                            mView.octApConfigSuccess(errorBean2);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octApConfigError(e);
                        }
                    }
                });
    }



    /**
     * 2.0 Ap配网
     */
    public void octAccountGetUser(String pwd) {
        mModel.octAccountGetUser(pwd).compose(RxHttpReponseCompat.<GetUserResponseDataBean>compatResult())
                .subscribe(new ProgressSubcriber<GetUserResponseDataBean>(mContext, mView, true) {
                    @Override
                    public void onNext(GetUserResponseDataBean getUserResponseDataBean) {
                        if (hasView()) {
                            mView.octAccountGetUserSuccess(getUserResponseDataBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octAccountGetUserError(e);
                        }
                    }
                });
    }



    /**
     * 3 修改管理员密码
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param newDevUser
     * @param newDevPwd
     */
    public void octAccountModifyUser(String deviceSn, int channelId, String devUser, String devPwd, String newDevUser, String newDevPwd) {
        mModel.octAccountModifyUser(deviceSn, channelId, devUser, devPwd, newDevUser, newDevPwd).compose(RxHttpReponseCompat.<OctAccountModifyUserBean>compatResult())
                .subscribe(new ProgressSubcriber<OctAccountModifyUserBean>(mContext, mView, true) {
                    @Override
                    public void onNext(OctAccountModifyUserBean octAccountModifyUserBean) {
                        if (hasView()) {
                            mView.octAccountModifyUserSuccess(octAccountModifyUserBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octAccountModifyUserFailed(e);
                        }
                    }
                });
    }


}
