package com.gang.module_base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gang.lib_base.LogUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    fun go(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            block()
        }
    }

    override fun onCleared() {
        super.onCleared()
        LogUtils.print("onCleared", tag = javaClass.simpleName)
    }

}