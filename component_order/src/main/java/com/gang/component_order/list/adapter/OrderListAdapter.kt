package com.gang.component_order.list.adapter

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.gang.component_order.list.OrderEntity

class OrderListAdapter : BaseProviderMultiAdapter<OrderEntity>() {

    init {
        addItemProvider(OrderListSupProvider())
        addItemProvider(OrderListProProvider())
        addItemProvider(OrderListBotProvider())
    }

    override fun getItemType(data: List<OrderEntity>, position: Int): Int {
        return data[position].itemType
    }
}