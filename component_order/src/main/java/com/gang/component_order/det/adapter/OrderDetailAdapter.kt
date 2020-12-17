package com.gang.component_order.det.adapter

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.gang.component_order.det.OrderDetailEntity

class OrderDetailAdapter : BaseProviderMultiAdapter<OrderDetailEntity>() {
    init {
        addItemProvider(OrderDetailStatusProvider())
        addItemProvider(OrderDetailAddressProvider())
        addItemProvider(OrderDetailProProvider())
        addItemProvider(OrderDetailInfoProvider())
//        addItemProvider(OrderDetailActionProvider())
    }

    override fun getItemType(data: List<OrderDetailEntity>, position: Int): Int {
        return data[position].itemType
    }
}