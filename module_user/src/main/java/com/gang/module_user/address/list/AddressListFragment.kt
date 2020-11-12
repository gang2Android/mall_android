package com.gang.module_user.address.list

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseFragment
import com.gang.module_base.widget.MyDecoration
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.address.AddressActivity
import com.gang.module_user.address.AddressItemBean
import com.gang.module_user.databinding.UserFragmentAddressListBinding
import com.google.gson.Gson

@Route(path = ModuleRouter.USER_ADDRESS_LIST)
class AddressListFragment : BaseFragment() {
    private lateinit var dataBinding: UserFragmentAddressListBinding
    private lateinit var viewModel: AddressListViewModel

    private var adapter: AddressAdapter? = null

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_address_list, container, false)
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

        adapter?.addChildClickViewIds(R.id.user_adapter_address_list_edit)
        adapter?.setOnItemChildClickListener { _, view, position ->
            when (view.id) {
                R.id.user_adapter_address_list_edit -> {
                    val item = adapter!!.getItem(position)

                    ARouter.getInstance().build(ModuleRouter.USER_ADDRESS_DET_ACTIVITY)
                        .withSerializable("data", item).navigation()
                }
            }
        }
        adapter?.setOnItemClickListener { _, _, position ->
            if (!viewModel.isSelect) return@setOnItemClickListener

            val dataIntent = Intent()
            val item = adapter!!.getItem(position)
            val gson = Gson()
            val data = gson.toJson(item)!!
            dataIntent.putExtra("data", data)

            (requireActivity() as AddressActivity).exit(Activity.RESULT_OK, dataIntent)
        }
        dataBinding.addressListTop.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount <= 1) {
                requireActivity().finish()
            } else {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        dataBinding.addressListRefresh.setOnRefreshListener {
            viewModel.getAddressList()
        }
        dataBinding.addressListAdd.setOnClickListener {
            ARouter.getInstance().build(ModuleRouter.USER_ADDRESS_DET_ACTIVITY)
                .navigation()
        }

        viewModel.addressBean.observe(this,
            Observer<MutableList<AddressItemBean>> { t ->
                t?.let {
                    adapter?.setNewInstance(it)
                }
            })
    }

    override fun initOther() {
        arguments!!.getBoolean("isSelect").let {
            viewModel.isSelect = it
        }
        viewModel.getAddressList()
    }
}