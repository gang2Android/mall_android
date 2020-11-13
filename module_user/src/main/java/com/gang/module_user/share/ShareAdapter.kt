package com.gang.module_user.share

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.gang.lib_base.ImageLoader
import com.gang.module_user.R
import com.youth.banner.adapter.BannerAdapter

class ShareAdapter(data: MutableList<String>) :
    BannerAdapter<String, ShareAdapter.ShareViewHolder>(data) {

    class ShareViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView? = null

        init {
            imageView = itemView.findViewById(R.id.user_adapter_share_img)
        }

        fun setData(path: String) {
            ImageLoader.load(imageView!!, path)
        }
    }

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): ShareViewHolder {
        val view = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.user_adapter_share, parent, false)
        return ShareViewHolder(view)
    }

    override fun onBindView(holder: ShareViewHolder?, data: String?, position: Int, size: Int) {
        holder?.setData(data!!)
    }

}