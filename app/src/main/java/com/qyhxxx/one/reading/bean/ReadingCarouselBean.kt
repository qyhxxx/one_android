package com.qyhxxx.one.reading.bean

class ReadingCarouselBean {
    var res: Int? = 0
    var data: List<Carousel>? = null

    class Carousel {
        var id: String? = null
        var title: String? = null
        var cover: String? = null
        var bottom_text: String? = null
    }
}