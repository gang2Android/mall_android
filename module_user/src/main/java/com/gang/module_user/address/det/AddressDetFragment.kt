package com.gang.module_user.address.det

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.lib_base.LogUtils
import com.gang.lib_base.ToastUtils
import com.gang.module_base.BaseFragment
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.address.AddressItemBean
import com.gang.module_user.databinding.UserFragmentAddressDetBinding

@Route(path = ModuleRouter.USER_ADDRESS_DET)
class AddressDetFragment : BaseFragment() {
    private lateinit var dataBinding: UserFragmentAddressDetBinding
    private lateinit var viewModel: AddressDetViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_address_det, container, false)
        viewModel = ViewModelProvider(this).get(AddressDetViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
    }

    override fun initListener() {
        dataBinding.addressDetTop.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount <= 1) {
                requireActivity().finish()
            } else {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        dataBinding.userAddressDetOk.setOnClickListener {
            viewModel.saveItem()
        }

        viewModel.hint.observe(this, Observer<String> { t ->
            t?.let {
                ToastUtils.show(requireContext(), it)
            }
        })
    }

    override fun initOther() {
        arguments!!.getSerializable("data")?.let {
            val item = it as AddressItemBean
            viewModel.item.postValue(item)
        }
    }
}