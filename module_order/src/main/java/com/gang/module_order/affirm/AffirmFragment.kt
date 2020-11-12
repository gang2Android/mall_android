package com.gang.module_order.affirm

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
import com.gang.lib_base.LogUtils
import com.gang.lib_base.ToastUtils
import com.gang.module_base.BaseFragment
import com.gang.module_order.R
import com.gang.module_order.affirm.adapter.AffirmAdapter
import com.gang.module_order.databinding.OrderFragmentAffirmBinding
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.ORDER_AFFIRM)
class AffirmFragment : BaseFragment() {
    private lateinit var dataBinding: OrderFragmentAffirmBinding
    private lateinit var viewModel: AffirmViewModel

    private var adapter: AffirmAdapter? = null

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.order_fragment_affirm, container, false)
        viewModel = ViewModelProvider(this).get(AffirmViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
        dataBinding.affirmRv.layoutManager = LinearLayoutManager(requireContext())

        adapter = AffirmAdapter()
        dataBinding.affirmRv.adapter = adapter
    }

    override fun initListener() {
        dataBinding.affirmTop.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount < 1) {
                requireActivity().finish()
            } else {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        dataBinding.affirmPay.setOnClickListener {
            ARouter.getInstance().build(ModuleRouter.ORDER_PAY_ACT)
                .withString("no", "123123123")
                .navigation()
            requireActivity().finish()
        }
        dataBinding.affirmRefresh.setOnRefreshListener {
            viewModel.getAffirmOfCart()
        }
        adapter?.setOnItemClickListener { _, _, position ->
            if (position != 0) return@setOnItemClickListener

            ARouter.getInstance().build(ModuleRouter.USER_ADDRESS_LIST_ACTIVITY)
                .withBoolean("isSelect", true)
                .navigation(requireActivity(), 1001)
        }

        viewModel.affirmData.observe(this, Observer { data ->
            data?.let {
                dataBinding.affirmRefresh.isRefreshing = false
                adapter?.setNewInstance(it)
                adapter?.notifyDataSetChanged()
            }
        })
    }

    override fun initOther() {
        arguments!!.getString("ids")?.let {
            viewModel.cartIds.postValue(it)
            viewModel.getAffirmOfCart()
        }
    }

    fun setAddress(item: String) {
        viewModel.updateAddress(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) return
        when (requestCode) {
            1001 -> {
                LogUtils.print(data!!.getStringExtra("data").toString())
            }
        }
    }

}