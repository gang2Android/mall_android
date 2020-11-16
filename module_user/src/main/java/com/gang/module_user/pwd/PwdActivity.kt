package com.gang.module_user.pwd

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R

@Route(path = ModuleRouter.USER_PWD_ACT)
class PwdActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.user_activity_pwd)

        supportActionBar?.hide()

        val isLogin = intent.getBooleanExtra("isLogin", true)

        val fragment = ARouter.getInstance().build(ModuleRouter.USER_PWD)
            .withBoolean("isLogin", isLogin)
            .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }

}