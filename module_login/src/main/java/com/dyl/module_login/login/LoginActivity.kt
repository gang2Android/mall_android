package com.dyl.module_login.login

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dyl.module_login.R
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.Login.Login.ACTIVITY)
class LoginActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.login_activity_login)

        supportActionBar?.hide()

        val fragment = ARouter.getInstance().build(ModuleRouter.Login.Login.FRAGMENT).navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }
}