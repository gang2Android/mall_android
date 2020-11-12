package com.gang.module_home

import android.graphics.Color
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.HOME_INDEX_ACTIVITY)
class HomeActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.home_activity_home)

        supportActionBar?.hide()
        setStatusBar(Color.parseColor("#D6171F"), 100)

//        val fragment = ARouter.getInstance().build(HomeConstant.PATH_HOME).navigation() as Fragment
        val fragment = ARouter.getInstance().build(ModuleRouter.HOME_INDEX).navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }

}