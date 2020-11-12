package com.gang.module_user.me.adapter

import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_user.R
import com.gang.module_user.me.MeEntity

class MeAccountProvider : BaseItemProvider<MeEntity>() {
    override val itemViewType: Int
        get() = MeEntity.ITEM_ACCOUNT
    override val layoutId: Int
        get() = R.layout.user_adapter_me_account

    override fun convert(helper: BaseViewHolder, item: MeEntity) {
    }
}