package com.gang.module_cart

class CartEntity {
    companion object {
        const val ITEM_SUP = 1
        const val ITEM_PRO = 2
    }

    var itemType = 0

    var supBean: CartSupBean? = null
    var proBean: CartProBean? = null

    override fun toString(): String {
        return "CartEntity(itemType=$itemType, supBean=$supBean, proBean=$proBean)"
    }

}

data class CartBean(val goods_num: String, val data_list: MutableList<CartSupBean>)
data class CartSupBean(
    val supid: String,
    val supname: String,
    val sub: MutableList<CartProBean>,
    var isCheck: Boolean = false
)

data class CartProBean(
    var sid: String?,
    val id: String,
    val proid: String,
    val proimg: String,
    val proname: String,
    val stylename: String,
    val pronum: String,
    val shopprice: String,
    var isCheck: Boolean = false
)