package com.qyhxxx.one.reading.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qyhxxx.one.R
import com.qyhxxx.one.base.BaseFragment
import com.qyhxxx.one.reading.bean.ReadingCarouselBean
import com.qyhxxx.one.reading.contract.ReadingContract
import com.qyhxxx.one.reading.presenter.ReadingPresenter
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.fragment_reading.*

class ReadingFragment : BaseFragment<ReadingPresenter>(), ReadingContract.View {
    private var imageList: MutableList<String> = ArrayList()
    private var titleList: MutableList<String> = ArrayList()

    override fun initPresenter(): ReadingPresenter {
        return ReadingPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        reading_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        reading_banner.setImageLoader(GlideImageLoader())
        reading_banner.isAutoPlay(false)

        mPresenter.loadCarousels()
    }

    override fun setBanner(data: List<ReadingCarouselBean.Carousel>) {
        for (carousel in data) {
            imageList.add(carousel.cover!!)
            titleList.add(carousel.title!!)
        }
        reading_banner.setImages(imageList)
        reading_banner.setBannerTitles(titleList)
        reading_banner.start()
    }
}