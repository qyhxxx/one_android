package com.qyhxxx.one.reading.model

import com.qyhxxx.one.RequestCallback
import com.qyhxxx.one.reading.bean.ReadingCarouselBean
import com.qyhxxx.one.reading.contract.ReadingContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ReadingModel : ReadingContract.Model {
    private var api: ReadingApi
    private var disposables = CompositeDisposable()

    init {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        api = retrofit.create(ReadingApi::class.java)
    }

    override fun getCarousels(callback: RequestCallback<List<ReadingCarouselBean.Carousel>>) {
        val disposable = api.getReadingCarousel()
                .subscribeOn(Schedulers.io())
                .map { it.data }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({callback.onSuccess(it!!)}, Throwable::printStackTrace)
        disposables.add(disposable)
    }

    companion object {
        private const val BASE_URL = "http://v3.wufazhuce.com:8000/api/reading/"
    }
}