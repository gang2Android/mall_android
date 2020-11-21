package com.gang.module_user.account.transfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.lib_base.ToastUtils
import com.gang.module_base.BaseFragment
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.databinding.UserFragmentTransferBinding

@Route(path = ModuleRouter.User.Account.Transfer.FRAGMENT)
class TransferFragment : BaseFragment() {
    private lateinit var dataBinding: UserFragmentTransferBinding
    private lateinit var viewModel: TransferViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_transfer, container, false)
        viewModel = ViewModelProvider(this).get(TransferViewModel::class.java)
        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }

    override fun initView() {
    }

    override fun initListener() {
        dataBinding.transferTop.setOnClickListener { exit() }

        viewModel.hint.observe(this, Observer {
            ToastUtils.show(requireContext(), it)
        })
    }

    override fun initOther() {
        val type = arguments!!.getInt("type")
        val money = arguments!!.getDouble("money")
        viewModel.init(type, money)
    }
}