package com.gang.module_home

class HomeEntity {
    companion object {
        const val ITEM_BANNER = 1
        const val ITEM_ARTICLE = 2
        const val ITEM_GUANGGAO = 3
        const val ITEM_BLOCK = 4
        const val ITEM_CATEGORY = 5
        const val ITEM_PRO = 6
    }

    var itemType = 1
    var spanSize = 2

    var banner: List<HomeBean.HomeBannerBean>? = null
    var articlelist: List<HomeBean.HomeArticleBean>? = null
    var guanggaoBanner: List<HomeBean.HomeBannerBean>? = null
    var qukuaiconfig: HomeBean.HomeBlackBean? = null
    var category: MutableList<HomeBean.HomeCategoryBean>? = null
    var list: HomeBean.HomeProBean? = null

    override fun toString(): String {
        return "HomeEntity(itemType=$itemType, banner=$banner, articlelist=$articlelist, guanggaoBanner=$guanggaoBanner, qukuaiconfig=$qukuaiconfig, category=$category, list=$list)"
    }

}