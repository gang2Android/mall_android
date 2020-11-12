package com.gang.module_home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_home.HomeBean
import com.gang.module_home.HomeEntity
import com.gang.module_home.R
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.transformer.ZoomOutPageTransformer

class HomeArticleProvider : BaseItemProvider<HomeEntity>() {
    override val itemViewType: Int
        get() = HomeEntity.ITEM_ARTICLE
    override val layoutId: Int
        get() = R.layout.home_adapter_home_article

    override fun convert(helper: BaseViewHolder, item: HomeEntity) {
        val banner: Banner<HomeBean.HomeArticleBean, BannerAdapter<HomeBean.HomeArticleBean, HomeArticleAdapter.ViewHolder>> =
            helper.getView(R.id.home_adapter_article_banner)

        val width = context.resources.displayMetrics.widthPixels
        val layoutParams = LinearLayout.LayoutParams(width, (width * 0.1).toInt())
        banner.layoutParams = layoutParams

        val adapter = HomeArticleAdapter(item.articlelist!!)
        banner.setAdapter(adapter)
            .setOrientation(Banner.VERTICAL)
            .setPageTransformer(ZoomOutPageTransformer())
    }
}

class HomeArticleAdapter(data: List<HomeBean.HomeArticleBean>) :
    BannerAdapter<HomeBean.HomeArticleBean, HomeArticleAdapter.ViewHolder>(data) {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var text: TextView? = null

        init {
            text = itemView.findViewById(R.id.home_adapter_article_item)
        }

        fun setViewData(itemBean: HomeBean.HomeArticleBean) {
            text?.text = itemBean.ArticleTitle
        }
    }

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent!!.context).inflate(R.layout.home_adapter_article_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindView(
        holder: ViewHolder?,
        data: HomeBean.HomeArticleBean?,
        position: Int,
        size: Int
    ) {
        holder!!.setViewData(data!!)
    }
}