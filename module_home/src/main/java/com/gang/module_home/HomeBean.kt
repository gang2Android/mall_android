package com.gang.module_home

class HomeBean {
    var banner: List<HomeBannerBean>? = null
    var articlelist: List<HomeArticleBean>? = null
    var guanggaoBanner: List<HomeBannerBean>? = null
    var qukuaiconfig: HomeBlackBean? = null
    var category: MutableList<HomeCategoryBean>? = null
    var list: List<HomeProBean>? = null

    data class HomeBannerBean(
        val poster_name: String,
        val poster_url: String,
        val type: String,
        val poster_picpath: String
    )

    data class HomeArticleBean(
        val id: String,
        val ArticleTitle: String,
        val ArticleContent: String,
        val addtime: String
    )

    data class HomeBlackBean(
        val homeWebsiteName: String,
        val homeWebsiteImg: String,
        val homeWebsiteLink: String,

        val homePlName: String,
        val homePlImg: String,
        val homePlLink: String,

        val homeGithubName: String,
        val homeGithubImg: String,
        val homeGithubLink: String
    )

    data class HomeCategoryBean(
        val id: String,
        val name: String,
        val photo: String
    )

    data class HomeProBean(
        val proid: String,
        val img: String,
        val proname: String,
        val vipprice: String,
        val marketprice: String,
        val lf: String,
        val shop_type: String
    )

    override fun toString(): String {
        return "HomeBean(banner=$banner, articlelist=$articlelist, guanggaoBanner=$guanggaoBanner, qukuaiconfig=$qukuaiconfig, category=$category, list=$list)"
    }

}
