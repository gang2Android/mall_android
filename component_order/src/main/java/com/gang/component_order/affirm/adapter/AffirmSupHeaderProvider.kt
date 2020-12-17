package com.gang.component_order.affirm.adapter

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.component_order.R
import com.gang.component_order.affirm.AffirmEntity

class AffirmSupHeaderProvider : BaseItemProvider<AffirmEntity>() {
    override val itemViewType: Int
        get() = AffirmEntity.ITEM_SUP_HEADER
    override val layoutId: Int
        get() = R.layout.order_adapter_affirm_sup_header

    override fun convert(helper: BaseViewHolder, item: AffirmEntity) {
        item.supBean?.let {
            helper.setText(R.id.order_adapter_affirm_sup_header_name, it.supname)
        }
    }
}