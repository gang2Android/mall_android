package com.gang.module_user.set

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R

@Route(path = ModuleRouter.USER_SET_ACT)
class SetActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.user_activity_set)

        supportActionBar?.hide()

        val fragment = ARouter.getInstance().build(ModuleRouter.USER_SET).navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }
}