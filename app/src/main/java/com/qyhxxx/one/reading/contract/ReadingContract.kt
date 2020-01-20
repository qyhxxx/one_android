package com.qyhxxx.one.reading.contract

import com.qyhxxx.one.RequestCallback
import com.qyhxxx.one.base.BaseModel
import com.qyhxxx.one.base.BaseView
import com.qyhxxx.one.reading.bean.ReadingCarouselBean

interface ReadingContract {
    interface Model : BaseModel {
        fun getCarousels(callback: RequestCallback<List<ReadingCarouselBean.Carousel>>)
    }

    interface View : BaseView {
        fun setBanner(data : List<ReadingCarouselBean.Carousel>)
    }

    interface Presenter {
        fun loadCarousels()
    }
}