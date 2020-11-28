package com.gang.module_goods.det

data class DetailBean(
    val id: String
)

class DetailEntity {
    companion object {
        const val ITEM_BANNER = 1
        const val ITEM_BASE = 2
        const val ITEM_SPEC = 3
        const val ITEM_ACCESS = 5
        const val ITEM_STORE = 6
        const val ITEM_INFO = 7
        const val ITEM_RECOMMEND = 8
    }

    var itemType = ITEM_BANNER

    var recommend: MutableList<DetailRecommendBean>? = null
}

data class DetailRecommendBean(
    val id: String
)