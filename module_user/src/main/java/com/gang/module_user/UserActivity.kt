package com.gang.module_user

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter

class UserActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.user_activity_user)

        supportActionBar?.hide()

        val fragment = ARouter.getInstance().build(ModuleRouter.USER_ME).navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }

}