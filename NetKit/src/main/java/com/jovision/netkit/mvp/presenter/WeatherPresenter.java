package com.jovision.netkit.mvp.presenter;

import com.jovision.netkit.mvp.data.bean.WeatherBean;
import com.jovision.netkit.mvp.net.rto_rxbuild.RxHttpReponseCompat;
import com.jovision.netkit.mvp.net.rto_subscriber.ProgressSubcriber;
import com.jovision.netkit.mvp.presenter.contract.WeatherContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class WeatherPresenter extends BasePresenter<WeatherContract.IWeatherModel,WeatherContract.View>{
    @Inject
    public WeatherPresenter(WeatherContract.IWeatherModel iWeatherModel, WeatherContract.View view) {
        super(iWeatherModel, view);
    }

    public void getByDistrict(String districtId){
        mModel.getByDistrict(districtId).compose(RxHttpReponseCompat.<WeatherBean>compatResult())
                .subscribe(new ProgressSubcriber<WeatherBean>(mContext,mView,true) {
                    @Override
                    public void onNext(@NonNull WeatherBean weatherBean) {
                        if (hasView()){
                            mView.getByDistrictSuccess(weatherBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        if (hasView()){
                            mView.getByDistrictError(e);
                        }
                    }
                });
    }
}
