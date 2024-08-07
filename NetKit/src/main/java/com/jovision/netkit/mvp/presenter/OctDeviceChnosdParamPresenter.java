package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.OctChnosdParamGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctOsdGetAbilityBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.OctDeviceChnosdParamContract;

import androidx.annotation.NonNull;

import javax.inject.Inject;

/**
 * 云视通2.0协议: OSD设置
 *
 * @author liteng
 * @date 2022/11/28
 */
public class OctDeviceChnosdParamPresenter
        extends BasePresenter<OctDeviceChnosdParamContract.IModel, OctDeviceChnosdParamContract.IView> {

    @Inject
    public OctDeviceChnosdParamPresenter(OctDeviceChnosdParamContract.IModel model,
                                         OctDeviceChnosdParamContract.IView view) {
        super(model, view);
    }

    /**
     * 获取osd参数
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param isDefault         true: 获取默认参数; false: 不获取默认参数
     * @param isNotShowProgress true: 不显示loading; false: 显示loading
     */
    public void octGetChnosdParam(String deviceSn, int channelId,
                                  String devUser, String devPwd,
                                  boolean isDefault, boolean isNotShowProgress) {
        mModel.octGetChnosdParam(deviceSn, channelId, devUser, devPwd, isDefault)
                .compose(RxHttpReponseCompat.<OctChnosdParamGetBean>compatResult())
                .subscribe(new ProgressSubcriber<OctChnosdParamGetBean>
                        (mContext, mView, isNotShowProgress) {
                    @Override
                    public void onNext(OctChnosdParamGetBean bean) {
                        if (hasView()) {
                            mView.octGetChnosdParamSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetChnosdParamError(e);
                        }
                    }
                });
    }

    /**
     * 设置osd参数
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     * @param paramBean
     * @param isNotShowProgress true: 不显示loading; false: 显示loading
     */
    public void octSetChnosdParam(String deviceSn, int channelId, String devUser, String devPwd,
                                  @NonNull OctChnosdParamGetBean.ResultBean paramBean,
                                  boolean isNotShowProgress) {
        mModel.octSetChnosdParam(deviceSn, channelId, devUser, devPwd, paramBean)
                .compose(RxHttpReponseCompat.<EmptyBean>compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, isNotShowProgress) {
                    @Override
                    public void onNext(EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.octSetChnosdParamSuccess();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (hasView()) {
                            mView.octSetChnosdParamError(e);
                        }
                    }
                });
    }

    /**
     * 获取OSD能力
     *
     * @param deviceSn
     * @param channelId
     * @param devUser
     * @param devPwd
     */
    public void octGetOsdAbility(String deviceSn, int channelId, String devUser, String devPwd) {
        mModel.octGetOsdAbility(deviceSn, channelId, devUser, devPwd)
                .compose(RxHttpReponseCompat.<OctOsdGetAbilityBean>compatResult())
                .subscribe(new ProgressSubcriber<OctOsdGetAbilityBean>(mContext, mView) {
                    @Override
                    public void onNext(OctOsdGetAbilityBean bean) {
                        if (hasView()) {
                            mView.octGetOsdAbilitySuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.octGetOsdAbilityError(e);
                        }
                    }
                });
    }
}
