package com.jovision.netkit.mvp.presenter.contract;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.WeatherBean;
import com.jovision.uikit.BaseView;

import io.reactivex.Observable;

public interface WeatherContract {
    interface IWeatherModel{
        Observable<BaseBean<WeatherBean>> getByDistrict(String districtId);
    }
    interface View extends BaseView {
        void getByDistrictSuccess(WeatherBean weatherBean);
        void getByDistrictError(Throwable e);
    }
}
