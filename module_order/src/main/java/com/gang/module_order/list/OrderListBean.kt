package com.gang.module_order.list

data class OrderListBean(
    val list: MutableList<OrderSupBean>
)

data class OrderSupBean(
    val supplierid: String,
    val supname: String,
    val status: String,
    val staname: String,
    val shop_type: String,
    val adddate: String,
    val freight: String,
    val orderamount: String,
    val outerOrderId: String,
    val innerorderid: String,
    val voo: MutableList<OrderItemBean>
)

data class OrderItemBean(
    val proid: String,
    val spec_img: String,
    val proname: String,
    val styleid: String,
    val stylename: String,
    val price: String,
    val pronum: String,
    val shop_type: String,
    val outerOrderId: String,
    val innerorderid: String
)