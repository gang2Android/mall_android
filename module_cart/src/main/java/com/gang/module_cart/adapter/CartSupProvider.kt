package com.gang.module_cart.adapter

import androidx.appcompat.widget.AppCompatCheckBox
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.LogUtils
import com.gang.module_cart.CartEntity
import com.gang.module_cart.R

class CartSupProvider : BaseItemProvider<CartEntity>() {
    override val itemViewType: Int
        get() = CartEntity.ITEM_SUP
    override val layoutId: Int
        get() = R.layout.cart_adapter_cart_sup

    override fun convert(helper: BaseViewHolder, item: CartEntity) {
        item.supBean?.let {
            val check = helper.getView<AppCompatCheckBox>(R.id.cart_adapter_cart_sup_check)
            check.isChecked = it.isCheck
            LogUtils.print("sup=isCheck=${it.isCheck}")
            helper.setText(R.id.cart_adapter_cart_sup_name, it.supname + " >")
        }
    }
}