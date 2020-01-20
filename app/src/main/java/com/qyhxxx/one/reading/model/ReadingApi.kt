package com.qyhxxx.one.reading.model

import com.qyhxxx.one.reading.bean.ReadingCarouselBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ReadingApi {
    @GET("carousel")
    fun getReadingCarousel(): Observable<ReadingCarouselBean>
}