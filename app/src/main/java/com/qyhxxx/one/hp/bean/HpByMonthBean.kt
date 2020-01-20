package com.qyhxxx.one.hp.bean

class HpByMonthBean {
    var res: Int = 0
    var data: List<Hp>? = null

    class Hp {
        var hp_img_url: String? = null
        var hp_content: String? = null
        var hp_author: String? = null
    }
}
