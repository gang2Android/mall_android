package com.gang.module_order.list

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
import com.gang.lib_base.ToastUtils
import com.gang.module_base.BaseFragment
import com.gang.module_order.R
import com.gang.module_order.databinding.OrderFragmentListBinding
import com.gang.module_order.list.adapter.OrderListAdapter
import com.gang.module_router.ModuleRouter
import com.google.android.material.tabs.TabLayout

@Route(path = ModuleRouter.ORDER_LIST)
class OrderListFragment : BaseFragment() {
    lateinit var dataBinding: OrderFragmentListBinding
    lateinit var viewModel: OrderListViewModel

    private var adapter: OrderListAdapter? = null

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.order_fragment_list, container, false)
        viewModel = ViewModelProvider(this).get(OrderListViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
        dataBinding.orderListRv.layoutManager = LinearLayoutManager(requireContext())

        dataBinding.orderListType.addTab(
            dataBinding.orderListType.newTab().setText("全部").setTag("1")
        )
        dataBinding.orderListType.addTab(
            dataBinding.orderListType.newTab().setText("待付款").setTag("2")
        )
        dataBinding.orderListType.addTab(
            dataBinding.orderListType.newTab().setText("待发货").setTag("3")
        )
        dataBinding.orderListType.addTab(
            dataBinding.orderListType.newTab().setText("待收货").setTag("4")
        )
        dataBinding.orderListType.addTab(
            dataBinding.orderListType.newTab().setText("待评价").setTag("5")
        )
    }

    override fun initListener() {
        adapter = OrderListAdapter()
        dataBinding.orderListRv.adapter = adapter

        dataBinding.orderListType.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab == null) return
                val type = tab.tag ?: return
                viewModel.page = 1
                viewModel.type = type.toString()

                viewModel.getOrderList()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                if (tab == null) return
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                if (tab == null) return
            }
        })

        adapter?.addChildClickViewIds(
            R.id.order_adapter_order_bot_cancel,
            R.id.order_adapter_order_bot_pay,
            R.id.order_adapter_order_bot_call,
            R.id.order_adapter_order_bot_service,
            R.id.order_adapter_order_bot_log,
            R.id.order_adapter_order_bot_affirm,
            R.id.order_adapter_order_bot_access,
            R.id.order_adapter_order_bot_receipt,
            R.id.order_adapter_order_bot_del,
            R.id.order_adapter_order_bot_too
        )
        adapter?.setOnItemChildClickListener { _, view, position ->
            val item = adapter?.getItem(position) ?: return@setOnItemChildClickListener
            when (view.id) {
                R.id.order_adapter_order_bot_cancel -> {
                    ToastUtils.show(requireContext(), "取消订单")
                }
                R.id.order_adapter_order_bot_pay -> {
                    ToastUtils.show(requireContext(), "付款")
                }
                R.id.order_adapter_order_bot_call -> {
                    ToastUtils.show(requireContext(), "催促发货")
                }
                R.id.order_adapter_order_bot_service -> {
                    ToastUtils.show(requireContext(), "申请售后")
                }
                R.id.order_adapter_order_bot_log -> {
                    ToastUtils.show(requireContext(), "查看物流")
                }
                R.id.order_adapter_order_bot_affirm -> {
                    ToastUtils.show(requireContext(), "确认收货")
                }
                R.id.order_adapter_order_bot_access -> {
                    ToastUtils.show(requireContext(), "评价")
                }
                R.id.order_adapter_order_bot_receipt -> {
                    ToastUtils.show(requireContext(), "申请开票")
                }
                R.id.order_adapter_order_bot_del -> {
                    ToastUtils.show(requireContext(), "删除订单")
                }
                R.id.order_adapter_order_bot_too -> {
                    ToastUtils.show(requireContext(), "再次购买")
                }
            }
        }
        adapter?.setOnItemClickListener { _, view, position ->
            val item = adapter?.getItem(position) ?: return@setOnItemClickListener
            var orderNo = ""
            when (item.itemType) {
                OrderEntity.ITEM_SUP -> {
                    orderNo = item.sup!!.innerorderid
                }
                OrderEntity.ITEM_PRO -> {
                    orderNo = item.pro!!.innerorderid
                }
                OrderEntity.ITEM_BOT -> {
                    orderNo = item.bot!!.innerorderid
                }
                else -> {
                    return@setOnItemClickListener
                }
            }
            ARouter.getInstance().build(ModuleRouter.ORDER_DET_ACT)
                .withString("no", orderNo)
                .navigation()
        }

        dataBinding.orderListTop.setOnClickListener {
            if (requireActivity().supportFragmentManager.backStackEntryCount < 1) {
                requireActivity().finish()
            } else {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        dataBinding.orderListRefresh.setOnRefreshListener {
            viewModel.getOrderList()
        }
        viewModel.orderList.observe(this, Observer {
            dataBinding.orderListRefresh.isRefreshing = false
            it?.let {
                adapter?.setNewInstance(it)
            }
        })
    }

    override fun initOther() {
        arguments!!.getInt("type")?.let {
            dataBinding.orderListType.getTabAt(it)!!.select()
            viewModel.getOrderList()
        }
    }

}