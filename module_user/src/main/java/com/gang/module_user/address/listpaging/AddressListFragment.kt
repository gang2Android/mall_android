package com.gang.module_user.address.listpaging

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseFragment
import com.gang.module_base.widget.MyDecoration
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.databinding.UserFragmentAddressListpagingBinding
import kotlinx.coroutines.flow.collectLatest

@Route(path = ModuleRouter.USER_ADDRESS_LIST_PAGING)
class AddressListFragment : BaseFragment() {
    private lateinit var dataBinding: UserFragmentAddressListpagingBinding
    private lateinit var viewModel: AddressListViewModel

    private var adapter: AddressAdapter? = null

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_address_listpaging, container, false)
        viewModel = ViewModelProvider(this).get(AddressListViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
        dataBinding.addressListRv.layoutManager = LinearLayoutManager(requireContext())
        val decoration = MyDecoration()
        decoration.setSpace(20)
        dataBinding.addressListRv.addItemDecoration(decoration)
    }

    override fun initListener() {
        adapter = AddressAdapter()
        dataBinding.addressListRv.adapter = adapter

        dataBinding.addressListTop.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount <= 1) {
                requireActivity().finish()
            } else {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        dataBinding.addressListRefresh.setOnRefreshListener {
            adapter?.refresh()
        }
        dataBinding.addressListAdd.setOnClickListener {
            ARouter.getInstance().build(ModuleRouter.USER_ADDRESS_DET_ACTIVITY)
                .navigation()
        }
    }

    override fun initOther() {
        arguments!!.getBoolean("isSelect").let {
            viewModel.isSelect = it
        }
        viewModel.getAddressData().observe(this, Observer {
            lifecycleScope.launchWhenCreated {
                adapter?.submitData(it)
            }
        })
        lifecycleScope.launchWhenCreated {
            adapter?.loadStateFlow?.collectLatest {
                if (it.refresh !is LoadState.Loading) {
                    dataBinding.addressListRefresh.isRefreshing = false
                }
            }
        }
    }
}