package com.gang.module_goods.det.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_goods.R
import com.gang.module_goods.det.DetailRecommendBean

class DetailRecommendAdapter :
    BaseQuickAdapter<DetailRecommendBean, BaseViewHolder>(R.layout.goods_adapter_det_recommend_item) {
    override fun convert(holder: BaseViewHolder, item: DetailRecommendBean) {
    }
}