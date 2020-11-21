package com.gang.module_user.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseFragment
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.databinding.UserFragmentAccountBinding

@Route(path = ModuleRouter.User.Account.FRAGMENT)
class AccountFragment : BaseFragment() {
    private lateinit var dataBinding: UserFragmentAccountBinding
    private lateinit var viewModel: AccountViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_account, container, false)
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {

    }

    override fun initListener() {
        dataBinding.accountTop.setOnClickListener {
            exit()
        }
        dataBinding.accountTransfer.setOnClickListener {
            viewModel.type.value?.let { it1 ->
                ARouter.getInstance().build(ModuleRouter.User.Account.Transfer.ACTIVITY)
                    .withInt("type", it1)
                    .withDouble("money", viewModel.money.value!!)
                    .navigation()
            }
        }
        dataBinding.accountWithdraw.setOnClickListener {
            viewModel.type.value?.let { it1 ->
                ARouter.getInstance().build(ModuleRouter.User.Account.Withdraw.ACTIVITY)
                    .withInt("type", it1)
                    .withDouble("money", viewModel.money.value!!)
                    .navigation()
            }
        }
    }

    override fun initOther() {
        arguments!!.getInt("type").let {
            viewModel.setType(it)
        }
    }

}