package com.gang.module_main.guide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseFragment
import com.gang.module_base.widget.flowview.FlowGuideView
import com.gang.module_main.R
import com.gang.module_main.databinding.FragmentGuideBinding
import com.gang.module_router.ModuleRouter

class GuideFragment : BaseFragment() {

    lateinit var dataBinding: FragmentGuideBinding
    lateinit var viewModel: GuideViewModel

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_guide, container, false)
        viewModel = ViewModelProvider(this).get(GuideViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
    }

    override fun initListener() {
        dataBinding.guideStart.setOnClickListener {
            dataBinding.guideView.open()
        }
        dataBinding.guideView.callBack = object : FlowGuideView.CallBack {
            override fun end() {
                LogUtils.print("end")
//                ARouter.getInstance().build(MainConstant.PATH_MAIN).navigation()
                ARouter.getInstance().build(ModuleRouter.MAIN_INDEX).navigation()
//                startActivity(Intent(requireContext(),MainActivity::class.java))
                requireActivity().finish()
            }
        }
    }

    override fun initOther() {
        dataBinding.guideView.addGuides(
            R.drawable.splash_guide_0,
            R.drawable.splash_guide_1,
            R.drawable.splash_guide_2
        )

    }

}