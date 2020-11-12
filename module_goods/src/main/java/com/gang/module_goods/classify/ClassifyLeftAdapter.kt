package com.gang.module_goods.classify

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_goods.R

class ClassifyLeftAdapter :
    BaseQuickAdapter<ClassifyBean, BaseViewHolder>(R.layout.goods_adapter_classify_left) {
    override fun convert(holder: BaseViewHolder, item: ClassifyBean) {
        val name = holder.getView<TextView>(R.id.goods_adapter_classify_left_name)
        name.text = item.name
        if (item.isChecked) {
            name.textSize = 16f
            name.setTextColor(ContextCompat.getColor(context, android.R.color.black))
        } else {
            name.textSize = 14f
            name.setTextColor(ContextCompat.getColor(context, android.R.color.darker_gray))
        }
    }
}