package com.jovision.netkit.mvp.data;

import com.jovision.netkit.mvp.data.bean.BaseBean;
import com.jovision.netkit.mvp.data.bean.WeatherBean;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.WeatherContract;
import com.jovision.netkit.mvp.util.ParamUtil;

import java.util.TreeMap;

import io.reactivex.Observable;

public class WeatherModel implements WeatherContract.IWeatherModel {
    private ApiService mApiservice;

    public WeatherModel(ApiService mApiservice) {
        this.mApiservice = mApiservice;
    }

    @Override
    public Observable<BaseBean<WeatherBean>> getByDistrict(String districtId) {
        TreeMap<String, Object> parma = ParamUtil.getParma();
        parma.put("districtId", districtId);
        return mApiservice.getByDistrict(ParamUtil.getBody(parma));
    }
}
