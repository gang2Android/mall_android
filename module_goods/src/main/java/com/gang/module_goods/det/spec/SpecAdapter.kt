package com.gang.module_goods.det.spec

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_goods.R

class SpecAdapter :
    BaseQuickAdapter<SpecBean, BaseViewHolder>(R.layout.goods_adapter_det_spec_item) {
    override fun convert(holder: BaseViewHolder, item: SpecBean) {
    }
}