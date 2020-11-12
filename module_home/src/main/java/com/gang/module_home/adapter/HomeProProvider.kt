package com.gang.module_home.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.module_home.HomeEntity
import com.gang.module_home.R

class HomeProProvider : BaseItemProvider<HomeEntity>() {
    override val itemViewType: Int
        get() = HomeEntity.ITEM_PRO
    override val layoutId: Int
        get() = R.layout.home_adapter_home_pro

    override fun convert(helper: BaseViewHolder, item: HomeEntity) {
        val img = helper.getView<ImageView>(R.id.home_adapter_home_pro_img)
        ImageLoader.load(img, item.list!!.img)

        helper.setText(R.id.home_adapter_home_pro_name, item.list!!.proname)
        helper.setText(R.id.home_adapter_home_pro_price, item.list!!.vipprice)
    }
}