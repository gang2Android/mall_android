package com.gang.module_goods.list

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.LogUtils
import com.gang.lib_base.ToastUtils
import com.gang.module_base.BaseFragment
import com.gang.module_base.widget.MyDecoration
import com.gang.module_goods.R
import com.gang.module_goods.databinding.GoodsFragmentListBinding
import com.gang.module_goods.det.DetailActivity
import com.gang.module_router.ModuleRouter
import com.google.android.material.tabs.TabLayout

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

        adapter = ListAdapter(requireContext())
        dataBinding.listRv.adapter = adapter
    }

    override fun initListener() {
        dataBinding.listBack.setOnClickListener { exit() }
        dataBinding.listKey.setOnClickListener {
            if (viewModel.key.value.toString() == "请输入关键词") {
                ARouter.getInstance().build(ModuleRouter.Goods.Search.ACTIVITY).navigation()
            }
            exit()
        }
        dataBinding.listMore.setOnClickListener { ToastUtils.show(requireContext(), "more") }

        dataBinding.listRegion.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab ?: return
                ToastUtils.show(requireContext(), "region=" + tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        dataBinding.listFilterSort.setOnClickListener {
            dataBinding.listFilterSort.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    android.R.color.holo_red_dark
                )
            )
            dataBinding.listFilterSal.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    android.R.color.black
                )
            )
        }
        dataBinding.listFilterSal.setOnClickListener {
            dataBinding.listFilterSort.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    android.R.color.black
                )
            )
            dataBinding.listFilterSal.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    android.R.color.holo_red_dark
                )
            )
        }
        dataBinding.listFilterGrid.setOnClickListener {
            ToastUtils.show(requireContext(), "切换layout")
//            dataBinding.listRv.layoutManager = LinearLayoutManager(requireContext())
        }
        dataBinding.listFilter.setOnClickListener {
            ToastUtils.show(requireContext(), "筛选")
        }

        dataBinding.listRefresh.setOnRefreshListener {
            viewModel.getData()
        }

        adapter?.setOnItemClickListener { _, view, position ->
            val item = adapter?.getItem(position) ?: return@setOnItemClickListener
//            ARouter.getInstance().build(ModuleRouter.Goods.Det.ACTIVITY)
//                .withString("id", item.proid)
//                .navigation()

            val imgView = adapter?.getViewByPosition(position,R.id.goods_adapter_list_img)

            val intent = Intent(requireContext(),DetailActivity::class.java)
            intent.putExtra("id", item.proid)
            intent.putExtra("url",item.img)
            val options = ActivityOptions.makeSceneTransitionAnimation(
                requireActivity(),imgView,"img"
            )
            requireContext().startActivity(intent,options.toBundle())

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
            if (it == "")
                return@let
            viewModel.key.postValue(it)
        }
        arguments?.getInt("region")?.let {
            viewModel.region.postValue(it)

            dataBinding.listRegion.getTabAt(it)?.select()

        }
        viewModel.getData()
    }

}