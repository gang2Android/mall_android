package com.gang.lib_base

import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageLoader {
    fun load(img: ImageView, url: String) {
        Glide.with(img.context).load(url).into(img)
    }
}