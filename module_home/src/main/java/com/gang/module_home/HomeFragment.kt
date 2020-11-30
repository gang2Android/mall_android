package com.gang.module_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
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
        adapter?.addChildClickViewIds(
            R.id.home_adapter_block_0,
            R.id.home_adapter_block_1,
            R.id.home_adapter_block_2,
            R.id.home_adapter_guanggao_0,
            R.id.home_adapter_guanggao_1,
            R.id.home_adapter_guanggao_2,
            R.id.home_adapter_guanggao_3
        )
        adapter?.setOnItemChildClickListener { _, view, position ->
            val item = adapter?.getItem(position) ?: return@setOnItemChildClickListener
            when (item.itemType) {
                HomeEntity.ITEM_GUANGGAO -> {
                    guanggaoClick(view, item.guanggaoBanner!!)
                }
                HomeEntity.ITEM_BLOCK -> {
                    blockClick(view, item.qukuaiconfig!!)
                }
            }
        }
        adapter?.setOnItemClickListener { _, _, position ->
            val item = adapter?.getItem(position) ?: return@setOnItemClickListener
            when (item.itemType) {
                HomeEntity.ITEM_PRO -> {
                    val proItem = item.list ?: return@setOnItemClickListener
                    val imgView =
                        adapter?.getViewByPosition(position, R.id.home_adapter_home_pro_img)
                    val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        requireActivity(), imgView!!, "img"
                    )
                    ARouter.getInstance().build(ModuleRouter.Goods.Det.ACTIVITY)
                        .withString("id", proItem.proid)
                        .withString("url", proItem.img)
                        .withString("name", proItem.proname)
                        .withOptionsCompat(optionsCompat)
                        .navigation(requireActivity())
                }
            }
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

    fun guanggaoClick(view: View, item: List<HomeBean.HomeBannerBean>) {
        when (view.id) {
            R.id.home_adapter_guanggao_0 -> {
                var type = item[0].poster_url

                type = "1"
                ARouter.getInstance().build(ModuleRouter.Goods.List.ACTIVITY)
                    .withInt("region", type.toInt())
                    .navigation()
            }
            R.id.home_adapter_guanggao_1 -> {
                var type = item[1].poster_url

                type = "2"
                ARouter.getInstance().build(ModuleRouter.Goods.List.ACTIVITY)
                    .withInt("region", type.toInt())
                    .navigation()
            }
            R.id.home_adapter_guanggao_2 -> {
                var type = item[2].poster_url

                type = "3"
                ARouter.getInstance().build(ModuleRouter.Goods.List.ACTIVITY)
                    .withInt("region", type.toInt())
                    .navigation()
            }
            R.id.home_adapter_guanggao_3 -> {
                var type = item[3].poster_url

                type = "4"
                ARouter.getInstance().build(ModuleRouter.Goods.List.ACTIVITY)
                    .withInt("region", type.toInt())
                    .navigation()
            }
        }
    }

    fun blockClick(view: View, item: HomeBean.HomeBlackBean) {
        when (view.id) {
            R.id.home_adapter_block_0 -> {
                val url = item.homeWebsiteLink
                ARouter.getInstance().build(ModuleRouter.Pub.H5.ACTIVITY)
                    .withString("url", url)
                    .navigation()
            }
            R.id.home_adapter_block_1 -> {
                val url = item.homePlLink
                ARouter.getInstance().build(ModuleRouter.Pub.H5.ACTIVITY)
                    .withString("url", url)
                    .navigation()
            }
            R.id.home_adapter_block_2 -> {
                val url = item.homeGithubLink
                ARouter.getInstance().build(ModuleRouter.Pub.H5.ACTIVITY)
                    .withString("url", url)
                    .navigation()
            }
        }
    }
}