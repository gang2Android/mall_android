package com.gang.component_order.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseFragment
import com.gang.component_order.R
import com.gang.component_order.databinding.OrderFragmentPayBinding
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.ORDER_PAY)
class PayFragment : BaseFragment() {
    private lateinit var dataBinding: OrderFragmentPayBinding
    private lateinit var viewModel: PayViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.order_fragment_pay, container, false)
        viewModel = ViewModelProvider(this).get(PayViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
    }

    override fun initListener() {
        dataBinding.orderPayTop.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount < 1) {
                requireActivity().finish()
            } else {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        dataBinding.orderPayTemp6.setOnClickListener {
            dataBinding.orderPayPayBalance.isChecked = !dataBinding.orderPayPayBalance.isChecked
        }
        dataBinding.orderPayPay.setOnClickListener {
            ARouter.getInstance().build(ModuleRouter.ORDER_LIST_ACT).navigation()
            requireActivity().finish()
        }

        viewModel.payBean.observe(this, Observer {
            it?.let {
                dataBinding.orderPayNo.text = it.no
                dataBinding.orderPayFright.text = it.fright
                dataBinding.orderPayPrice.text = it.price
            }
        })
    }

    override fun initOther() {
        arguments!!.getString("no")?.let {
            viewModel.no = it

            viewModel.getOrderPayInfo()
        }
    }
}