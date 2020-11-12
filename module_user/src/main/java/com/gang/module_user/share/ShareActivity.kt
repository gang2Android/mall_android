package com.gang.module_user.share

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.module_base.BaseActivity
import com.gang.module_base.StatusBarUtils
import com.gang.module_router.ModuleRouter
import com.gang.module_user.R

@Route(path = ModuleRouter.USER_SHARE_ACT)
class ShareActivity : BaseActivity() {
    override fun initDBVM() {
        setContentView(R.layout.user_activity_share)

        supportActionBar?.hide()

        val fragment = ARouter.getInstance().build(ModuleRouter.USER_SHARE).navigation() as Fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, fragment, "f1")
            .commit()
    }

}