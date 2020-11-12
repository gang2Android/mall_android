package com.gang.module_order.affirm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseActivity
import com.gang.module_order.R
import com.gang.module_router.ModuleRouter

@Route(path = ModuleRouter.ORDER_AFFIRM_ACT)
class OrderAffirmActivity : BaseActivity() {

    private lateinit var fragment: AffirmFragment

    override fun initDBVM() {
        setContentView(R.layout.order_activity_affirm)

        supportActionBar?.hide()

        val ids = "1"

        fragment = AffirmFragment()
        val bundle = Bundle()
        bundle.putString("ids", ids)
        fragment.arguments = bundle

//        val fragment =
//            ARouter.getInstance().build(ModuleRouter.ORDER_AFFIRM)
//                .withString("ids", ids)
//                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment, "f1")
            .commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) return
        if (data == null) return
        when (requestCode) {
            1001 -> {
                fragment.setAddress(data.getStringExtra("data")!!)
            }
        }
    }

}