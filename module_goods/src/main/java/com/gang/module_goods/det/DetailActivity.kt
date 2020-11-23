package com.gang.module_goods.det

import android.transition.Transition
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseActivity
import com.gang.module_goods.R
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.Goods.Det.ACTIVITY)
class DetailActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.goods_activity_det)

        supportActionBar?.hide()

        val id = intent.getStringExtra("id") ?: ""
        if (id == "") {
            finish()
            return
        }

        val url = intent.getStringExtra("url") ?: ""

        val fragment =
            ARouter.getInstance().build(ModuleRouter.Goods.Det.FRAGMENT)
                .withString("id", id)
                .withString("url", url)
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }
}