package com.gang.module_main.sp

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_main.R
import com.gang.module_main.databinding.ActivitySplashBinding
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.MAIN_SPLASH)
class SplashActivity : BaseActivity() {

    private var splashBinding: ActivitySplashBinding? = null
    private var splashViewModel: SplashViewModel? = null

    override fun initDBVM() {
//        setTheme(R.style.SplashTheme)

        splashBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_splash
        )
        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        splashBinding?.lifecycleOwner = this
        splashBinding?.vm = splashViewModel

//        ARouter.getInstance().build(MainConstant.PATH_ADVERT).withTransition(R.anim.activity_in, R.anim.activity_out).navigation(this)
        ARouter.getInstance().build(ModuleRouter.MAIN_ADVERT)
            .withTransition(R.anim.activity_in, R.anim.activity_out).navigation(this)
        finish()
    }
}