package com.gang.module_cart.adapter

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.gang.module_cart.CartEntity

class CartAdapter : BaseProviderMultiAdapter<CartEntity>() {
    init {
        addItemProvider(CartSupProvider())
        addItemProvider(CartProProvider())
    }

    override fun getItemType(data: List<CartEntity>, position: Int): Int {
        return data[position].itemType
    }

}