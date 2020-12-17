package com.gang.component_order.pay

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.component_order.R
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.ORDER_PAY_ACT)
class PayActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.order_activity_pay)

        supportActionBar?.hide()

        val no = intent.getStringExtra("no") ?: ""

        val fragment =
            ARouter.getInstance().build(ModuleRouter.ORDER_PAY)
                .withString("no", no)
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment, "f1")
            .commit()
    }

}