package com.gang.module_main.ad

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.ToastUtils
import com.gang.module_base.BaseFragment
import com.gang.module_main.R
import com.gang.module_main.databinding.FragmentAdvertBinding
import com.gang.module_router.ModuleRouter

class AdvertFragment : BaseFragment() {

    lateinit var dataBinding: FragmentAdvertBinding
    lateinit var viewModel: AdvertViewModel

    var timer: CountDownTimer? = null

    override fun onStop() {
        super.onStop()
        timer?.cancel()
    }

    override fun getRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_advert, container, false)
        viewModel = ViewModelProvider(this).get(AdvertViewModel::class.java)

        dataBinding.vm = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun initView() {
    }

    override fun initListener() {
        dataBinding.advertGo.setOnClickListener {
//            ARouter.getInstance().build(ModuleRouter.MAIN_GUIDE)
//                .withTransition(R.anim.activity_in, R.anim.activity_out)
//                .navigation(requireContext())
//            requireActivity().finish()
            ARouter.getInstance().build(ModuleRouter.MAIN_INDEX).navigation()
            requireActivity().finish()
        }
    }

    override fun initOther() {
        viewModel.getAdvertData()

        timer = object : CountDownTimer(10000, 1000) {
            override fun onFinish() {
                ToastUtils.show(requireContext(), "跳过了")
            }

            override fun onTick(millisUntilFinished: Long) {
                dataBinding.advertGo.text = "跳过${millisUntilFinished / 1000}"
            }
        }
        timer?.start()
    }

}