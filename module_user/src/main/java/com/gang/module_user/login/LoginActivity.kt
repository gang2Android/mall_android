package com.gang.module_user.login

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R

@Route(path = ModuleRouter.USER_LOGIN_ACTIVITY)
class LoginActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.user_activity_login)

        supportActionBar?.hide()

        val fragment = ARouter.getInstance().build(ModuleRouter.USER_LOGIN).navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }
}