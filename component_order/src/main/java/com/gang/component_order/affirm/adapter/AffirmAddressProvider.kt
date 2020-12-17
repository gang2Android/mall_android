package com.gang.component_order.affirm.adapter

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.component_order.R
import com.gang.component_order.affirm.AffirmEntity

class AffirmAddressProvider : BaseItemProvider<AffirmEntity>() {
    override val itemViewType: Int
        get() = AffirmEntity.ITEM_ADDRESS
    override val layoutId: Int
        get() = R.layout.order_adapter_affirm_address

    override fun convert(helper: BaseViewHolder, item: AffirmEntity) {
        item.addressBean?.let {
            helper.setText(R.id.order_adapter_affirm_address_name, it.ReceiveName)
            helper.setText(R.id.order_adapter_affirm_address_mobile, it.Mobile)
            helper.setText(
                R.id.order_adapter_affirm_address_info,
                "${it.Province}${it.City}${it.County}${it.town}${it.Address}"
            )
        }
    }
}