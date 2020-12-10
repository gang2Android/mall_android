package com.gang.module_main

import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseActivity
import com.gang.module_router.ModuleRouter
import com.google.android.material.bottomnavigation.BottomNavigationView

@Route(path = ModuleRouter.MAIN_INDEX)
class MainActivity : BaseActivity() {

    var homeFragment: Fragment? = null
    var classifyFragment: Fragment? = null
    var cartFragment: Fragment? = null
    var userFragment: Fragment? = null

    override fun initDBVM() {
        setContentView(R.layout.main_activity_main)

        supportActionBar?.hide()

        val bot: BottomNavigationView = this.findViewById(R.id.main_bot)
        bot.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                LogUtils.print("item=${item.isChecked}", tag = "MainActivity")
                if (item.isChecked)
                    return true
                when (item.itemId) {
                    R.id.main_home -> {
                        showHome()
                    }
                    R.id.main_classify -> {
                        showClassify()
                    }
                    R.id.main_cart -> {
                        showCart()
                    }
                    R.id.main_user -> {
                        showUser()
                    }
                }
                return true
            }
        })
        showHome()
    }

    fun showHome() {
        val tran = supportFragmentManager.beginTransaction()
        if (homeFragment == null) {
            val fragment =
                ARouter.getInstance().build(ModuleRouter.HOME_INDEX)
                    .withString("name", "home")
                    .navigation() ?: return
            homeFragment = fragment as Fragment
            tran.add(R.id.fragment, homeFragment!!)
        }
//        homeFragment?.let {
//            tran.hide(it)
//        }
        classifyFragment?.let {
            tran.hide(it)
        }
        cartFragment?.let {
            tran.hide(it)
        }
        userFragment?.let {
            tran.hide(it)
        }
        tran.show(homeFragment!!)
        tran.commit()
    }

    fun showClassify() {
        val tran = supportFragmentManager.beginTransaction()
        if (classifyFragment == null) {
            val fragment =
                ARouter.getInstance().build(ModuleRouter.GOODS_CLASSIFY).navigation() ?: return
            classifyFragment = fragment as Fragment
            tran.add(R.id.fragment, classifyFragment!!)
        }
        homeFragment?.let {
            tran.hide(it)
        }
//        classifyFragment?.let {
//            tran.hide(it)
//        }
        cartFragment?.let {
            tran.hide(it)
        }
        userFragment?.let {
            tran.hide(it)
        }
        tran.show(classifyFragment!!)
        tran.commit()
    }

    fun showCart() {
        val tran = supportFragmentManager.beginTransaction()
        if (cartFragment == null) {
            val fragment =
                ARouter.getInstance().build(ModuleRouter.CART_INDEX).navigation() ?: return
            cartFragment = fragment as Fragment
            tran.add(R.id.fragment, cartFragment!!)
        }
        homeFragment?.let {
            tran.hide(it)
        }
        classifyFragment?.let {
            tran.hide(it)
        }
//        cartFragment?.let {
//            tran.hide(it)
//        }
        userFragment?.let {
            tran.hide(it)
        }
        tran.show(cartFragment!!)
        tran.commit()
    }

    fun showUser() {
        val tran = supportFragmentManager.beginTransaction()
        if (userFragment == null) {
            val fragment = ARouter.getInstance().build(ModuleRouter.USER_ME).navigation() ?: return
            userFragment = fragment as Fragment
            tran.add(R.id.fragment, userFragment!!)
        }
        homeFragment?.let {
            tran.hide(it)
        }
        classifyFragment?.let {
            tran.hide(it)
        }
        cartFragment?.let {
            tran.hide(it)
        }
//        userFragment?.let {
//            tran.hide(it)
//        }
        tran.show(userFragment!!)
        tran.commit()
    }

}