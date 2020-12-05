package com.gang.lib_base

import android.widget.ImageView
//import coil.load
import com.bumptech.glide.Glide

object ImageLoader {
    fun load(img: ImageView, url: String) {
        Glide.with(img.context).load(url).into(img)
//        img.load(url)
    }

    fun load(img: ImageView, url: String, placeId: Int) {
        Glide.with(img.context).load(url).placeholder(placeId).into(img)
//        img.load(url) {
//            placeholder(placeId)
//        }
    }

//    fun load(context: Context, img: ImageView, url: String) {
////        Glide.with(img.context).load(url).into(img)
//    }
}