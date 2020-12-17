package com.gang.component_order.affirm.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.component_order.R
import com.gang.component_order.affirm.AffirmEntity

class AffirmProProvider : BaseItemProvider<AffirmEntity>() {
    override val itemViewType: Int
        get() = AffirmEntity.ITEM_PRO
    override val layoutId: Int
        get() = R.layout.order_adapter_affirm_pro

    override fun convert(helper: BaseViewHolder, item: AffirmEntity) {
        item.proBean?.let {
            helper.setText(R.id.order_adapter_affirm_pro_name, it.proname)
            helper.setText(R.id.order_adapter_affirm_pro_spec, it.stylename)
            helper.setText(R.id.order_adapter_affirm_pro_price, "¥" + it.shopprice)
            helper.setText(R.id.order_adapter_affirm_pro_num, "x" + it.pronum)

            val img = helper.getView<ImageView>(R.id.order_adapter_affirm_pro_img)
            ImageLoader.load(img, it.img)
        }
    }
}