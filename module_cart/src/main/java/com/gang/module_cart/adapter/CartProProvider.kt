package com.gang.module_cart.adapter

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatCheckBox
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.module_cart.CartEntity
import com.gang.module_cart.R

class CartProProvider : BaseItemProvider<CartEntity>() {
    override val itemViewType: Int
        get() = CartEntity.ITEM_PRO
    override val layoutId: Int
        get() = R.layout.cart_adapter_cart_pro

    override fun convert(helper: BaseViewHolder, item: CartEntity) {
        item.proBean?.let {

            val check = helper.getView<AppCompatCheckBox>(R.id.cart_adapter_cart_pro_check)
            check.isChecked = it.isCheck

            val img = helper.getView<ImageView>(R.id.cart_adapter_cart_pro_img)
            ImageLoader.load(img, it.proimg)

            helper.setText(R.id.cart_adapter_cart_pro_name, it.proname)
            helper.setText(R.id.cart_adapter_cart_pro_spec, it.stylename)
            helper.setText(R.id.cart_adapter_cart_pro_price, it.shopprice)
            helper.setText(R.id.cart_adapter_cart_pro_num, "x" + it.pronum)
        }
    }

    override fun convert(helper: BaseViewHolder, item: CartEntity, payloads: List<Any>) {
        super.convert(helper, item, payloads)

    }
}