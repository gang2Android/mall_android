package com.gang.module_user.set

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.module_base.BaseFragment
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.databinding.UserFragmentSetBinding

@Route(path = ModuleRouter.USER_SET)
class SetFragment : BaseFragment() {
    private lateinit var dataBinding: UserFragmentSetBinding
    private lateinit var viewModel: SetViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_set, container, false)
        viewModel = ViewModelProvider(this).get(SetViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
        dataBinding.setTop.setOnClickListener {
            exit()
        }
    }

    override fun initListener() {
    }

    override fun initOther() {
    }
}