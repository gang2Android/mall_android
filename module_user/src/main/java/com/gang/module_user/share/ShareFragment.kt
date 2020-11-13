package com.gang.module_user.share

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.lib_base.ImageLoader
import com.gang.lib_base.ToastUtils
import com.gang.module_base.BaseFragment
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.databinding.UserFragmentShareBinding
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder

@Route(path = ModuleRouter.USER_SHARE)
class ShareFragment : BaseFragment() {
    private lateinit var dataBinding: UserFragmentShareBinding
    private lateinit var viewModel: ShareViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_share, container, false)
        viewModel = ViewModelProvider(this).get(ShareViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
        val data = mutableListOf<String>()
        data.add("http://sdd-shop.oss-cn-shenzhen.aliyuncs.com/share.png")
        data.add("http://jl-wg-chain.oss-cn-shenzhen.aliyuncs.com/ad/1257f202007031338561049.jpg")
        data.add("http://jl-wg-chain.oss-cn-shenzhen.aliyuncs.com/ad/c2154202009111601491115.jpg")
        dataBinding.shareContent.adapter = ShareAdapter(data)
        dataBinding.shareContent.isAutoLoop(false)
        dataBinding.shareContent.addBannerLifecycleObserver(this)
        dataBinding.shareContent.setIndicator(dataBinding.shareIndicator, false)
        dataBinding.shareContent.setIndicatorSelectedWidth(20)
        dataBinding.shareContent.setIndicatorNormalColorRes(R.color.colorPrimary)
        dataBinding.shareContent.setIndicatorSelectedColorRes(R.color.colorAccent)
    }

    override fun initListener() {
        dataBinding.shareTop.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount < 1) {
                requireActivity().finish()
            } else {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        dataBinding.shareBotWx.setOnClickListener {
            ToastUtils.show(requireContext(), "微信")
        }
        dataBinding.shareBotChat.setOnClickListener {
            ToastUtils.show(requireContext(), "朋友圈")
        }
        dataBinding.shareBotPic.setOnClickListener {
            ToastUtils.show(requireContext(), "保存图片")
        }

    }

    override fun initOther() {
    }

}