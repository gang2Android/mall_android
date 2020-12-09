package com.gang.module_pub.h5

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_pub.R
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.Pub.H5.ACTIVITY)
class H5Activity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.pub_activity_h5)

        supportActionBar?.hide()

        val url = intent.getStringExtra("url") ?: ""

        val fragment =
            ARouter.getInstance().build(ModuleRouter.Pub.H5.FRAGMENT)
                .withString("url", url)
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }
}