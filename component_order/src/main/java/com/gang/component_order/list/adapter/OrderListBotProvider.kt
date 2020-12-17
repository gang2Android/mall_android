package com.gang.component_order.list.adapter

import android.view.View
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.component_order.R
import com.gang.component_order.list.OrderEntity

class OrderListBotProvider : BaseItemProvider<OrderEntity>() {
    override val itemViewType: Int
        get() = OrderEntity.ITEM_BOT
    override val layoutId: Int
        get() = R.layout.order_adapter_list_bot

    override fun convert(helper: BaseViewHolder, item: OrderEntity) {
        item.bot?.let {
            helper.setText(R.id.order_adapter_order_bot_price, "¥" + it.orderamount+ it.status)
//            helper.setText(R.id.order_adapter_order_bot_no, it.innerorderid)

            // 订单状态 1未付款 2已付款 3配货中 4已发货 8已收货 10已取消  15用户已申请取消 20后台取消
            when (it.status) {
                "1" -> {
                    helper.getView<View>(R.id.order_adapter_order_bot_cancel).visibility = View.VISIBLE
                    helper.getView<View>(R.id.order_adapter_order_bot_pay).visibility = View.VISIBLE
                }
                "2","3" -> {
                    helper.getView<View>(R.id.order_adapter_order_bot_cancel).visibility = View.VISIBLE
                    helper.getView<View>(R.id.order_adapter_order_bot_call).visibility = View.VISIBLE
                }
                "4" -> {
                    helper.getView<View>(R.id.order_adapter_order_bot_service).visibility = View.VISIBLE
                    helper.getView<View>(R.id.order_adapter_order_bot_access).visibility = View.VISIBLE
                }
                "8" -> {
                    helper.getView<View>(R.id.order_adapter_order_bot_receipt).visibility = View.VISIBLE
//                    helper.getView<View>(R.id.order_adapter_order_bot_del).visibility = View.VISIBLE
                    helper.getView<View>(R.id.order_adapter_order_bot_too).visibility = View.VISIBLE
                }
                "10","15","20" -> {
                    helper.getView<View>(R.id.order_adapter_order_bot_del).visibility = View.VISIBLE
                    helper.getView<View>(R.id.order_adapter_order_bot_too).visibility = View.VISIBLE
                }
            }
        }
    }
}