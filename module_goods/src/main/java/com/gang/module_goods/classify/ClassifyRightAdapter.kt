package com.gang.module_goods.classify

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.ImageLoader
import com.gang.module_goods.R

class ClassifyRightAdapter :
    BaseQuickAdapter<ClassifyBean, BaseViewHolder>(R.layout.goods_adapter_classify_right) {
    override fun convert(holder: BaseViewHolder, item: ClassifyBean) {
        holder.setText(R.id.goods_adapter_classify_right_name, item.name)

        val rv = holder.getView<RecyclerView>(R.id.goods_adapter_classify_right_child)
        rv.layoutManager = GridLayoutManager(context, 4)

        if (item.children == null) {
            rv.visibility = View.GONE
            return
        } else {
            rv.visibility = View.VISIBLE
        }

        val adapter = ClassifyRightChildAdapter(item.children!!)
        rv.adapter = adapter
    }

    class ClassifyRightChildAdapter(data: MutableList<ClassifyBean>) :
        BaseQuickAdapter<ClassifyBean, BaseViewHolder>(
            R.layout.goods_adapter_classify_right_child,
            data
        ) {
        override fun convert(holder: BaseViewHolder, item: ClassifyBean) {
            holder.setText(R.id.goods_adapter_classify_right_child_name, item.name)

            val img = holder.getView<ImageView>(R.id.goods_adapter_classify_right_child_img)
            ImageLoader.load(img, item.photo)
        }

    }
}