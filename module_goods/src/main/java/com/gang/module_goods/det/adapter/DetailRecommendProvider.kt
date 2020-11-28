package com.gang.module_goods.det.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_goods.R
import com.gang.module_goods.det.DetailEntity

class DetailRecommendProvider : BaseItemProvider<DetailEntity>() {
    override val itemViewType: Int
        get() = DetailEntity.ITEM_RECOMMEND
    override val layoutId: Int
        get() = R.layout.goods_adapter_det_recommend

    override fun convert(helper: BaseViewHolder, item: DetailEntity) {
        val rv = helper.getView<RecyclerView>(R.id.goods_adapter_det_recommend_rv)
        rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)

        val adapter = DetailRecommendAdapter()
        rv.adapter = adapter

        adapter.setNewInstance(item.recommend)
    }
}