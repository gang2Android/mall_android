package com.gang.module_user.account

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R

@Route(path = ModuleRouter.USER_ACCOUNT_ACT)
class AccountActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.user_activity_account)

        supportActionBar?.hide()

        val type = intent.getIntExtra("type", 1)

        val fragment =
            ARouter.getInstance().build(ModuleRouter.USER_ACCOUNT)
                .withInt("type", type)
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }

}