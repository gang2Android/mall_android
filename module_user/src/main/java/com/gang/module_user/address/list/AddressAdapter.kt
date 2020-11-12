package com.gang.module_user.address.list

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_user.R
import com.gang.module_user.address.AddressItemBean

class AddressAdapter :
    BaseQuickAdapter<AddressItemBean, BaseViewHolder>(R.layout.user_adapter_address_list) {
    override fun convert(holder: BaseViewHolder, item: AddressItemBean) {
        holder.setText(R.id.user_adapter_address_list_name, item.ReceiveName)
        holder.setText(R.id.user_adapter_address_list_mobile, item.Mobile)
        holder.setText(
            R.id.user_adapter_address_list_info,
            item.Province + item.City + item.County + item.town + item.address
        )
        holder.setText(R.id.user_adapter_address_list_time, item.AddDate)
        if (item.IsDefault) {
            holder.getView<TextView>(R.id.user_adapter_address_list_default).visibility =
                View.VISIBLE
        } else {
            holder.getView<TextView>(R.id.user_adapter_address_list_default).visibility =
                View.GONE
        }
    }
}