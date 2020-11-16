package com.gang.module_user.pwd

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
import com.gang.module_user.databinding.UserFragmentPwdBinding

@Route(path = ModuleRouter.USER_PWD)
class PwdFragment : BaseFragment() {
    private lateinit var dataBinding: UserFragmentPwdBinding
    private lateinit var viewModel: PwdViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_pwd, container, false)
        viewModel = ViewModelProvider(this).get(PwdViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
    }

    override fun initListener() {
        dataBinding.pwdTop.setOnClickListener { exit() }
    }

    override fun initOther() {
        arguments!!.getBoolean("isLogin").let {
            if (it) {
                dataBinding.pwdTop.title = "修改登录密码"
            } else {
                dataBinding.pwdTop.title = "修改支付密码"
            }
        }
    }
}