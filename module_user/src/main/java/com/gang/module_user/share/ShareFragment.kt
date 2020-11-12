package com.gang.module_user.share

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.module_base.BaseFragment
import com.gang.module_base.StatusBarUtils
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.databinding.UserFragmentShareBinding

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
//        StatusBarUtils.setTranslucentForCoordinatorLayout(requireActivity(), 100)
    }

    override fun initListener() {
        dataBinding.shareTop.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount < 1) {
                requireActivity().finish()
            } else {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

    }

    override fun initOther() {
    }

}