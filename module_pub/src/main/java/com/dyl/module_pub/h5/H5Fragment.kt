package com.dyl.module_pub.h5

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.dyl.module_pub.R
import com.dyl.module_pub.databinding.PubFragmentH5Binding
import com.gang.lib_base.AppUtils
import com.gang.lib_base.ToastUtils
import com.gang.module_base.BaseFragment
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.Pub.H5.FRAGMENT)
class H5Fragment : BaseFragment() {
    private lateinit var dataBinding: PubFragmentH5Binding

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.pub_fragment_h5, container, false)
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }

    override fun initView() {
        dataBinding.h5Top.setNavigationOnClickListener { exit() }
        val settings = dataBinding.h5Web.settings
        settings.javaScriptEnabled = true
    }

    override fun initListener() {
        dataBinding.h5Web.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                val title = view?.title
                dataBinding.h5Top.title = title
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }
        }
        dataBinding.h5Web.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
            }
        }
        dataBinding.h5Top.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_refresh -> {
                    dataBinding.h5Web.reload()
                }
                R.id.action_copy -> {
                    val url = dataBinding.h5Web.url
                    AppUtils.copyText(requireContext(), url)
                    ToastUtils.show(requireContext(), "已复制到剪贴板中")
                }
                R.id.action_open -> {
                    val url = dataBinding.h5Web.url
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                }
            }
            return@setOnMenuItemClickListener true
        }
    }

    override fun initOther() {
        val url = arguments!!.getString("url", "")
        if (url == "") {
            exit()
            return
        }
        if (!url.startsWith("http")) {
            exit()
            return
        }
        dataBinding.h5Web.loadUrl(url)
    }

}