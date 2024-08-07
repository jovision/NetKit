package com.jovision.netkit.mvp.presenter.contract;
import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.OctChnosdParamGetBean;
import com.jovision.netkit.mvp.data.bean.response.OctOsdGetAbilityBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

/**
 * 云视通2.0协议: OSD设置
 *
 * @author liteng
 * @date 2022/11/28
 */
public interface OctDeviceChnosdParamContract {

    interface IModel {

        // 获取osd参数
        Observable<BaseBean<OctChnosdParamGetBean>> octGetChnosdParam(String deviceSn,
                                                                      int channelId,
                                                                      String devUser,
                                                                      String devPwd,
                                                                      boolean isDefault);

        // 设置osd参数
        Observable<BaseBean<EmptyBean>> octSetChnosdParam(String deviceSn,
                                                          int channelId,
                                                          String devUser,
                                                          String devPwd,
                                                          OctChnosdParamGetBean.ResultBean param);

        // 获取OSD能力
        Observable<BaseBean<OctOsdGetAbilityBean>> octGetOsdAbility(String deviceSn,
                                                                    int channelId,
                                                                    String devUser,
                                                                    String devPwd);
    }

    interface IView extends BaseView {

        void octGetChnosdParamSuccess(OctChnosdParamGetBean bean);

        void octGetChnosdParamError(Throwable e);

        void octSetChnosdParamSuccess();

        void octSetChnosdParamError(Throwable e);

        void octGetOsdAbilitySuccess(OctOsdGetAbilityBean bean);

        void octGetOsdAbilityError(Throwable e);
    }
}
