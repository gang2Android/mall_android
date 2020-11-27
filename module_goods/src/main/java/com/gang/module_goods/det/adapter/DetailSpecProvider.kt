package com.gang.module_goods.det.adapter

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_goods.R
import com.gang.module_goods.det.DetailEntity

class DetailSpecProvider: BaseItemProvider<DetailEntity>() {
    override val itemViewType: Int
        get() = DetailEntity.ITEM_SPEC
    override val layoutId: Int
        get() = R.layout.goods_adapter_det_spec

    override fun convert(helper: BaseViewHolder, item: DetailEntity) {
    }
}