package com.gang.component_order.det

class OrderDetailEntity {
    companion object {
        const val ITEM_STATUS = 1
        const val ITEM_ADDRESS = 2
        const val ITEM_LOG = 3
        const val ITEM_PRO = 4
        const val ITEM_INFO = 5
        const val ITEM_ACTION = 6
    }

    var itemType = ITEM_STATUS

    var statusBean: OrderDetailStatusBean? = null
    var addressBean: OrderDetailAddressBean? = null
    var logBean: OrderDetailLogBean? = null
    var proBean: OrderDetailProBean? = null
    var infoBean: OrderDetailInfoBean? = null
}

data class OrderDetailStatusBean(
    val status: String,
    val statusName: String
)

data class OrderDetailAddressBean(
    val receiveName: String,
    val userTel: String,
    val province: String,
    val city: String,
    val county: String,
    val town: String,
    val address: String
)

data class OrderDetailLogBean(
    val expname: String,
    val awbno: String
)

data class OrderDetailInfoBean(
    val outerOrderId: String,
    val freight: String,
    val orderAmount: String,
    val addDate: String
)