package com.gang.module_order.det

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_order.R
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.ORDER_DET_ACT)
class OrderDetActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.order_activity_det)

        supportActionBar?.hide()

        val orderNo = intent.getStringExtra("no") ?: ""

        val fragment =
            ARouter.getInstance().build(ModuleRouter.ORDER_DET)
                .withString("no", orderNo)
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment, "f1")
            .commit()
    }
}