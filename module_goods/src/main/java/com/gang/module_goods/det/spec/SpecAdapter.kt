package com.gang.module_goods.det.spec

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.lib_base.LogUtils
import com.gang.module_base.widget.flowlayout.FlowLayout
import com.gang.module_base.widget.flowlayout.TagAdapter
import com.gang.module_base.widget.flowlayout.TagFlowLayout
import com.gang.module_goods.R

class SpecAdapter :
    BaseQuickAdapter<SpecBean, BaseViewHolder>(R.layout.goods_adapter_det_spec_item) {

    private var callBack: SpecCallBack? = null

    fun setCallBack(callBack: SpecCallBack) {
        this.callBack = callBack
    }

    override fun convert(holder: BaseViewHolder, item: SpecBean) {

        val tagFlowLayout = holder.getView<TagFlowLayout>(R.id.goods_adapter_det_spec_item_value)

        val data = mutableListOf<String>()
        data.add("0")
        data.add("1")
        data.add("2")

        tagFlowLayout.adapter = object : TagAdapter<String>(data) {
            override fun getView(parent: FlowLayout?, position: Int, t: String?): View {
                val tv = LayoutInflater.from(context)
                    .inflate(R.layout.goods_layout_tv, tagFlowLayout, false) as TextView
                tv.text = t
                return tv
            }
        }
        tagFlowLayout.setOnTagClickListener { view, position, parent ->
            callBack?.tagCall(holder.adapterPosition, position)
            return@setOnTagClickListener true
        }
//        tagFlowLayout.setOnSelectListener {
//            LogUtils.print("setOnSelectListener=${it.toString()}")
//        }
    }
}