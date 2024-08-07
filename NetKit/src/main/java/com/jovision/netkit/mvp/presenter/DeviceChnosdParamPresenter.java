package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.OctChnosdParamGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctOsdGetAbilityBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.DeviceChnosdParamContract;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * 公有云协议: OSD设置
 *
 * @author liteng
 * @date 2022/11/28
 */
public class DeviceChnosdParamPresenter
        extends BasePresenter<DeviceChnosdParamContract.IModel, DeviceChnosdParamContract.IView> {

    @Inject
    public DeviceChnosdParamPresenter(DeviceChnosdParamContract.IModel model,
                                      DeviceChnosdParamContract.IView view) {
        super(model, view);
    }

    /**
     * 获取osd参数
     *
     * @param deviceSn
     * @param channelId
     * @param isDefault         true: 获取默认参数; false: 不获取默认参数
     * @param isNotShowProgress true: 不显示loading; false: 显示loading
     */
    public void getChnosdParam(String deviceSn, int channelId, boolean isDefault,
                               boolean isNotShowProgress) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("bdefault", isDefault);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "chnosd_param_get");
        body.put("param", param);

        mModel.getChnosdParam(deviceSn, channelId, body)
                .compose(RxHttpReponseCompat.<OctChnosdParamGetBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctChnosdParamGetBean.ResultBean>
                        (mContext, mView, isNotShowProgress) {
                    @Override
                    public void onNext(@NonNull OctChnosdParamGetBean.ResultBean bean) {
                        if (hasView()) {
                            mView.getChnosdParamSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getChnosdParamError(e);
                        }
                    }
                });
    }

    /**
     * 设置osd参数
     *
     * @param deviceSn
     * @param channelId
     * @param paramBean
     * @param isNotShowProgress true: 不显示loading; false: 显示loading
     */
    public void setChnosdParam(String deviceSn, int channelId,
                               @NonNull OctChnosdParamGetBean.ResultBean paramBean,
                               boolean isNotShowProgress) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);
        param.put("attr", paramBean);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "chnosd_param_set");
        body.put("param", param);

        mModel.setChnosdParam(deviceSn, channelId, body)
                .compose(RxHttpReponseCompat.compatResult())
                .subscribe(new ProgressSubcriber<EmptyBean>(mContext, mView, isNotShowProgress) {
                    @Override
                    public void onNext(@NonNull EmptyBean emptyBean) {
                        if (hasView()) {
                            mView.setChnosdParamSuccess(emptyBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.setChnosdParamError(e);
                        }
                    }
                });
    }

    /**
     * 获取OSD能力
     *
     * @param deviceSn
     * @param channelId
     */
    public void getOsdAbility(String deviceSn, int channelId) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelid", channelId);

        HashMap<String, Object> body = new HashMap<>();
        body.put("method", "osd_get_ability");
        body.put("param", param);

        mModel.getOsdAbility(deviceSn, channelId, body)
                .compose(RxHttpReponseCompat.<OctOsdGetAbilityBean.ResultBean>compatResult())
                .subscribe(new ProgressSubcriber<OctOsdGetAbilityBean.ResultBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull OctOsdGetAbilityBean.ResultBean bean) {
                        if (hasView()) {
                            mView.getOsdAbilitySuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()) {
                            mView.getOsdAbilityError(e);
                        }
                    }
                });
    }
}
