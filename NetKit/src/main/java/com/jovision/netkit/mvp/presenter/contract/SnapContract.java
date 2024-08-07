package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.EmptyBean;
import com.jovision.netkit.mvp.data.bean.response.OctTimingSnapBean;
import com.jovision.netkit.mvp.data.bean.response.ResultBean;
import com.jovision.netkit.mvp.data.bean.response.ResultBeanX;
import com.jovision.netkit.mvp.data.bean.response.SnapGetParamBean;
import com.jovision.uikit.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface SnapContract {

    interface ISnapModel {

        //1.定时抓拍功能（新接口）
        Observable<BaseBean<OctTimingSnapBean.ResultBean>> getTimingSnap(String deviceSn, int channelId);

        //2.定时抓拍参数设置
        Observable<BaseBean<EmptyBean>> setTimingSnap(String deviceSn, int channelId, List<OctTimingSnapBean.ResultBean> resultBean);

        //3.获取定时抓拍有图片的日期
        Observable<BaseBean<ResultBean>> getSnapFileDateList(String deviceSn, int channelId, int year, int month);

        //4.获取定时抓拍图片列表
        Observable<BaseBean<ResultBeanX>> getSnapFileList(String deviceSn, int channelId, int year, int month, int day, int page, int pageSize);

        //5.获取抓拍
        Observable<BaseBean<EmptyBean>> getSnapFile(String deviceSn, int channelId, String filePath);

        //6.抓拍功能获取参数
        Observable<BaseBean<SnapGetParamBean.ResultBean>> getSnapParam(String deviceSn, int channelId);

        //7.抓拍功能设置参数
        Observable<BaseBean<EmptyBean>> setSnapParam(String deviceSn, int channelId, SnapGetParamBean.ResultBean resultBean);

    }

    interface View extends BaseView {

        void getTimingSnapSuccess(OctTimingSnapBean.ResultBean resultBean);
        void getTimingSnapFailed(Throwable t);

        void setTimingSnapSuccess();
        void setTimingSnapFailed(Throwable t);

        void getSnapFileDateListSuccess(ResultBean resultBean);
        void getSnapFileDateListFailed(Throwable t);

        void getSnapFileListSuccess(ResultBeanX resultBean);
        void getSnapFileListFailed(Throwable t);

        void getSnapFileSuccess(EmptyBean resultBean);
        void getSnapFileFailed(Throwable t);

        void getSnapParamSuccess(SnapGetParamBean.ResultBean resultBean);
        void getSnapParamFailed(Throwable t);

        void setSnapParamSuccess();
        void setSnapParamFailed(Throwable t);

    }

}
