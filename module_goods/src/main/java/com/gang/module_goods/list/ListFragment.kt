package com.gang.module_goods.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.ToastUtils
import com.gang.module_base.BaseFragment
import com.gang.module_base.widget.MyDecoration
import com.gang.module_goods.R
import com.gang.module_goods.databinding.GoodsFragmentListBinding
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.Goods.List.FRAGMENT)
class ListFragment : BaseFragment() {
    private lateinit var dataBinding: GoodsFragmentListBinding
    private lateinit var viewModel: ListViewModel

    private var adapter: ListAdapter? = null

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.goods_fragment_list, container, false)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }

    override fun initView() {
        dataBinding.listRv.layoutManager = GridLayoutManager(requireContext(), 2)
        val decoration = MyDecoration()
        decoration.setSpace(10)
        dataBinding.listRv.addItemDecoration(decoration)

        adapter = ListAdapter()
        dataBinding.listRv.adapter = adapter
    }

    override fun initListener() {
        dataBinding.listBack.setOnClickListener { exit() }
        dataBinding.listKey.setOnClickListener { exit() }
        dataBinding.listMore.setOnClickListener { ToastUtils.show(requireContext(), "more") }

        dataBinding.listRefresh.setOnRefreshListener {
            viewModel.getData()
        }

        adapter?.setOnItemClickListener { _, _, position ->
            val item = adapter?.getItem(position) ?: return@setOnItemClickListener
            ARouter.getInstance().build(ModuleRouter.Goods.Det.ACTIVITY)
                .withString("id", item.proid)
                .navigation()
        }

        viewModel.listData.observe(this, Observer {
            dataBinding.listRefresh.isRefreshing = false
            if (viewModel.page == 1)
                adapter?.setNewInstance(it)
            else
                adapter?.addData(it)
        })
    }

    override fun initOther() {
        arguments?.getString("key")?.let {
            viewModel.key.postValue(it)
        }
        viewModel.getData()
    }

}