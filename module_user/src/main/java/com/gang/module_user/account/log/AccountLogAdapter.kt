package com.gang.module_user.account.log

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_user.R

class AccountLogAdapter :
    BaseQuickAdapter<AccountLogBean, BaseViewHolder>(R.layout.user_adapter_account_log) {
    override fun convert(holder: BaseViewHolder, item: AccountLogBean) {
        holder.setText(R.id.user_adapter_account_log_name, item.id)
    }
}