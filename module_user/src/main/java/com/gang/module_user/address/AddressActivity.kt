package com.gang.module_user.address

import android.content.Intent
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R

@Route(path = ModuleRouter.USER_ADDRESS_LIST_ACTIVITY)
class AddressActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.user_activity_address_list)

        supportActionBar?.hide()

        val isSelect = intent.getBooleanExtra("isSelect", false)

        val fragment =
            ARouter.getInstance().build(ModuleRouter.USER_ADDRESS_LIST)
                .withBoolean("isSelect", isSelect)
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment, "f1")
            .commit()
    }

    fun exit(code: Int, data: Intent) {
        setResult(code, data)
        finish()
    }

}