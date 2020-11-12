package com.gang.module_main.ad

import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AdvertViewModel : BaseViewModel() {

    fun getAdvertData() {
        go {
            withContext(Dispatchers.Default){
                LogUtils.print("2222"+Thread.currentThread().name)
                Thread.sleep(5000)
                LogUtils.print("2222"+Thread.currentThread().name)
            }

            LogUtils.print("1111"+Thread.currentThread().name)
        }

    }

}