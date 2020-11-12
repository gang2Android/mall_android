package com.gang.module_order.list.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.module_order.R
import com.gang.module_order.list.OrderEntity

class OrderListProProvider : BaseItemProvider<OrderEntity>() {
    override val itemViewType: Int
        get() = OrderEntity.ITEM_PRO
    override val layoutId: Int
        get() = R.layout.order_adapter_list_pro

    override fun convert(helper: BaseViewHolder, item: OrderEntity) {
        item.pro?.let {
            val img = helper.getView<ImageView>(R.id.order_adapter_order_pro_img)
            ImageLoader.load(img, it.spec_img)

            helper.setText(R.id.order_adapter_order_pro_name, it.proname)
            helper.setText(R.id.order_adapter_order_pro_spec, it.stylename)
            helper.setText(R.id.order_adapter_order_pro_price, "¥" + it.price)
            helper.setText(R.id.order_adapter_order_pro_num, "x" + it.pronum)
        }
    }
}