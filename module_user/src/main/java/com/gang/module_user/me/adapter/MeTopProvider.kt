package com.gang.module_user.me.adapter

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_user.R
import com.gang.module_user.me.MeEntity

class MeTopProvider : BaseItemProvider<MeEntity>() {
    override val itemViewType: Int
        get() = MeEntity.ITEM_TOP
    override val layoutId: Int
        get() = R.layout.user_adapter_me_top

    override fun convert(helper: BaseViewHolder, item: MeEntity) {
    }
}