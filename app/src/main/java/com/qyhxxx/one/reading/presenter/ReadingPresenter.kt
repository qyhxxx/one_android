package com.qyhxxx.one.reading.presenter

import com.qyhxxx.one.RequestCallback
import com.qyhxxx.one.base.BasePresenter
import com.qyhxxx.one.reading.bean.ReadingCarouselBean
import com.qyhxxx.one.reading.contract.ReadingContract
import com.qyhxxx.one.reading.model.ReadingModel

class ReadingPresenter : BasePresenter<ReadingContract.View, ReadingContract.Model>(), ReadingContract.Presenter {
    override fun initModel(): ReadingContract.Model {
        return ReadingModel()
    }

    override fun loadCarousels() {
        mModel.getCarousels(object : RequestCallback<List<ReadingCarouselBean.Carousel>> {
            override fun onSuccess(data: List<ReadingCarouselBean.Carousel>) {
                if (isViewAttached) {
                    mView?.setBanner(data)
                }
            }

            override fun onFail(msg: String) {

            }
        })
    }
}