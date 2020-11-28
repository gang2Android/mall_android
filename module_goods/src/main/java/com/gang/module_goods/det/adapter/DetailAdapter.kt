package com.gang.module_goods.det.adapter

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.gang.module_goods.det.DetailEntity

class DetailAdapter : BaseProviderMultiAdapter<DetailEntity>() {

    init {
        addItemProvider(DetailBannerProvider())
        addItemProvider(DetailBaseProvider())
        addItemProvider(DetailSpecProvider())
        addItemProvider(DetailAccessProvider())
        addItemProvider(DetailStoreProvider())
        addItemProvider(DetailRecommendProvider())
        addItemProvider(DetailInfoProvider())
    }

    override fun getItemType(data: List<DetailEntity>, position: Int): Int {
        return data[position].itemType
    }

}