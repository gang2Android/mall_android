package com.gang.module_user.address.det

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R
import com.gang.module_user.address.AddressItemBean

@Route(path = ModuleRouter.USER_ADDRESS_DET_ACTIVITY)
class AddressDetActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.user_activity_address_det)

        supportActionBar?.hide()

        var item = intent.getSerializableExtra("data")
        if (item != null)
            item = item as AddressItemBean

        val fragment =
            ARouter.getInstance().build(ModuleRouter.USER_ADDRESS_DET)
                .withSerializable("data", item)
                .navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment, "f1")
            .commit()
    }

}