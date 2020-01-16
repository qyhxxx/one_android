package com.qyhxxx.one.hp.model;

import com.qyhxxx.one.hp.bean.HpByMonthBean;
import com.qyhxxx.one.hp.contract.HpListContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HpModel implements HpListContract.Model {
    private static final String BASE_URL = "http://v3.wufazhuce.com:8000/api/";
    private HpApi api;
    private CompositeDisposable disposables;

    public HpModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(HpApi.class);
        disposables = new CompositeDisposable();
    }

    @Override
    public void getData(String month, HpCallback callback) {
        Disposable disposable = api.getHpByMonth(month)
                .subscribeOn(Schedulers.io())
                .map(HpByMonthBean::getData)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(hps -> callback.onSuccess(hps), throwable -> callback.onFail("network error"));
        disposables.add(disposable);
    }

    @Override
    public void release() {
        disposables.clear();
    }
}
