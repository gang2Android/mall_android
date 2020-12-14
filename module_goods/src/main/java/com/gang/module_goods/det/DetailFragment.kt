package com.gang.module_goods.det

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseFragment
import com.gang.module_goods.R
import com.gang.module_goods.databinding.GoodsFragmentDetBinding
import com.gang.module_goods.det.adapter.DetailAdapter
import com.gang.module_goods.det.address.AddressFragment
import com.gang.module_goods.det.spec.SpecFragment
import com.gang.module_router.ModuleRouter
import com.google.android.material.tabs.TabLayout

@Route(path = ModuleRouter.Goods.Det.FRAGMENT)
class DetailFragment : BaseFragment() {
    private lateinit var dataBinding: GoodsFragmentDetBinding
    private lateinit var viewModel: DetailViewModel

    private var adapter: DetailAdapter? = null

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
        dataBinding.detRv.layoutManager = LinearLayoutManager(requireContext())
        adapter = DetailAdapter()
        dataBinding.detRv.adapter = adapter
    }

    override fun initListener() {
        dataBinding.detBack.setOnClickListener { exit() }

        dataBinding.detRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val count = getDistance()
                LogUtils.print("dx=${dx},dy=${dy},count=${count}")
                if (count >= 200) {
                    dataBinding.detRegion.visibility = View.VISIBLE
                    dataBinding.detTop.setBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(),
                            android.R.color.white
                        )
                    )
                } else {
                    dataBinding.detRegion.visibility = View.INVISIBLE
                    dataBinding.detTop.setBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(),
                            android.R.color.transparent
                        )
                    )
                }

            }
        })
        dataBinding.detRegion.post {
            setTabLayout(dataBinding.detRegion)
        }
        dataBinding.detRegion.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> {
                        dataBinding.detRv.smoothScrollToPosition(0)
                    }
                    1 -> {
                        dataBinding.detRv.smoothScrollToPosition(3)
                    }
                    2 -> {
                        dataBinding.detRv.smoothScrollToPosition(6)
                    }
                    3 -> {
                        val layoutManager = dataBinding.detRv.layoutManager as LinearLayoutManager
                        val firstItemPosition = layoutManager.findFirstVisibleItemPosition()
                        if (firstItemPosition == 5) {
                            dataBinding.detRv.smoothScrollToPosition(4)
                        } else {
                            dataBinding.detRv.smoothScrollToPosition(5)
                        }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        adapter?.addChildClickViewIds(
            R.id.goods_adapter_det_spec_select,
            R.id.goods_adapter_det_spec_address
        )
        adapter?.setOnItemChildClickListener { _, view, position ->
            when (view.id) {
                R.id.goods_adapter_det_spec_select -> {
                    openSpecSelect()
                }
                R.id.goods_adapter_det_spec_address -> {
                    openAddressSelect()
                }
            }
        }
//        adapter?.setOnItemClickListener { _, _, position ->
//            val item = adapter?.getItem(position) ?: return@setOnItemClickListener
//            when (item.itemType) {
//                DetailEntity.ITEM_BANNER -> {
//                }
//                DetailEntity.ITEM_BASE -> {
//                }
//                DetailEntity.ITEM_SPEC -> {
//
//                }
//                DetailEntity.ITEM_ACCESS -> {
//                }
//                DetailEntity.ITEM_STORE -> {
//                }
//            }
//        }

        viewModel.detailEntity.observe(this, Observer {
            adapter?.setNewInstance(it)
        })

    }

    private fun setTabLayout(tabLayout: TabLayout) {
        val slidingTabIndicatorField =
            tabLayout.javaClass.getDeclaredField("slidingTabIndicator")
        slidingTabIndicatorField.isAccessible = true
        val mTabStrip = slidingTabIndicatorField.get(tabLayout) as LinearLayout
        val width = tabLayout.width / mTabStrip.childCount
        for (i in 0 until mTabStrip.childCount) {
            val tabView = mTabStrip.getChildAt(i)
            val textViewField = tabView.javaClass.getDeclaredField("textView")
            textViewField.isAccessible = true
            tabView.setPadding(0, 0, 0, 0)
            val layoutParams = tabView.layoutParams as LinearLayout.LayoutParams
            layoutParams.width = width
            //                layoutParams.weight = 1f
            tabView.layoutParams = layoutParams
            tabView.invalidate()
        }
    }

    fun getDistance(): Int {
        val layoutManager = dataBinding.detRv.layoutManager as LinearLayoutManager
        val firstVisibleItem = dataBinding.detRv.getChildAt(0)
        val firstItemPosition = layoutManager.findFirstVisibleItemPosition()
        val itemHeight = firstVisibleItem.height
        val firstItemBottom = layoutManager.getDecoratedBottom(firstVisibleItem)
        return (firstItemPosition + 1) * itemHeight - firstItemBottom
    }

    override fun initOther() {
        arguments!!.getString("id")?.let {
            viewModel.getDetail(it)
        }
//        val imgPath = arguments!!.getString("url", "")
//        val name = arguments!!.getString("name", "")

//        requireActivity().window.sharedElementEnterTransition = TransitionSet()
//            .addTransition(ChangeImageTransform())
//            .addTransition(ChangeBounds())
//            .apply {
////                    onEnd {
////                        ImageLoader.load(dataBinding.detImg, "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png")
////                    }
//                val str =
//                    "<img src=\"https://img30.360buyimg.com/sku/jfs/t1/104186/6/674/148330/5db2b8c2E9072e2af/b83a82fd365b84c7.jpg\">";
//                dataBinding.detInfoV.loadData(str, "text/html; charset=UTF-8", null)
//            }
//        requireActivity().window.enterTransition = Fade()
//        requireActivity().postponeEnterTransition()
//        ImageLoader.load(dataBinding.detImg, imgPath)
//        requireActivity().startPostponedEnterTransition()
//        dataBinding.detName.text = name
    }

    private fun openSpecSelect() {
        val ft = requireActivity().supportFragmentManager.beginTransaction()
        val aa = SpecFragment()
        aa.show(ft, "111")
    }

    private fun openAddressSelect() {
        val ft = requireActivity().supportFragmentManager.beginTransaction()
        val aa = AddressFragment()
        aa.show(ft, "111")
    }

}