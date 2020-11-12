package com.gang.module_user.me.adapter

import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.chad.library.adapter.base.listener.GridSpanSizeLookup
import com.gang.module_user.me.MeEntity

class MeAdapter : BaseProviderMultiAdapter<MeEntity>(), GridSpanSizeLookup {
    init {
        setGridSpanSizeLookup(this)

        addItemProvider(MeTopProvider())
        addItemProvider(MeAccountProvider())
        addItemProvider(MeOrderProvider())
        addItemProvider(MeExtendProvider())
    }

    override fun getItemType(data: List<MeEntity>, position: Int): Int = data[position].itemType

    override fun getSpanSize(
        gridLayoutManager: GridLayoutManager,
        viewType: Int,
        position: Int
    ): Int {
        return data[position].spanSize
    }
}