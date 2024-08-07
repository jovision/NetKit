package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.OctChnosdParamGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctOsdGetAbilityBean;
import com.jovision.uikit.BaseView;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * 公有云协议: OSD设置
 *
 * @author liteng
 * @date 2022/11/28
 */
public interface DeviceChnosdParamContract {

    interface IModel {
        // 获取osd参数
        Observable<BaseBean<OctChnosdParamGetBean.ResultBean>> getChnosdParam(String deviceSn,
                                                                              int channelId,
                                                                              HashMap<String, Object> body);

        // 设置osd参数
        Observable<BaseBean<EmptyBean>> setChnosdParam(String deviceSn,
                                                       int channelId,
                                                       HashMap<String, Object> body);

        // 获取OSD能力
        Observable<BaseBean<OctOsdGetAbilityBean.ResultBean>> getOsdAbility(String deviceSn,
                                                                            int channelId,
                                                                            HashMap<String, Object> body);

    }

    interface IView extends BaseView {

        void getChnosdParamSuccess(OctChnosdParamGetBean.ResultBean bean);

        void getChnosdParamError(Throwable e);

        void setChnosdParamSuccess(EmptyBean emptyBean);

        void setChnosdParamError(Throwable e);

        void getOsdAbilitySuccess(OctOsdGetAbilityBean.ResultBean bean);

        void getOsdAbilityError(Throwable e);
    }
}
