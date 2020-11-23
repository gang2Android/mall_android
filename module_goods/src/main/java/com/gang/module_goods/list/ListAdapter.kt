package com.gang.module_goods.list

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.module_goods.R

class ListAdapter(context: Context) :
    BaseQuickAdapter<ListItemBean, BaseViewHolder>(R.layout.goods_adapter_list_grid) {

    var width = 0

    init {
        width = context.resources.displayMetrics.widthPixels / 2 - 10
    }

    override fun convert(holder: BaseViewHolder, item: ListItemBean) {
        val img = holder.getView<ImageView>(R.id.goods_adapter_list_img)

        val layoutParams = LinearLayout.LayoutParams(width, width)
        img.layoutParams = layoutParams

        ImageLoader.load(img, item.img, R.drawable.pro_place)

        holder.setText(R.id.goods_adapter_list_name, item.proname)
        holder.setText(R.id.goods_adapter_list_price, item.vipprice)
    }
}