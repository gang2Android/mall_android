package com.gang.module_goods.det.adapter

import android.webkit.WebView
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gang.module_goods.R
import com.gang.module_goods.det.DetailEntity

class DetailInfoProvider : BaseItemProvider<DetailEntity>() {
    override val itemViewType: Int
        get() = DetailEntity.ITEM_INFO
    override val layoutId: Int
        get() = R.layout.goods_adapter_det_info

    override fun convert(helper: BaseViewHolder, item: DetailEntity) {
        val webView = helper.getView<WebView>(R.id.goods_adapter_det_info)
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true

        // <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
        val str =
                    "<style>" +
                    "img{width:100%;height:auto;}" +
                    "</style>" +
                    "<img src=\"https://img30.360buyimg.com/sku/jfs/t1/104186/6/674/148330/5db2b8c2E9072e2af/b83a82fd365b84c7.jpg\">";
        webView.loadData(str, "text/html; charset=UTF-8", null)
    }
}