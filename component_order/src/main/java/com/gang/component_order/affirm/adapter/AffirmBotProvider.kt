package com.gang.component_order.affirm.adapter

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.component_order.affirm.AffirmEntity

class AffirmBotProvider : BaseItemProvider<AffirmEntity>() {
    override val itemViewType: Int
        get() = AffirmEntity.ITEM_BOT
    override val layoutId: Int
        get() = TODO("Not yet implemented")

    override fun convert(helper: BaseViewHolder, item: AffirmEntity) {
        TODO("Not yet implemented")
    }

}