package com.jovision.netkit.mvp.module;

import com.jovision.netkit.mvp.data.WeatherModel;
import com.jovision.netkit.mvp.data.http.ApiService;
import com.jovision.netkit.mvp.presenter.contract.WeatherContract;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherModule {
    private WeatherContract.View mView;

    public WeatherModule(WeatherContract.View mView) {
        this.mView = mView;
    }
    @Provides
    public WeatherContract.View provideView(){return mView;}
    @Provides
    public WeatherContract.IWeatherModel provideModel(ApiService apiService){
        return new WeatherModel(apiService);
    }
}
