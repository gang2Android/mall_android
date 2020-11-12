package com.gang.module_main.sp

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel

class SplashViewModel : BaseViewModel() {
    var name = MutableLiveData<String>()

    init {
        name.value = "1111"
    }
}