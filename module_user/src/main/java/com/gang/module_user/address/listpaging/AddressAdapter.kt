package com.gang.module_user.address.listpaging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gang.module_user.R
import com.gang.module_user.address.AddressItemBean

class AddressAdapter :
    PagingDataAdapter<AddressItemBean, AddressAdapter.ViewHolder>(POST_COMPARATOR) {

    companion object {
        val POST_COMPARATOR = object : DiffUtil.ItemCallback<AddressItemBean>() {
            override fun areItemsTheSame(
                oldItem: AddressItemBean,
                newItem: AddressItemBean
            ): Boolean = oldItem.Id == newItem.Id

            override fun areContentsTheSame(
                oldItem: AddressItemBean,
                newItem: AddressItemBean
            ): Boolean = oldItem == newItem
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.user_adapter_address_list_name)
        val mobile = itemView.findViewById<TextView>(R.id.user_adapter_address_list_mobile)
        val info = itemView.findViewById<TextView>(R.id.user_adapter_address_list_info)
        val time = itemView.findViewById<TextView>(R.id.user_adapter_address_list_time)
        val default = itemView.findViewById<View>(R.id.user_adapter_address_list_default)

        fun bindData(item: AddressItemBean) {
            name.text = item.ReceiveName
            mobile.text = item.Mobile
            info.text = (item.Province + item.City + item.County + item.town + item.address)
            time.text = item.AddDate
            if (item.IsDefault) {
                default.visibility = View.VISIBLE
            } else {
                default.visibility = View.GONE
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return AddressAdapter.ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.user_adapter_address_list, parent, false)
        )
    }
}