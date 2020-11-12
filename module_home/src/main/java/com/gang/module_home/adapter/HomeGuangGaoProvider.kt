package com.gang.module_home.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.module_home.HomeEntity
import com.gang.module_home.R

class HomeGuangGaoProvider : BaseItemProvider<HomeEntity>() {
    override val itemViewType: Int
        get() = HomeEntity.ITEM_GUANGGAO
    override val layoutId: Int
        get() = R.layout.home_adapter_home_guanggao

    override fun convert(helper: BaseViewHolder, item: HomeEntity) {
        val img0 = helper.getView<ImageView>(R.id.home_adapter_guanggao_0)
        val img1 = helper.getView<ImageView>(R.id.home_adapter_guanggao_1)
        val img2 = helper.getView<ImageView>(R.id.home_adapter_guanggao_2)
        val img3 = helper.getView<ImageView>(R.id.home_adapter_guanggao_3)

        item.guanggaoBanner?.let {
            ImageLoader.load(img0, it[0].poster_picpath)
            ImageLoader.load(img1, it[1].poster_picpath)
            ImageLoader.load(img2, it[2].poster_picpath)
            ImageLoader.load(img3, it[3].poster_picpath)
        }

    }
}