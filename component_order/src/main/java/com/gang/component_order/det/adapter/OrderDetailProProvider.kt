package com.gang.component_order.det.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.component_order.R
import com.gang.component_order.det.OrderDetailEntity

class OrderDetailProProvider : BaseItemProvider<OrderDetailEntity>() {
    override val itemViewType: Int
        get() = OrderDetailEntity.ITEM_PRO
    override val layoutId: Int
        get() = R.layout.order_adapter_det_pro

    override fun convert(helper: BaseViewHolder, item: OrderDetailEntity) {
        item.proBean?.let {
            helper.setText(R.id.order_adapter_det_pro_name, it.proname)
            helper.setText(R.id.order_adapter_det_pro_spec, it.stylename)
            helper.setText(R.id.order_adapter_det_pro_price, "¥" + it.price)
            helper.setText(R.id.order_adapter_det_pro_num, "x" + it.pronum)

            val img = helper.getView<ImageView>(R.id.order_adapter_det_pro_img)
            ImageLoader.load(img, it.spec_img)
        }
    }
}