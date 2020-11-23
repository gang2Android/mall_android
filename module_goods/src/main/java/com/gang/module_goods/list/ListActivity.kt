package com.gang.module_goods.list

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_goods.R
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.Goods.List.ACTIVITY)
class ListActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.goods_activity_list)

        supportActionBar?.hide()

        val key = intent.getStringExtra("key") ?: ""
        val region = intent.getIntExtra("region", 0)

        val fragment =
            ARouter.getInstance().build(ModuleRouter.Goods.List.FRAGMENT)
                .withString("key", key)
                .withInt("region", region)
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }
}