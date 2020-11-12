package com.gang.module_home.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.module_home.HomeEntity
import com.gang.module_home.R

class HomeBlockProvider : BaseItemProvider<HomeEntity>() {
    override val itemViewType: Int
        get() = HomeEntity.ITEM_BLOCK
    override val layoutId: Int
        get() = R.layout.home_adapter_home_block

    override fun convert(helper: BaseViewHolder, item: HomeEntity) {
        val img0 = helper.getView<ImageView>(R.id.home_adapter_block_0)
        val img1 = helper.getView<ImageView>(R.id.home_adapter_block_1)
        val img2 = helper.getView<ImageView>(R.id.home_adapter_block_2)

        ImageLoader.load(img0, item.qukuaiconfig!!.homeWebsiteImg)
        ImageLoader.load(img1, item.qukuaiconfig!!.homePlImg)
        ImageLoader.load(img2, item.qukuaiconfig!!.homeGithubImg)
    }
}