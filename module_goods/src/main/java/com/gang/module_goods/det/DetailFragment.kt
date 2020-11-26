package com.gang.module_goods.det

import android.os.Bundle
import android.transition.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.lib_base.ImageLoader
import com.gang.lib_base.LogUtils
import com.gang.lib_base.ToastUtils
import com.gang.lib_base.onEnd
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
        val width = requireContext().resources.displayMetrics.widthPixels
        val imgLayoutParams = ConstraintLayout.LayoutParams(width, width)
        imgLayoutParams.topToBottom = ConstraintLayout.LayoutParams.TOP
        dataBinding.detImg.layoutParams = imgLayoutParams
    }

    override fun initListener() {
        dataBinding.detBack.setOnClickListener { exit() }

        dataBinding.detScroll.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            LogUtils.print("scrollX=${scrollX},scrollY=${scrollY},oldScrollX=${oldScrollX},oldScrollY=${oldScrollY}")
            if (scrollY >= 100) {
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
        dataBinding.detSpecSelect.setOnClickListener { openSpecSelect() }
        dataBinding.detTemp4.setOnClickListener { openSpecSelect() }
        dataBinding.detAddressSelect.setOnClickListener { openAddressSelect() }
        dataBinding.detTemp6.setOnClickListener { openAddressSelect() }
        dataBinding.detStore.setOnClickListener { ToastUtils.show(requireContext(), "打开商家详情") }
    }

    override fun initOther() {
        arguments!!.getString("id")?.let {
            viewModel.getDetail(it)
        }
        val imgPath = arguments!!.getString("url", "")
        val name = arguments!!.getString("name", "")

        requireActivity().window.sharedElementEnterTransition = TransitionSet()
            .addTransition(ChangeImageTransform())
            .addTransition(ChangeBounds())
//                .apply {
//                    onEnd {
//                        ImageLoader.load(dataBinding.detImg, "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png")
//                    }
//                }
        requireActivity().window.enterTransition = Fade()
        requireActivity().postponeEnterTransition()
        ImageLoader.load(dataBinding.detImg, imgPath)
        requireActivity().startPostponedEnterTransition()
        dataBinding.detName.text = name
    }

    private fun openSpecSelect() {
        ToastUtils.show(requireContext(), "选择规格")
    }

    private fun openAddressSelect() {
        ToastUtils.show(requireContext(), "选择收货地址")
    }

}