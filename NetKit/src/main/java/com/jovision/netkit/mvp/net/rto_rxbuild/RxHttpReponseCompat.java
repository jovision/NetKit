package com.jovision.netkit.mvp.net.rto_rxbuild;


import android.util.Log;


import com.jovision.basekit.LogUtil;
import com.jovision.netkit.mvp.bean.BaseBean;
import com.jovision.netkit.mvp.net.rto_exception.ApiException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZHP on 2017/6/25.
 */
public class RxHttpReponseCompat {

    public static String TAG = "HTTP-LOG";

    public static <T> ObservableTransformer<BaseBean<T>, T> compatResult() {

        return new ObservableTransformer<BaseBean<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseBean<T>> baseBeanObservable) {

                return baseBeanObservable.flatMap(new Function<BaseBean<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(@NonNull final BaseBean<T> tBaseBean) throws Exception {
                        LogUtil.e(TAG, "apply-compatResult:" + tBaseBean.getCode() + "------------" + tBaseBean.getMsg());
                        if (tBaseBean.success()) {
                            return Observable.create(new ObservableOnSubscribe<T>() {
                                @Override
                                public void subscribe(ObservableEmitter<T> subscriber) throws Exception {

                                    try {
                                        T data = tBaseBean.getData();

                                        if (null == data) {
                                            Log.e(TAG, "nvr_crash_Exception");
                                            subscriber.onNext((T) new EmptyBean());
                                            subscriber.onComplete();

//                                            UIUtil.showToastSafe("设备返回数据格式错误");
//                                            ApiException a = new ApiException("1999","设备返回数据格式错误");
//                                            a.setCode(tBaseBean.getCode());
//                                            a.setDisplayMessage(tBaseBean.getMsg());
//
//                                            LogUtil.e(TAG,"Exception:code="+tBaseBean.getCode()+";msg="+tBaseBean.getMsg());
//
//                                            subscriber.onError(a);


//                                            try {
//                                                //修改NVR崩溃问题
////                                                ((BaseActivity) UIUtil.getContext()).dismissLoading();
//
////                                                subscriber.onNext(null);
////                                                subscriber.onComplete();
//
//                                                ApiException a = new ApiException("1999", "设备返回数据格式错误");
//                                                a.setCode(tBaseBean.getCode());
//                                                a.setDisplayMessage(tBaseBean.getMsg());
//
//                                            } catch (Exception e) {
//                                                e.printStackTrace();
//                                            }


                                        } else {

                                            LogUtil.e(TAG, "create:data=" + tBaseBean.getData().toString());
                                            subscriber.onNext(data);
                                            subscriber.onComplete();
                                        }
                                    } catch (Exception e) {
                                        ApiException a = (ApiException) e;
                                        a.setCode(tBaseBean.getCode());
                                        a.setDisplayMessage(tBaseBean.getMsg());

                                        LogUtil.e(TAG, "Exception:code=" + tBaseBean.getCode() + ";msg=" + tBaseBean.getMsg());

                                        subscriber.onError(a);
                                    }
                                }
                            });
                        } else {
                            if(null == tBaseBean.getData()){
                                LogUtil.e(TAG, "api-compatResult-failed:" + tBaseBean.getCode() + "------------" + tBaseBean.getMsg()+";tBaseBean.getData()=null");
                            } else {
                                LogUtil.e(TAG, "api-compatResult-failed:" + tBaseBean.getCode() + "------------" + tBaseBean.getMsg()+";tBaseBean.getData()="+tBaseBean.getData().toString());
                            }

                            return Observable.error(new ApiException(tBaseBean.getCode(), tBaseBean.getMsg(), tBaseBean.getData()));
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };

    }
//
//    public static <T> ObservableTransformer<BaseBean<T>, Optional<T>> compatResult2() {
//
//        return new ObservableTransformer<BaseBean<T>, Optional<T>>() {
//            @Override
//            public ObservableSource<Optional<T>> apply(Observable<BaseBean<T>> baseBeanObservable) {
//
//                return baseBeanObservable.flatMap(new Function<BaseBean<T>, ObservableSource<Optional<T>>>() {
//                    @Override
//                    public ObservableSource<Optional<T>> apply(@NonNull final BaseBean<T> tBaseBean) throws Exception {
//                        LogUtil.e(TAG,"api-compatResult2:"+tBaseBean.getCode() + "------------" + tBaseBean.getMsg());
//                        if (tBaseBean.success()) {
//                            return Observable.create(new ObservableOnSubscribe<Optional<T>>() {
//                                @Override
//                                public void subscribe(ObservableEmitter<Optional<T>> subscriber) throws Exception {
//                                    try {
//                                        subscriber.onNext(tBaseBean.transform());
//                                        subscriber.onComplete();
//                                    } catch (Exception e) {
//                                        ApiException a = (ApiException) e;
//                                        a.setCode(tBaseBean.getCode());
//                                        a.setDisplayMessage(tBaseBean.getMsg());
//                                        subscriber.onError(a);
//                                    }
//                                }
//                            });
//                        } else {
//                            LogUtil.e("api-compatResult2-failed)", tBaseBean.getCode() + "------------" + tBaseBean.getMsg());
//                            return Observable.error(new ApiException(tBaseBean.getCode(), tBaseBean.getMsg()));
//                        }
//                    }
//                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
//            }
//        };
//
//    }

    /*private static <T> Observable<Optional<T>> createHttpData(Optional<T> t) {

        return Observable.create(e -> {
            try {
                e.onNext(t);
                e.onComplete();
            } catch (Exception exc) {
                e.onError(exc);
            }
        });
    }*/
}
