package com.gang.module_main.guide

import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.module_base.BaseActivity
import com.gang.module_main.R
import com.gang.module_router.ModuleRouter

//@Route(path = MainConstant.PATH_GUIDE)
@Route(path = ModuleRouter.MAIN_GUIDE)
class GuideActivity : BaseActivity() {

    override fun initDBVM() {
        setContentView(R.layout.activity_guide)

        supportActionBar?.hide()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, GuideFragment(), "f1")
            .commit()
    }

}