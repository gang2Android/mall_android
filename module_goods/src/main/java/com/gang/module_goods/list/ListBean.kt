package com.gang.module_goods.list

data class ListBean(
    val list: MutableList<ListItemBean>
)

data class ListItemBean(
    val proid: String,
    val img: String,
    val proname: String,
    val vipprice: String,
    val marketprice: String,
    val lf: String,
    val shop_type: String
)