package com.gang.module_goods.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseFragment
import com.gang.module_goods.R
import com.gang.module_goods.databinding.GoodsFragmentSearchBinding
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.Goods.Search.FRAGMENT)
class SearchFragment : BaseFragment() {
    private lateinit var dataBinding: GoodsFragmentSearchBinding
    private lateinit var viewModel: SearchViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.goods_fragment_search, container, false)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }

    override fun initView() {

    }

    override fun initListener() {
        dataBinding.searchBack.setOnClickListener { exit() }
        dataBinding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    goList(it)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchKey.postValue(newText)
                return true
            }
        })
        dataBinding.searchAffirm.setOnClickListener {
            if (viewModel.searchKey.value == null || viewModel.searchKey.value == "")
                return@setOnClickListener
            goList(viewModel.searchKey.value!!)
        }
    }

    override fun initOther() {
    }

    fun goList(searchKey: String) {
        ARouter.getInstance().build(ModuleRouter.Goods.List.ACTIVITY)
            .withString("key", searchKey)
            .navigation()
    }
}