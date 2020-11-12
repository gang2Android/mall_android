package com.gang.module_order.det

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.lib_base.ToastUtils
import com.gang.module_base.BaseFragment
import com.gang.module_order.R
import com.gang.module_order.databinding.OrderFragmentDetBinding
import com.gang.module_order.det.adapter.OrderDetailAdapter
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.ORDER_DET)
class OrderDetailFragment : BaseFragment() {
    private lateinit var dataBinding: OrderFragmentDetBinding
    private lateinit var viewModel: OrderDetailViewModel

    private var adapter: OrderDetailAdapter? = null

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.order_fragment_det, container, false)
        viewModel = ViewModelProvider(this).get(OrderDetailViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
        dataBinding.orderDetRv.layoutManager = LinearLayoutManager(requireContext())

        adapter = OrderDetailAdapter()
        dataBinding.orderDetRv.adapter = adapter
    }

    override fun initListener() {
        dataBinding.orderDetTop.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount < 1) {
                requireActivity().finish()
            } else {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        dataBinding.orderDetRefresh.setOnRefreshListener {
            viewModel.getOrderDetail()
        }
        viewModel.detailBean.observe(this, Observer {
            it?.let {
                dataBinding.orderDetRefresh.isRefreshing = false
                adapter?.setNewInstance(it)

                when (it[0].statusBean!!.status) {
                    "1" -> {
                        dataBinding.orderAdapterDetActionCancel.visibility = View.VISIBLE
                        dataBinding.orderAdapterDetActionPay.visibility = View.VISIBLE
                    }
                    "2", "3" -> {
                        dataBinding.orderAdapterDetActionCancel.visibility = View.VISIBLE
                        dataBinding.orderAdapterDetActionCall.visibility = View.VISIBLE
                    }
                    "4" -> {
                        dataBinding.orderAdapterDetActionService.visibility = View.VISIBLE
                        dataBinding.orderAdapterDetActionAccess.visibility = View.VISIBLE
                    }
                    "8" -> {
                        dataBinding.orderAdapterDetActionReceipt.visibility = View.VISIBLE
                        dataBinding.orderAdapterDetActionToo.visibility = View.VISIBLE
                    }
                    "10", "15", "20" -> {
                        dataBinding.orderAdapterDetActionDel.visibility = View.VISIBLE
                        dataBinding.orderAdapterDetActionToo.visibility = View.VISIBLE
                    }
                }
            }
        })
        dataBinding.orderAdapterDetActionCancel.setOnClickListener {
            ToastUtils.show(
                requireContext(),
                "取消订单"
            )
        }
        dataBinding.orderAdapterDetActionPay.setOnClickListener {
            ToastUtils.show(
                requireContext(),
                "付款"
            )
        }
        dataBinding.orderAdapterDetActionCancel.setOnClickListener {
            ToastUtils.show(
                requireContext(),
                "催促发货"
            )
        }
        dataBinding.orderAdapterDetActionCall.setOnClickListener {
            ToastUtils.show(
                requireContext(),
                "申请售后"
            )
        }
        dataBinding.orderAdapterDetActionService.setOnClickListener {
            ToastUtils.show(
                requireContext(),
                "查看物流"
            )
        }
        dataBinding.orderAdapterDetActionAccess.setOnClickListener {
            ToastUtils.show(
                requireContext(),
                "确认收货"
            )
        }
        dataBinding.orderAdapterDetActionReceipt.setOnClickListener {
            ToastUtils.show(
                requireContext(),
                "评价"
            )
        }
        dataBinding.orderAdapterDetActionToo.setOnClickListener {
            ToastUtils.show(
                requireContext(),
                "申请开票"
            )
        }
        dataBinding.orderAdapterDetActionDel.setOnClickListener {
            ToastUtils.show(
                requireContext(),
                "删除订单"
            )
        }
        dataBinding.orderAdapterDetActionToo.setOnClickListener {
            ToastUtils.show(
                requireContext(),
                "再次购买"
            )
        }
    }

    override fun initOther() {
        arguments!!.getString("no")?.let {
            viewModel.no.postValue(it)
            viewModel.getOrderDetail()
        }
    }
}