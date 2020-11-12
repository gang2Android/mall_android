package com.gang.module_user.me.adapter

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.me.MeEntity
import com.gang.module_user.me.MeExtendBean

class MeExtendProvider : BaseItemProvider<MeEntity>() {
    override val itemViewType: Int
        get() = MeEntity.ITEM_EXTEND
    override val layoutId: Int
        get() = R.layout.user_adapter_me_extend

    override fun convert(helper: BaseViewHolder, item: MeEntity) {
        val recyclerView: RecyclerView = helper.getView(R.id.user_adapter_me_extend_rv)
        val spanCount: Int = if (item.meExtends!!.size > 5) {
            2
        } else {
            1
        }
        val layoutManager = GridLayoutManager(context, spanCount)
        layoutManager.orientation = GridLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager

        val adapter = ExtendChildAdapter()
        recyclerView.adapter = adapter
        adapter.setNewInstance(item.meExtends)

        adapter.setOnItemClickListener { _, _, position ->
            when (position) {
                0 -> {
                    ARouter.getInstance().build(ModuleRouter.USER_ADDRESS_LIST_ACTIVITY)
                        .navigation()
                }
                1 -> {
                    ARouter.getInstance().build(ModuleRouter.USER_SHARE_ACT)
                        .navigation()
                }
            }
        }
    }

    class ExtendChildAdapter :
        BaseQuickAdapter<MeExtendBean, BaseViewHolder>(R.layout.user_adapter_me_extend_child) {
        override fun convert(holder: BaseViewHolder, item: MeExtendBean) {
            holder.setText(R.id.user_adapter_me_extend_child_name, item.name)
        }

    }
}