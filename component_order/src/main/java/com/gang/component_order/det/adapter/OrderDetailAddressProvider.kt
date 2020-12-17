package com.gang.component_order.det.adapter

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.component_order.R
import com.gang.component_order.det.OrderDetailEntity

class OrderDetailAddressProvider : BaseItemProvider<OrderDetailEntity>() {
    override val itemViewType: Int
        get() = OrderDetailEntity.ITEM_ADDRESS
    override val layoutId: Int
        get() = R.layout.order_adapter_det_address

    override fun convert(helper: BaseViewHolder, item: OrderDetailEntity) {
        item.addressBean?.let {
            helper.setText(R.id.order_adapter_order_det_address_name, it.receiveName)
            helper.setText(R.id.order_adapter_order_det_address_mobile, it.userTel)
            helper.setText(
                R.id.order_adapter_order_det_address_info,
                "${it.province}${it.city}${it.county}${it.town}${it.address}"
            )
        }
    }
}