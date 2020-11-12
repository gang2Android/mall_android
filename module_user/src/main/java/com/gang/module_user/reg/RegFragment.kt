package com.gang.module_user.reg

import android.graphics.Color
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
import com.gang.module_user.databinding.UserFragmentRegBinding

@Route(path = ModuleRouter.USER_REG)
class RegFragment : BaseFragment() {
    private lateinit var dataBinding: UserFragmentRegBinding
    private lateinit var viewModel: RegViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_reg, container, false)
        viewModel = ViewModelProvider(this).get(RegViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
        StatusBarUtils.setColor(requireActivity(), Color.parseColor("#efefef"))
    }

    override fun initListener() {
        dataBinding.userRegClose.setOnClickListener {
            requireActivity().finish()
        }
        dataBinding.userRegGet.setOnClickListener {
            viewModel.getCode()
        }
        dataBinding.userRegOk.setOnClickListener {
            viewModel.reg()
        }
    }

    override fun initOther() {
    }
}