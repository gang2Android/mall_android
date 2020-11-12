package com.gang.module_order.affirm.adapter

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_order.R
import com.gang.module_order.affirm.AffirmEntity

class AffirmSupBotProvider : BaseItemProvider<AffirmEntity>() {
    override val itemViewType: Int
        get() = AffirmEntity.ITEM_SUP_BOT
    override val layoutId: Int
        get() = R.layout.order_adapter_affirm_sup_bot

    override fun convert(helper: BaseViewHolder, item: AffirmEntity) {
        item.supBean?.let {
            helper.setText(R.id.order_adapter_affirm_sup_bot_fright, it.fregiht)
            helper.setText(R.id.order_adapter_affirm_sup_bot_price, it.sspp)
        }
    }
}