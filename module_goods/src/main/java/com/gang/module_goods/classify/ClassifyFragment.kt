package com.gang.module_goods.classify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseFragment
import com.gang.module_goods.R
import com.gang.module_goods.databinding.GoodsFragmentClassifyBinding
import com.gang.module_router.ModuleRouter


@Route(path = ModuleRouter.GOODS_CLASSIFY)
class ClassifyFragment : BaseFragment() {
    private lateinit var dataBinding: GoodsFragmentClassifyBinding
    private lateinit var viewModel: ClassifyViewModel

    private var leftAdapter: ClassifyLeftAdapter? = null
    private var rightAdapter: ClassifyRightAdapter? = null

    private var upPosition = 0;

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.goods_fragment_classify, container, false)
        viewModel = ViewModelProvider(this).get(ClassifyViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
        dataBinding.goodsClassifyLeft.layoutManager = LinearLayoutManager(requireContext())
        dataBinding.goodsClassifyRight.layoutManager = LinearLayoutManager(requireContext())

        dataBinding.goodsClassifyLeft.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun initListener() {
        leftAdapter = ClassifyLeftAdapter()
        rightAdapter = ClassifyRightAdapter()
        dataBinding.goodsClassifyLeft.adapter = leftAdapter
        dataBinding.goodsClassifyRight.adapter = rightAdapter

        leftAdapter!!.setOnItemClickListener { adapter, view, position ->
            LogUtils.print("p=$position")

            if (position == upPosition) {
                return@setOnItemClickListener
            }

            val itemData = leftAdapter!!.getItem(position)
            itemData.isChecked = true
            leftAdapter!!.setData(position, itemData)

            val upItem = leftAdapter!!.getItem(upPosition)
            upItem.isChecked = false
            leftAdapter!!.setData(upPosition, upItem)

            upPosition = position

            rightAdapter!!.setNewInstance(itemData.children)
        }

        viewModel.classifyData.observe(this,
            Observer<MutableList<ClassifyBean>> { data ->
                leftAdapter!!.setNewInstance(data)
                rightAdapter!!.setNewInstance(data!![0].children)
            })
    }

    override fun initOther() {
        viewModel.getClassifyData()
    }

}