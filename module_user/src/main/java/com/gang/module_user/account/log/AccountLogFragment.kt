package com.gang.module_user.account.log

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.module_base.BaseFragment
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.databinding.UserFragmentAccountLogBinding

@Route(path = ModuleRouter.User.Account.LOG.FRAGMENT)
class AccountLogFragment : BaseFragment() {
    private lateinit var dataBinding: UserFragmentAccountLogBinding
    private lateinit var viewModel: AccountLogViewModel

    private var adapter: AccountLogAdapter? = null

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_account_log, container, false)
        viewModel = ViewModelProvider(this).get(AccountLogViewModel::class.java)
        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }

    override fun initView() {
        dataBinding.accountLogRv.layoutManager = LinearLayoutManager(requireContext())

        adapter = AccountLogAdapter()
        dataBinding.accountLogRv.adapter = adapter
    }

    override fun initListener() {
        dataBinding.accountLogTop.setOnClickListener { exit() }
        dataBinding.accountLogRefresh.setOnRefreshListener {
            viewModel.getData()
        }

        viewModel.accountLogList.observe(this, Observer {
            dataBinding.accountLogRefresh.isRefreshing = false
            if (viewModel.page == 1)
                adapter?.setNewInstance(it)
            else
                adapter?.addData(it)
        })
    }

    override fun initOther() {
        arguments!!.getInt("type").let {
            viewModel.setType(it)
            viewModel.getData()
        }
    }
}