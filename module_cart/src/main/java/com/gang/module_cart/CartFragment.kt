package com.gang.module_cart

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
import com.gang.module_base.BaseFragment
import com.gang.module_cart.adapter.CartAdapter
import com.gang.module_cart.databinding.CartFragmentCartBinding
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.CART_INDEX)
class CartFragment : BaseFragment() {
    lateinit var dataBinding: CartFragmentCartBinding
    lateinit var viewModel: CartViewModel

    private var adapter: CartAdapter? = null

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.cart_fragment_cart, container, false)
        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
        dataBinding.cartRv.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun initListener() {
        adapter = CartAdapter()
        dataBinding.cartRv.adapter = adapter

        viewModel.cartData.observe(this, object : Observer<MutableList<CartEntity>> {
            override fun onChanged(data: MutableList<CartEntity>?) {
                LogUtils.print("adapter_data=${adapter!!.itemCount}==data==${data.toString()}")
                data?.let {
                    if (adapter!!.itemCount == 0) {
                        adapter!!.setNewInstance(data)
                    } else {
                        adapter!!.notifyDataSetChanged()
                    }
                }
            }
        })
        adapter?.addChildClickViewIds(
            R.id.cart_adapter_cart_sup_check,
            R.id.cart_adapter_cart_sup_name,
            R.id.cart_adapter_cart_pro_check,
            R.id.cart_adapter_cart_pro_img
        )

        adapter?.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.cart_adapter_cart_sup_check -> {
                    viewModel.selectSup(position)
                }
                R.id.cart_adapter_cart_sup_name -> {
                    viewModel.goStore(position)
                }
                R.id.cart_adapter_cart_pro_check -> {
                    viewModel.selectPro(position)
                }
                R.id.cart_adapter_cart_pro_img -> {
                    viewModel.goPro(position)
                }
            }
        }
        dataBinding.cartBotCheck.setOnClickListener {
            viewModel.selectAll()
        }
        dataBinding.cartOk.setOnClickListener {
            ARouter.getInstance().build(ModuleRouter.ORDER_AFFIRM_ACT).navigation()
        }
    }

    override fun initOther() {
        viewModel.getCartData()
    }

}