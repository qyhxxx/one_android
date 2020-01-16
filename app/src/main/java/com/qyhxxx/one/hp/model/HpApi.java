package com.qyhxxx.one.hp.model;

import com.qyhxxx.one.hp.bean.HpByMonthBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HpApi {
    @GET("hp/bymonth/{month}")
    Observable<HpByMonthBean> getHpByMonth(@Path("month") String month);
}
