package com.gang.component_order.affirm.adapter

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.gang.component_order.affirm.AffirmEntity

class AffirmAdapter : BaseProviderMultiAdapter<AffirmEntity>() {
    init {
        addItemProvider(AffirmAddressProvider())
        addItemProvider(AffirmSupHeaderProvider())
        addItemProvider(AffirmProProvider())
        addItemProvider(AffirmSupBotProvider())
    }

    override fun getItemType(data: List<AffirmEntity>, position: Int): Int = data[position].itemType
}