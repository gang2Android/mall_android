package com.gang.module_order.list

class OrderEntity {
    companion object {
        const val ITEM_SUP = 1
        const val ITEM_PRO = 2
        const val ITEM_BOT = 3
    }

    var itemType = ITEM_SUP

    var sup: OrderSupBean? = null
    var pro: OrderItemBean? = null
    var bot: OrderSupBean? = null
}