package com.gang.module_home.adapter

import android.widget.LinearLayout
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.module_home.HomeBean
import com.gang.module_home.HomeEntity
import com.gang.module_home.R
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class HomeBannerProvider : BaseItemProvider<HomeEntity>() {
    override val itemViewType: Int
        get() = HomeEntity.ITEM_BANNER
    override val layoutId: Int
        get() = R.layout.home_adapter_home_banner

    override fun convert(helper: BaseViewHolder, item: HomeEntity) {
        val banner: Banner<HomeBean.HomeBannerBean, BannerImageAdapter<HomeBean.HomeBannerBean>> =
            helper.getView(R.id.home_adapter_home_banner)

        val width = context.resources.displayMetrics.widthPixels
        val layoutParams = LinearLayout.LayoutParams(width, (width / 2.156).toInt())
        banner.layoutParams = layoutParams

        val adapter = object : BannerImageAdapter<HomeBean.HomeBannerBean>(item.banner) {
            override fun onBindView(
                holder: BannerImageHolder?,
                data: HomeBean.HomeBannerBean?,
                position: Int,
                size: Int
            ) {
                holder?.let {
                    ImageLoader.load(it.imageView, data!!.poster_picpath)
                }
            }
        }
        banner.setAdapter(adapter).indicator = CircleIndicator(context)
    }
}
