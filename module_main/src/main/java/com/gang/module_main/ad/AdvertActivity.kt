package com.gang.module_main.ad

import android.graphics.Color
import com.alibaba.android.arouter.facade.annotation.Route
import com.gang.module_base.BaseActivity
import com.gang.module_main.R
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.MAIN_ADVERT)
class AdvertActivity : BaseActivity() {

    override fun initDBVM() {
        setContentView(R.layout.activity_advert)

        supportActionBar?.hide()
        setStatusBar(Color.parseColor("#D6171F"), 100)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, AdvertFragment(), "f1")
            .commit()
    }
}