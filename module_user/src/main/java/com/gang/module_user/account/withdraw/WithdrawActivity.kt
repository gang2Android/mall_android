package com.gang.module_user.account.withdraw

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R

@Route(path = ModuleRouter.User.Account.Withdraw.ACTIVITY)
class WithdrawActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.user_activity_withdraw)

        supportActionBar?.hide()

        val type = intent.getIntExtra("type", 1)
        val money = intent.getDoubleExtra("money", 0.00)

        val fragment =
            ARouter.getInstance().build(ModuleRouter.User.Account.Withdraw.FRAGMENT)
                .withInt("type", type)
                .withDouble("money", money)
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }

}