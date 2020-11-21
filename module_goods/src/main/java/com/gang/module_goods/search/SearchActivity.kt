package com.gang.module_goods.search

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_goods.R
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.Goods.Search.ACTIVITY)
class SearchActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.goods_activity_search)

        supportActionBar?.hide()

        val fragment =
            ARouter.getInstance().build(ModuleRouter.Goods.Search.FRAGMENT)
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }
}