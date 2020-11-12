package com.gang.module_order.det.adapter

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_order.R
import com.gang.module_order.det.OrderDetailEntity

class OrderDetailActionProvider: BaseItemProvider<OrderDetailEntity>(){
    override val itemViewType: Int
        get() = OrderDetailEntity.ITEM_ACTION
    override val layoutId: Int
        get() = R.layout.order_adapter_det_action

    override fun convert(helper: BaseViewHolder, item: OrderDetailEntity) {
    }
}