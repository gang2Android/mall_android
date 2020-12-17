package com.gang.component_order.list

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.component_order.R
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.ORDER_LIST_ACT)
class OrderListActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.order_activity_list)

        supportActionBar?.hide()

        val type = intent.getIntExtra("type", 0)

        val fragment =
            ARouter.getInstance().build(ModuleRouter.ORDER_LIST)
                .withInt("type", type)
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment, "f1")
            .commit()
    }
}