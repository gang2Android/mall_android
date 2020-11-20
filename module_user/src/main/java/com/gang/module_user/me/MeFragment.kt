package com.gang.module_user.me

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseFragment
import com.gang.module_base.StatusBarUtils
import com.gang.module_base.widget.MyDecoration
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.databinding.UserFragmentMeBinding
import com.gang.module_user.me.adapter.MeAdapter

@Route(path = ModuleRouter.USER_ME)
class MeFragment : BaseFragment() {
    lateinit var dataBinding: UserFragmentMeBinding
    lateinit var viewModel: MeViewModel

    private var adapter: MeAdapter? = null

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_fragment_me, container, false)
        viewModel = ViewModelProvider(this).get(MeViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
        dataBinding.userMeRv.layoutManager = GridLayoutManager(requireContext(), 2)
        val decoration = MyDecoration()
        decoration.setSpace(20)
        dataBinding.userMeRv.addItemDecoration(decoration)
    }

    override fun initListener() {
        adapter = MeAdapter()
        dataBinding.userMeRv.adapter = adapter

        adapter?.addChildClickViewIds(
            R.id.user_adapter_me_top_img,
            R.id.user_adapter_me_account_balance,
            R.id.user_adapter_me_account_integral,
            R.id.user_adapter_me_account_service,
            R.id.user_adapter_me_top_set,
            R.id.user_adapter_me_order_more,
            R.id.user_adapter_me_order_pay,
            R.id.user_adapter_me_order_send,
            R.id.user_adapter_me_order_affirm,
            R.id.user_adapter_me_order_access,
            R.id.user_adapter_me_order_service
        )
        adapter?.setOnItemChildClickListener { adapter, view, position ->
            var type = 0
            when (view.id) {
                R.id.user_adapter_me_top_img -> {
                    ARouter.getInstance().build(ModuleRouter.USER_LOGIN_ACTIVITY).navigation()
                    return@setOnItemChildClickListener
                }
                R.id.user_adapter_me_account_balance -> {
                    ARouter.getInstance().build(ModuleRouter.USER_ACCOUNT_ACT)
                        .withInt("type", 1).navigation()
                    return@setOnItemChildClickListener
                }
                R.id.user_adapter_me_account_integral -> {
                    ARouter.getInstance().build(ModuleRouter.USER_ACCOUNT_ACT)
                        .withInt("type", 2).navigation()
                    return@setOnItemChildClickListener
                }
                R.id.user_adapter_me_account_service -> {
                    ARouter.getInstance().build(ModuleRouter.USER_ACCOUNT_ACT)
                        .withInt("type", 3).navigation()
                    return@setOnItemChildClickListener
                }
                R.id.user_adapter_me_order_more -> {
                    type = 0
                }
                R.id.user_adapter_me_order_pay -> {
                    type = 1
                }
                R.id.user_adapter_me_order_send -> {
                    type = 2
                }
                R.id.user_adapter_me_order_affirm -> {
                    type = 3
                }
                R.id.user_adapter_me_order_access -> {
                    type = 4
                }
                R.id.user_adapter_me_order_service -> {
                    type = 5
                }
                R.id.user_adapter_me_top_set -> {
                    ARouter.getInstance().build(ModuleRouter.USER_SET_ACT).navigation()
                    return@setOnItemChildClickListener
                }
                else -> {
                    return@setOnItemChildClickListener
                }
            }
            if (type == 5) {
                // TODO
            } else {
                ARouter.getInstance().build(ModuleRouter.ORDER_LIST_ACT)
                    .withInt("type", type)
                    .navigation()
            }
        }

        viewModel.meData.observe(this, object : Observer<MutableList<MeEntity>> {
            override fun onChanged(data: MutableList<MeEntity>?) {
                LogUtils.print("data=${data}")
                LogUtils.print("adapter=${adapter!!.itemCount}")
                data?.let {
                    adapter?.setNewInstance(it)
                }
            }
        })
    }

    override fun initOther() {
        viewModel.getUserInfo()
    }

}