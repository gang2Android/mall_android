package com.gang.module_home.adapter

import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.chad.library.adapter.base.listener.GridSpanSizeLookup
import com.gang.module_home.HomeEntity

class HomeAdapter : BaseProviderMultiAdapter<HomeEntity>(), GridSpanSizeLookup {
    init {
        setGridSpanSizeLookup(this)

        addItemProvider(HomeBannerProvider())
        addItemProvider(HomeArticleProvider())
        addItemProvider(HomeGuangGaoProvider())
        addItemProvider(HomeBlockProvider())
        addItemProvider(HomeCategoryProvider())
        addItemProvider(HomeProProvider())
    }

    override fun getItemType(data: List<HomeEntity>, position: Int): Int {
        return data[position].itemType
    }

    override fun getSpanSize(
        gridLayoutManager: GridLayoutManager,
        viewType: Int,
        position: Int
    ): Int {
        return data[position].spanSize
    }
}