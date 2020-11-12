package com.gang.module_home.adapter

import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.module_home.HomeBean
import com.gang.module_home.HomeEntity
import com.gang.module_home.R

class HomeCategoryProvider : BaseItemProvider<HomeEntity>() {
    override val itemViewType: Int
        get() = HomeEntity.ITEM_CATEGORY
    override val layoutId: Int
        get() = R.layout.home_adapter_home_category

    override fun convert(helper: BaseViewHolder, item: HomeEntity) {
        val recyclerView: RecyclerView = helper.getView(R.id.home_adapter_home_category)
        recyclerView.layoutManager = GridLayoutManager(context, item.category!!.size / 2)
        val adapter = HomeCategoryChildAdapter(item.category!!)
        recyclerView.adapter = adapter
    }

    class HomeCategoryChildAdapter(data: MutableList<HomeBean.HomeCategoryBean>) :
        BaseQuickAdapter<HomeBean.HomeCategoryBean, BaseViewHolder>(
            R.layout.home_adapter_home_category_child,
            data
        ) {
        override fun convert(holder: BaseViewHolder, item: HomeBean.HomeCategoryBean) {
            holder.setText(R.id.home_adapter_home_category_child_name, item.name)
            val img = holder.getView<ImageView>(R.id.home_adapter_home_category_child_img)
            ImageLoader.load(img, item.photo)
        }
    }
}