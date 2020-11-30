package com.gang.module_user.login

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.DataUtils
import com.gang.lib_base.ToastUtils
import com.gang.module_base.BaseFragment
import com.gang.module_base.StatusBarUtils
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.databinding.UserFragmentLoginBinding
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

@Route(path = ModuleRouter.USER_LOGIN)
class LoginFragment : BaseFragment() {
    lateinit var dataBinding: UserFragmentLoginBinding
    lateinit var viewModel: LoginViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_login, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
        StatusBarUtils.setColor(requireActivity(), Color.parseColor("#efefef"))
    }

    override fun initListener() {
        viewModel.hint.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                t?.let {
                    ToastUtils.show(requireContext(), it)
                }
            }
        })
        dataBinding.userLoginClose.setOnClickListener {
            requireActivity().finish()
        }
        dataBinding.userLoginReg.setOnClickListener {
            ARouter.getInstance().build(ModuleRouter.USER_REG_ACTIVITY).navigation()
        }
        dataBinding.userLoginOk.setOnClickListener {
            viewModel.login()
        }
    }

    override fun initOther() {
    }
}