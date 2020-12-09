package com.gang.module_login.reg

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_login.R
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.Login.Reg.ACTIVITY)
class RegActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.login_activity_reg)

        supportActionBar?.hide()

        val fragment = ARouter.getInstance().build(ModuleRouter.Login.Reg.FRAGMENT).navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }
}