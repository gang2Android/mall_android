package com.gang.module_home

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
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseFragment
import com.gang.module_base.widget.MyDecoration
import com.gang.module_home.adapter.HomeAdapter
import com.gang.module_home.databinding.HomeFragmentHomeBinding
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.HOME_INDEX)
class HomeFragment : BaseFragment() {
    private lateinit var dataBinding: HomeFragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    private var adapter: HomeAdapter? = null

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.home_fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        dataBinding.lifecycleOwner = this
        dataBinding.vm = viewModel

        return dataBinding.root
    }

    override fun initView() {
        dataBinding.homeRv.layoutManager = GridLayoutManager(requireContext(), 2)
        val decoration = MyDecoration()
        decoration.setSpace(10)
        dataBinding.homeRv.addItemDecoration(decoration)
    }

    override fun initListener() {
        adapter = HomeAdapter()
        dataBinding.homeRv.adapter = adapter

        dataBinding.homeSearch.setOnClickListener {
            ARouter.getInstance().build(ModuleRouter.Goods.Search.ACTIVITY).navigation()
        }
        viewModel.homeEntity.observe(this, object : Observer<MutableList<HomeEntity>> {
            override fun onChanged(t: MutableList<HomeEntity>?) {
                LogUtils.print(t?.size.toString())

                adapter?.setNewInstance(t)
            }
        })
    }

    override fun initOther() {
        viewModel.getHomeData()

    }

}