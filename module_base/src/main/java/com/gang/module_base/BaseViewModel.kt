package com.gang.module_base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gang.lib_base.LogUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
//    var repository: BaseRepository? = null

//    init {
//        this.repository = xxx
//    }

    fun go(block: suspend CoroutineScope.() -> Unit){
        viewModelScope.launch {
            block()
        }
    }

    override fun onCleared() {
        super.onCleared()
        LogUtils.print("onCleared", tag = javaClass.simpleName)

//        repository = null
    }

}