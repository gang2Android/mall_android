package com.gang.component_order.list.adapter

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.component_order.R
import com.gang.component_order.list.OrderEntity

class OrderListSupProvider : BaseItemProvider<OrderEntity>() {
    override val itemViewType: Int
        get() = OrderEntity.ITEM_SUP
    override val layoutId: Int
        get() = R.layout.order_adapter_list_sup

    override fun convert(helper: BaseViewHolder, item: OrderEntity) {
        item.sup?.let {
            helper.setText(R.id.order_adapter_order_sup_name, it.supname)
            helper.setText(R.id.order_adapter_order_sup_status, it.staname)
        }
    }
}