package com.gang.module_goods.det.adapter

import android.widget.LinearLayout
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.module_goods.R
import com.gang.module_goods.det.DetailEntity
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class DetailBannerProvider : BaseItemProvider<DetailEntity>() {
    override val itemViewType: Int
        get() = DetailEntity.ITEM_BANNER
    override val layoutId: Int
        get() = R.layout.goods_adapter_det_banner

    override fun convert(helper: BaseViewHolder, item: DetailEntity) {
        val banner: Banner<String, BannerImageAdapter<String>> =
            helper.getView(R.id.goods_adapter_det_banner)

        val width = context.resources.displayMetrics.widthPixels
        val layoutParams = LinearLayout.LayoutParams(width, width)
        banner.layoutParams = layoutParams

        val list = mutableListOf<String>()
        list.add("http://img13.360buyimg.com/n1/s900x1000_jfs/t1/70245/23/8517/115370/5db84957E5006188f/80e0e2cd9f45118f.jpg")
        list.add("http://img13.360buyimg.com/n1/s900x1000_jfs/t1/76864/12/14169/165059/5db84957E5b52a17b/7d869c76d1c82b3c.jpg")

        val adapter = object : BannerImageAdapter<String>(list) {
            override fun onBindView(
                holder: BannerImageHolder?,
                data: String?,
                position: Int,
                size: Int
            ) {
                holder?.let {
                    ImageLoader.load(it.imageView, data!!)
                }
            }
        }
        banner.setAdapter(adapter).indicator = CircleIndicator(context)
    }
}