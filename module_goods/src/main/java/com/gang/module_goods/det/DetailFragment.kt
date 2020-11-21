package com.gang.module_goods.det

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.module_base.BaseFragment
import com.gang.module_goods.R
import com.gang.module_goods.databinding.GoodsFragmentDetBinding
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.Goods.Det.FRAGMENT)
class DetailFragment : BaseFragment() {
    private lateinit var dataBinding: GoodsFragmentDetBinding
    private lateinit var viewModel: DetailViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.goods_fragment_det, container, false)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }

    override fun initView() {
    }

    override fun initListener() {
        dataBinding.detTop.setOnClickListener { exit() }
    }

    override fun initOther() {
        arguments!!.getString("id")?.let {
            viewModel.getDetail(it)
        }
    }

}