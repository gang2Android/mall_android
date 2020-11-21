package com.gang.module_goods.list

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.module_goods.R

class ListAdapter : BaseQuickAdapter<ListItemBean, BaseViewHolder>(R.layout.goods_adapter_list) {
    override fun convert(holder: BaseViewHolder, item: ListItemBean) {
        val img = holder.getView<ImageView>(R.id.goods_adapter_list_img)
        ImageLoader.load(img, item.img)

        holder.setText(R.id.goods_adapter_list_name, item.proname)
        holder.setText(R.id.goods_adapter_list_price, item.vipprice)
    }
}