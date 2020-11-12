package com.gang.module_order.det.adapter

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.TimeFormatUtils
import com.gang.module_order.R
import com.gang.module_order.det.OrderDetailEntity

class OrderDetailInfoProvider : BaseItemProvider<OrderDetailEntity>() {
    override val itemViewType: Int
        get() = OrderDetailEntity.ITEM_INFO
    override val layoutId: Int
        get() = R.layout.order_adapter_det_info

    override fun convert(helper: BaseViewHolder, item: OrderDetailEntity) {
        item.infoBean?.let {
            helper.setText(R.id.order_adapter_det_info_frightPrice, it.freight)
            helper.setText(R.id.order_adapter_det_info_orderAmount, it.orderAmount)
            helper.setText(R.id.order_adapter_det_info_no, it.outerOrderId)
            helper.setText(
                R.id.order_adapter_det_info_time,
                TimeFormatUtils.time2Str(it.addDate.toLong())
            )
        }
    }
}